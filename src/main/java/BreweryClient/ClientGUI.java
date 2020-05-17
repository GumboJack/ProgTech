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

        selectedIngredients = new ArrayList<Ingredient>();
        addIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingredient ingredient = filteredList.get(storeList.getSelectedIndex());
                boolean exist = false;
                for (Ingredient ing:
                     selectedIngredients) {
                    if(ing.getItemName().equals(ingredient.getItemName())){
                        exist = true;
                        ing.setQunantity(ing.getQunantity() + ingredient.getQunantity());
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
                    filteredList.get(i).getQunantity() + UnitHelper.unitConverter(filteredList.get(i).getUnit()));
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
            ingredientListModel.addElement(ing.getItemName() + " " + ing.getQunantity() + UnitHelper.unitConverter(ing.getUnit()));
        }
    }
}
