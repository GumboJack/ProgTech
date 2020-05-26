package BreweryStockMarket;

import Models.UnitHelper;
import Models.UnitType;

import javax.swing.*;
import java.awt.event.*;
import java.util.Observer;


public class StockServiceGUI extends JFrame{
    private JPanel mainPanel;
    private JTextField inputName;
    private JButton btnAdd;
    private JComboBox unitSelector;
    private JComboBox typeSelector;
    private JLabel txtAlphaAcid;
    private JLabel txtUnit;
    private JTextField inputStockPrice;
    private JTextField inputQuantity;
    private JTextField inputMaxIncrease;
    private JTextField inputMinIncrease;
    private JTextField inputMaxDecrease;
    private JTextField inputMinDecrease;
    private JTextField inputAlphaAcid;
    private JLabel invalidStockPrice;
    private JLabel invalidQuantity;
    private JLabel invalidMaxIncrease;
    private JLabel invalidMinIncrease;
    private JLabel invalidMaxDecrease;
    private JLabel invalidMinDecrease;
    private JLabel invalidAlphaAcid;
    private BreweryStock stock = BreweryStock.getInstance();

    public void addObserver(Observer observer){
        stock.addObserver(observer);
    }

    public StockServiceGUI(){
        super("Brewery stock service");

        typeSelector.addItem(new TypeComboItem("Hop", 'h'));
        typeSelector.addItem(new TypeComboItem("Malt", 'm'));
        typeSelector.addItem(new TypeComboItem("Yiest", 'y'));
        typeSelector.addItem(new TypeComboItem("Other Ingredient", 'o'));

        for (UnitType unit:
             UnitType.values()) {
            unitSelector.addItem(new UnitComboItem(UnitHelper.unitConverter(unit), unit));
        }

        inputAlphaAcid.setVisible(true);
        txtAlphaAcid.setVisible(true);
        unitSelector.setVisible(false);
        txtUnit.setVisible(false);
        typeSelector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(((TypeComboItem)typeSelector.getSelectedItem()).getKey() == "Hop"){
                    inputAlphaAcid.setVisible(true);
                    txtAlphaAcid.setVisible(true);
                    unitSelector.setVisible(false);
                    txtUnit.setVisible(false);
                } else if(((TypeComboItem)typeSelector.getSelectedItem()).getKey() == "Other Ingredient"){
                    inputAlphaAcid.setVisible(false);
                    txtAlphaAcid.setVisible(false);
                    unitSelector.setVisible(true);
                    txtUnit.setVisible(true);
                } else {
                    inputAlphaAcid.setVisible(false);
                    txtAlphaAcid.setVisible(false);
                    unitSelector.setVisible(false);
                    txtUnit.setVisible(false);
                }
            }
        });

        setDoubleField(inputStockPrice, invalidStockPrice);
        setIntegerField(inputQuantity, invalidQuantity);
        setDoubleField(inputMaxIncrease, invalidMaxIncrease);
        setDoubleField(inputMinIncrease, invalidMinIncrease);
        setDoubleField(inputMaxDecrease, invalidMaxDecrease);
        setDoubleField(inputMinDecrease, invalidMinDecrease);
        setIntegerField(inputAlphaAcid, invalidAlphaAcid);


        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Inputs: \n");
                sb.append(inputName.getText() + inputName.getText().isEmpty() + "\n");
                sb.append(inputStockPrice.getText()+ inputStockPrice.getText().isEmpty() + "\n");
                sb.append(inputQuantity.getText()+ inputQuantity.getText().isEmpty() + "\n");
                sb.append(inputMaxIncrease.getText()+ inputMaxIncrease.getText().isEmpty() + "\n");
                sb.append(inputMinIncrease.getText()+ inputMinIncrease.getText().isEmpty() + "\n");
                sb.append(inputMinDecrease.getText()+ inputMinIncrease.getText().isEmpty() + "\n");
                sb.append(inputMaxDecrease.getText()+ inputMaxDecrease.getText().isEmpty() + "\n");
                sb.append(inputAlphaAcid.getText()+ inputAlphaAcid.getText().isEmpty() + "\n");
                System.out.println(sb.toString());

                char ingredienttype = ((TypeComboItem)typeSelector.getSelectedItem()).getValue();
                String itemName = inputName.getText();
                UnitType unit = ((UnitComboItem)unitSelector.getSelectedItem()).getUnit();
                double alphaAcid = 0;
                int quantity = 0;
                double stockPrice = 0;
                double minInc = 0;
                double maxInc = 0;
                double minDec = 0;
                double maxDec = 0;


                if (inputName.getText().isEmpty() ||
                        inputStockPrice.getText().isEmpty() ||
                        inputQuantity.getText().isEmpty() ||
                        inputMinIncrease.getText().isEmpty() ||
                        inputMaxIncrease.getText().isEmpty() ||
                        inputMinDecrease.getText().isEmpty() ||
                        inputMaxDecrease.getText().isEmpty() ||
                        (ingredienttype == 'h' && inputAlphaAcid.getText().isEmpty())
                ){
                    JOptionPane.showMessageDialog(mainPanel, "All input fields are required!");
                } else {
                    try{
                        quantity = Integer.parseInt(inputQuantity.getText());
                        stockPrice = Double.parseDouble(inputStockPrice.getText());
                        minInc = Double.parseDouble(inputMinIncrease.getText());
                        maxInc = Double.parseDouble(inputMaxIncrease.getText());
                        minDec = Double.parseDouble(inputMinDecrease.getText());
                        maxDec = Double.parseDouble(inputMaxDecrease.getText());
                        if (ingredienttype == 'h'){
                            alphaAcid = Integer.parseInt(inputAlphaAcid.getText()) / 100;
                        }
                        stock.addIngredient(ingredienttype, alphaAcid, itemName, stockPrice, quantity, minInc, maxInc, minDec, maxDec, unit);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(mainPanel, "Invalid input formats");
                        System.out.println(ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }
        });

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    private void setIntegerField(final JTextField field, final JLabel errorMessage){
        KeyAdapter doubleKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try{
                    int i = Integer.parseInt(field.getText());
                    errorMessage.setText("");
                } catch(NumberFormatException ex){
                    errorMessage.setText("invalid format");
                }
            }
        };
        field.addKeyListener(doubleKeyListener);
    }

    private void setDoubleField(final JTextField field, final JLabel errorMessage){
        KeyAdapter intKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                try{
                    double d = Double.parseDouble(field.getText());
                    errorMessage.setText("");
                } catch(NumberFormatException ex){
                    errorMessage.setText("invalid format");
                }
            }
        };
        field.addKeyListener(intKeyListener);
    }

}

class TypeComboItem {
    private String key;
    private char value;

    public TypeComboItem(String key, char value){
        this.key = key;
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return this.getKey();
    }
}

class UnitComboItem{
    private String key;
    private UnitType unit;

    public UnitComboItem(String key, UnitType unit) {
        this.key = key;
        this.unit = unit;
    }

    public String getKey() {
        return key;
    }

    public UnitType getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return this.getKey();
    }
}
