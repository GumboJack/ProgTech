package BreweryClient;

import Models.UnitType;

public class Recipe {
    String beerName;

    private int liter;
    private int[] maltQuantities;
    private UnitType maltUnit;
    private int[] hopQuantities;
    private UnitType hopUnit;
    private int[] yiestQuantity;
    private UnitType yiestUnit;
    private int[] otherQuantities;
    private UnitType otherUnit;
    private int mashingTimeInMinutes;
    private int hopBoilingTimeInMinutes;
    private int fermentationTimeInDays;
    private boolean pasteurization;
    private boolean filtrarion;

    public Recipe(String beerName, int liter, int[] maltQuantities, UnitType maltUnit, int[] hopQuantities, UnitType hopUnit, int[] yiestQuantity,
                  UnitType yiestUnit, int[] otherQuantities, UnitType otherUnit, int mashingTimeInMinutes, int hopBoilingTimeInMinutes,
                  int fermentationTimeInDays, boolean pasteurization, boolean filtrarion) {
        this.liter = liter;
        this.beerName = beerName;
        this.maltQuantities = maltQuantities;
        this.maltUnit = maltUnit;
        this.hopQuantities = hopQuantities;
        this.hopUnit = hopUnit;
        this.yiestQuantity = yiestQuantity;
        this.yiestUnit = yiestUnit;
        this.otherQuantities = otherQuantities;
        this.otherUnit = otherUnit;
        this.mashingTimeInMinutes = mashingTimeInMinutes;
        this.hopBoilingTimeInMinutes = hopBoilingTimeInMinutes;
        this.fermentationTimeInDays = fermentationTimeInDays;
        this.pasteurization = pasteurization;
        this.filtrarion = filtrarion;
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

    public int[] getYiestQuantity() {
        return yiestQuantity;
    }

    public void setYiestQuantity(int[] yiestQuantity) {
        this.yiestQuantity = yiestQuantity;
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
}
