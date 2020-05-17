package BreweryClient;

import ModelsTest.*;

import java.util.ArrayList;

public class Recipe {
    String beerName;

    private int liter;
    private ArrayList<Hop> hops;
    private ArrayList<Malt> malts;
    private ArrayList<Yiest> yiests;
    private ArrayList<OtherIngredient> otherIngredients;
    private int mashingTimeInMinutes;
    private int hopBoilingTimeInMinutes;
    private int fermentationTimeInDays;
    private boolean pasteurization;
    private boolean filtrarion;

    public Recipe(String beerName, int liter, int mashingTimeInMinutes,
                  int hopBoilingTimeInMinutes, int fermentationTimeInDays, boolean pasteurization, boolean filtrarion,
                  ArrayList<Hop> hops, ArrayList<Malt> malts, ArrayList<Yiest> yiests, ArrayList<OtherIngredient> otherIngredients)
             {

        this.liter = liter;
        this.beerName = beerName;
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
