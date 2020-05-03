package BreweryStockMarket;

import Models.UnitHelper;
import Models.UnitType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockService {
    private JPanel mainPanel;
    private JTextField inputName;
    private JTextField inputStockPrice;
    private JTextField inputQuantity;
    private JTextField inputMaxIncrease;
    private JTextField inputMinIncrease;
    private JTextField inputMinDecrease;
    private JTextField inputAlphaAcid;
    private JButton btnAdd;
    private JLabel mainText;
    private JTextField inputMaxDecrease;
    private JComboBox unitSelector;
    private JComboBox typeSelector;
    BreweryStock stock = BreweryStock.getInstance();

    public StockService(){
        typeSelector.addItem(new TypeComboItem("Hop", 'h'));
        typeSelector.addItem(new TypeComboItem("Malt", 'm'));
        typeSelector.addItem(new TypeComboItem("Yiest", 'y'));
        typeSelector.addItem(new TypeComboItem("Other Ingredient", 'o'));

        for (UnitType unit:
             UnitType.values()) {
            unitSelector.addItem(new UnitComboItem(UnitHelper.unitConverter(unit), unit));
        }

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (inputName.getText() == "" ||
                    )
                stock.addIngredient(((TypeComboItem)typeSelector.getSelectedItem()).getValue(), );
            }
        });
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
