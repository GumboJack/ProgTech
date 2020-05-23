package BreweryClient;

import ModelsTest.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientGUI extends JFrame{
    private JPanel mainPanel;
    private JRadioButton hopFilter;
    private JRadioButton maltFilter;
    private JRadioButton yiestFilter;
    private JButton calculateButton;
    private JTextField literInput;
    private JLabel priceLabel;
    private JButton addIngredientButton;
    private JButton deleteIngredientButton;
    private JList storeList;
    private JRadioButton otherFilter;
    private JScrollPane storePane;
    private JScrollPane ingredientsPane;
    private JList ingredientsList;
    private JTextField forLiterInput;
    private BreweryStockObserver observer = new BreweryStockObserver(this);
    private DefaultListModel storeListModel;
    private DefaultListModel ingredientListModel;
    private ArrayList<Ingredient> filteredList;
    private ArrayList<Ingredient> selectedIngredients;

    public BreweryStockObserver getObserver(){
        return observer;
    }

    public ClientGUI(){
        super("Brewery Client");

        storeListModel = new DefaultListModel();
        storeList.setModel(storeListModel);
        ingredientListModel = new DefaultListModel();
        ingredientsList.setModel(ingredientListModel);
        filterIngredients();

        hopFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore();
            }
        });
        maltFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore();
            }
        });
        yiestFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore();
            }
        });
        otherFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore();
            }
        });

        deleteIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!ingredientsList.isSelectionEmpty()){
                        selectedIngredients.remove(ingredientsList.getSelectedIndex());
                        updateIngredients();
                    }
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });

        selectedIngredients = new ArrayList<Ingredient>();
        addIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(!storeList.isSelectionEmpty()){
                        Ingredient ingredient = filteredList.get(storeList.getSelectedIndex());
                        boolean exist = false;
                        for (Ingredient ing:
                                selectedIngredients) {
                            if(ing.getItemName().equals(ingredient.getItemName())){
                                exist = true;
                                ing.setQuantity(ing.getQuantity()+1);
                                updateIngredients();
                            }
                        }
                        if(!exist){
                            if(ingredient instanceof Hop){
                                selectedIngredients.add(new Hop((Hop)ingredient));
                            } else if(ingredient instanceof Malt){
                                selectedIngredients.add(new Malt((Malt)ingredient));
                            } else if(ingredient instanceof Yiest){
                                selectedIngredients.add(new Yiest((Yiest)ingredient));
                            } else if(ingredient instanceof OtherIngredient){
                                selectedIngredients.add(new OtherIngredient((OtherIngredient)ingredient));
                            }
                            updateIngredients();
                        }
                    }
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }

            }
        });

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int liter = Integer.parseInt(literInput.getText());
                    int forLiter = Integer.parseInt(forLiterInput.getText());
                    ArrayList<Hop> hops = new ArrayList<Hop>();
                    ArrayList<Malt> malts = new ArrayList<Malt>();
                    ArrayList<Yiest> yiests = new ArrayList<Yiest>();
                    ArrayList<OtherIngredient> others = new ArrayList<OtherIngredient>();

                    refreshPrices();
                    for (Ingredient ingredient:
                         selectedIngredients) {
                        if (ingredient instanceof Hop){
                            hops.add((Hop)ingredient);
                        } else if (ingredient instanceof Malt){
                            malts.add((Malt) ingredient);
                        }else if (ingredient instanceof Yiest){
                            yiests.add((Yiest)ingredient);
                        } else  if (ingredient instanceof OtherIngredient){
                            others.add((OtherIngredient) ingredient);
                        }
                    }

                    Recipe recipe = new Recipe(
                            "",
                            forLiter,
                            0, 0, 0, false, false,
                            hops, malts, yiests, others
                    );

                    BeerCost beer = new Beer(new Wort(new Mash(new Water(), recipe), recipe), recipe);

                    priceLabel.setText(beer.getCost(liter) + "Ft / " + liter + "L");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(mainPanel, "Invalid input formats");
                    System.out.println(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public void fillStore(){
        filterIngredients();
        storeListModel.removeAllElements();
        for(int i = 0; i < filteredList.size(); i++){
            storeListModel.add(i, filteredList.get(i).getItemName() + "          " + filteredList.get(i).getStockPrice() + "/" +
                    filteredList.get(i).getPackVolume() + UnitHelper.unitConverter(filteredList.get(i).getUnit()));
        }
    }

    private void filterIngredients(){
        filteredList = new ArrayList<Ingredient>();
        for (Ingredient ingredient:
             observer.getObservedStock()) {
            if (hopFilter.isSelected() && ingredient instanceof Hop){
                filteredList.add(ingredient);
            }
            if (maltFilter.isSelected() && ingredient instanceof Malt){
                filteredList.add(ingredient);
            }
            if (yiestFilter.isSelected() && ingredient instanceof Yiest){
                filteredList.add(ingredient);
            }
            if (otherFilter.isSelected() && ingredient instanceof OtherIngredient){
                filteredList.add(ingredient);
            }
        }
    }

    private void updateIngredients(){
        ingredientListModel.removeAllElements();
        for (Ingredient ing:
             selectedIngredients) {
            ingredientListModel.addElement(ing.getItemName() + " " + ing.getPackVolume() * ing.getQuantity() + UnitHelper.unitConverter(ing.getUnit()));
        }
    }

    private void refreshPrices(){
        for (Ingredient selectedingredient:
             selectedIngredients) {
            for (Ingredient stockingredient:
                 observer.getObservedStock()) {
                if(selectedingredient.getItemName().equals(stockingredient.getItemName())){
                    selectedingredient.setStockPrice(stockingredient.getStockPrice());
                }
            }
        }
    }
}
