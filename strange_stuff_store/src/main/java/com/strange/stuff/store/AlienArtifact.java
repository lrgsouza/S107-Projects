package com.strange.stuff.store;

public class AlienArtifact extends Product {
    private String origin;
    private String discoveryDate;

    public AlienArtifact(String name, float price, int quantity, String description, String origin, String discoveryDate) {
        super(name, price, quantity, description);
        this.origin = origin;
        this.discoveryDate = discoveryDate;
    }

    // Getters and Setters
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDiscoveryDate() {
        return discoveryDate;
    }

    public void setDiscoveryDate(String discoveryDate) {
        this.discoveryDate = discoveryDate;
    }
}
