package com.strange.stuff.store;

public class ExoticCarnivorousPlant extends Product {
    private String species;
    private String careLevel;

    public ExoticCarnivorousPlant(String name, float price, int quantity, String description, String species, String careLevel) {
        super(name, price, quantity, description);
        this.species = species;
        this.careLevel = careLevel;
    }

    // Getters and Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }
}
