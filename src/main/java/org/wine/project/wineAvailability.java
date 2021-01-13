package org.wine.project;

public enum wineAvailability {
    AVAILABLE("Available"),
    UNAVAILABLE("Unavailable");

    private final String label;

    wineAvailability(String label){
        this.label=label;
    }
}
