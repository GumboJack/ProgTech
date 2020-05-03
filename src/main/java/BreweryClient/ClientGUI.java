package BreweryClient;

import Models.Ingredient;
import Models.UnitHelper;

import javax.swing.*;
import java.util.ArrayList;

public class ClientGUI extends JFrame{
    private JPanel mainPanel;
    private JRadioButton hopFilter;
    private JRadioButton maltFilter;
    private JRadioButton yiestFilter;
    private JLabel storeLabel;
    private JLabel beerLabel;
    private JList beerList;
    private JButton deleteButton;
    private JButton addButton;
    private JButton editButton;
    private JButton calculateButton;
    private JTextField literInput;
    private JLabel priceLabel;
    private JList ingredientList;
    private JButton addIngredientButton;
    private JButton deleteIngredientButton;
    private JList storeList;
    private JTextField beerNameInput;
    private JRadioButton otherFilter;


    public ClientGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new ClientGUI("BreweryClient");
        frame.setVisible(true);
    }

    public void fillStore(ArrayList<Ingredient> store){
        DefaultListModel list = new DefaultListModel();
        for (Ingredient ingredient:
             store) {
            list.addElement(ingredient.getItemName() + "          " + ingredient.getStockPrice() + "/" + UnitHelper.unitConverter(ingredient.getUnit()));
        }
        storeList = new JList(list);
    }
}
