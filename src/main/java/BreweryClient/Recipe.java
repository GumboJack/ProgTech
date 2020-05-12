package BreweryClient;

import Models.*;

import java.util.ArrayList;

public class Recipe {
    String beerName;

    private int liter;
    private int[] maltQuantities;
    private UnitType maltUnit;
    private int[] hopQuantities;
    private UnitType hopUnit;
    private int[] yiestQuantities;
    private UnitType yiestUnit;
    private int[] otherQuantities;
    private UnitType otherUnit;
    private ArrayList<Hop> hops;
    private ArrayList<Malt> malts;
    private ArrayList<Yiest> yiests;
    private ArrayList<OtherIngredient> otherIngredients;
    private int mashingTimeInMinutes;
    private int hopBoilingTimeInMinutes;
    private int fermentationTimeInDays;
    private boolean pasteurization;
    private boolean filtrarion;

    public Recipe(String beerName, int liter, int[] maltQuantities, UnitType maltUnit, int[] hopQuantities, UnitType hopUnit,
                  int[] yiestQuantities, UnitType yiestUnit, int[] otherQuantities, UnitType otherUnit, int mashingTimeInMinutes,
                  int hopBoilingTimeInMinutes, int fermentationTimeInDays, boolean pasteurization, boolean filtrarion,
                  ArrayList<Hop> hops, ArrayList<Malt> malts, ArrayList<Yiest> yiests, ArrayList<OtherIngredient> otherIngredients)
            throws InvalidRecipeException {
        if(maltQuantities.length != malts.size() || hopQuantities.length != hops.size() ||
                yiestQuantities.length != yiests.size() || otherQuantities.length != otherIngredients.size()){
            throw new InvalidRecipeException();
        }
        this.liter = liter;
        this.beerName = beerName;
        this.maltQuantities = maltQuantities;
        this.maltUnit = maltUnit;
        this.hopQuantities = hopQuantities;
        this.hopUnit = hopUnit;
        this.yiestQuantities = yiestQuantities;
        this.yiestUnit = yiestUnit;
        this.otherQuantities = otherQuantities;
        this.otherUnit = otherUnit;
        this.mashingTimeInMinutes = mashingTimeInMinutes;
        this.hopBoilingTimeInMinutes = hopBoilingTimeInMinutes;
        this.fermentationTimeInDays = fermentationTimeInDays;
        this.pasteurization = pasteurization;
        this.filtrarion = filtrarion;
        this.hops = hops;
        this.malts = malts;
        this.yiests = yiests;
        this.otherIngredients = otherIngredients;
    }

    public String getBeerName() {
        return beerName;
    }

    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }

    public int getLiter() {
        return liter;
    }

    public void setLiter(int liter) {
        this.liter = liter;
    }

    public int[] getMaltQuantities() {
        return maltQuantities;
    }

    public void setMaltQuantities(int[] maltQuantities) {
        this.maltQuantities = maltQuantities;
    }

    public UnitType getMaltUnit() {
        return maltUnit;
    }

    public void setMaltUnit(UnitType maltUnit) {
        this.maltUnit = maltUnit;
    }

    public int[] getHopQuantities() {
        return hopQuantities;
    }

    public void setHopQuantities(int[] hopQuantities) {
        this.hopQuantities = hopQuantities;
    }

    public UnitType getHopUnit() {
        return hopUnit;
    }

    public void setHopUnit(UnitType hopUnit) {
        this.hopUnit = hopUnit;
    }

    public int[] getYiestQuantities() {
        return yiestQuantities;
    }

    public void setYiestQuantities(int[] yiestQuantities) {
        this.yiestQuantities = yiestQuantities;
    }

    public UnitType getYiestUnit() {
        return yiestUnit;
    }

    public void setYiestUnit(UnitType yiestUnit) {
        this.yiestUnit = yiestUnit;
    }

    public int[] getOtherQuantities() {
        return otherQuantities;
    }

    public void setOtherQuantities(int[] otherQuantities) {
        this.otherQuantities = otherQuantities;
    }

    public UnitType getOtherUnit() {
        return otherUnit;
    }

    public void setOtherUnit(UnitType otherUnit) {
        this.otherUnit = otherUnit;
    }

    public int getMashingTimeInMinutes() {
        return mashingTimeInMinutes;
    }

    public void setMashingTimeInMinutes(int mashingTimeInMinutes) {
        this.mashingTimeInMinutes = mashingTimeInMinutes;
    }

    public int getHopBoilingTimeInMinutes() {
        return hopBoilingTimeInMinutes;
    }

    public void setHopBoilingTimeInMinutes(int hopBoilingTimeInMinutes) {
        this.hopBoilingTimeInMinutes = hopBoilingTimeInMinutes;
    }

    public int getFermentationTimeInDays() {
        return fermentationTimeInDays;
    }

    public void setFermentationTimeInDays(int fermentationTimeInDays) {
        this.fermentationTimeInDays = fermentationTimeInDays;
    }

    public boolean isPasteurization() {
        return pasteurization;
    }

    public void setPasteurization(boolean pasteurization) {
        this.pasteurization = pasteurization;
    }

    public boolean isFiltrarion() {
        return filtrarion;
    }

    public void setFiltrarion(boolean filtrarion) {
        this.filtrarion = filtrarion;
    }

    public ArrayList<Hop> getHops() {
        return hops;
    }

    public void setHops(ArrayList<Hop> hops) {
        this.hops = hops;
    }

    public ArrayList<Malt> getMalts() {
        return malts;
    }

    public void setMalts(ArrayList<Malt> malts) {
        this.malts = malts;
    }

    public ArrayList<Yiest> getYiests() {
        return yiests;
    }

    public void setYiests(ArrayList<Yiest> yiests) {
        this.yiests = yiests;
    }

    public ArrayList<OtherIngredient> getOtherIngredients() {
        return otherIngredients;
    }

    public void setOtherIngredients(ArrayList<OtherIngredient> otherIngredients) {
        this.otherIngredients = otherIngredients;
    }
}
