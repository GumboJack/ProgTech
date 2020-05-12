package BreweryClient;

import Models.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClientGUI extends JFrame{
    private JPanel mainPanel;
    private JRadioButton hopFilter;
    private JRadioButton maltFilter;
    private JRadioButton yiestFilter;
    private JLabel storeLabel;
    private JLabel beerLabel;
    private JButton deleteButton;
    private JButton addButton;
    private JButton editButton;
    private JButton calculateButton;
    private JTextField literInput;
    private JLabel priceLabel;
    private JButton addIngredientButton;
    private JButton deleteIngredientButton;
    private JList storeList;
    private JTextField beerNameInput;
    private JRadioButton otherFilter;
    private JScrollPane storePane;
    private JScrollPane recipePane;
    private JList recipeList;
    private JScrollPane ingredientsPane;
    private JList ingredientsList;
    private BreweryStockObserver observer = new BreweryStockObserver(this);
    private DefaultListModel defaultListModel;

    public BreweryStockObserver getObserver(){
        return observer;
    }

    public ClientGUI(){
        super("Brewery Client");

        defaultListModel = new DefaultListModel();
        storeList.setModel(defaultListModel);

        hopFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore(observer.getObservedStock());
            }
        });
        maltFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore(observer.getObservedStock());
            }
        });
        yiestFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore(observer.getObservedStock());
            }
        });
        otherFilter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fillStore(observer.getObservedStock());
            }
        });


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public void fillStore(ArrayList<Ingredient> store){
        store = filterIngredients(store, hopFilter.isSelected(), maltFilter.isSelected(), yiestFilter.isSelected(), otherFilter.isSelected());
        if(!defaultListModel.isEmpty()){
            defaultListModel.removeAllElements();
        }
        for (Ingredient ingredient:
             store) {
            defaultListModel.addElement(ingredient.getItemName() + "          " + ingredient.getStockPrice() + "/" +
                    ingredient.getQunantity()+ UnitHelper.unitConverter(ingredient.getUnit()));
        }
    }

    private ArrayList<Ingredient> filterIngredients(ArrayList<Ingredient> ingredients, boolean hop, boolean malt, boolean yiest, boolean other){
        ArrayList<Ingredient> filteredList = new ArrayList<Ingredient>();
        for (Ingredient ingredient:
             ingredients) {
            if (hop && ingredient instanceof Hop){
                filteredList.add(ingredient);
            }
            if (malt && ingredient instanceof Malt){
                filteredList.add(ingredient);
            }
            if (yiest && ingredient instanceof Yiest){
                filteredList.add(ingredient);
            }
            if (other && ingredient instanceof OtherIngredient){
                filteredList.add(ingredient);
            }
        }
        return filteredList;
    }
}
