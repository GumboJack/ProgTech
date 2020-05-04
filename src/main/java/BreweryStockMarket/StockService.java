package BreweryStockMarket;

import Models.UnitHelper;
import Models.UnitType;

import javax.swing.*;
import java.awt.event.*;


public class StockService extends JFrame{
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
    BreweryStock stock = BreweryStock.getInstance();
    private boolean validInputFormat = false;

    public StockService(){
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
                sb.append(inputName.getText() + "\n");
                sb.append(inputStockPrice.getText() + "\n");
                sb.append(inputQuantity.getText() + "\n");
                sb.append(inputMaxIncrease.getText() + "\n");
                sb.append(inputMinIncrease.getText() + "\n");
                sb.append(inputMinDecrease.getText() + "\n");
                sb.append(inputMaxDecrease.getText() + "\n");
                sb.append(inputAlphaAcid.getText() + "\n");
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

                try{
                    if (ingredienttype == 'h'){
                        alphaAcid = Integer.parseInt(inputAlphaAcid.getText()) / 100;
                    }
                    quantity = Integer.parseInt(inputQuantity.getText());
                    stockPrice = Double.parseDouble(inputMinIncrease.getText());
                    minInc = Double.parseDouble(inputMinIncrease.getText());
                    maxInc = Double.parseDouble(inputMaxIncrease.getText());
                    minDec = Double.parseDouble(inputMinDecrease.getText());
                    maxDec = Double.parseDouble(inputMaxDecrease.getText());
                    validInputFormat = true;
                }catch (Throwable t){
                    System.out.println(t.getMessage());
                    System.out.println(t.getStackTrace().toString());
                    validInputFormat = false;
                }

                if (inputName.getText() == "" ||
                        inputStockPrice.getText() == "" ||
                        inputQuantity.getText() == "" ||
                        inputMinIncrease.getText() == "" ||
                        inputMaxIncrease.getText() == "" ||
                        inputMinDecrease.getText() == "" ||
                        inputMaxDecrease.getText() == "" ||
                        (((TypeComboItem)typeSelector.getSelectedItem()).getValue() == 'h' && inputAlphaAcid.getText() == "")
                    ){
                    JOptionPane.showMessageDialog(mainPanel, "All input fields are required!");
                } else if (!validInputFormat){
                    JOptionPane.showMessageDialog(mainPanel, "Invalid input formats!");
                } else {
                    try{
                        stock.addIngredient(ingredienttype, alphaAcid, itemName, stockPrice, quantity, minInc, maxInc, minDec, maxDec, unit);
                    } catch (Throwable t){
                        JOptionPane.showMessageDialog(mainPanel, "Error");
                        System.out.println(t.getMessage());
                        System.out.println(t.getStackTrace().toString());
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
