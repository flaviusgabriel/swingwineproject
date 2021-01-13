package org.wine.project;

public class Wine {
    private String id;
    private String category;
    private String name;
    private String producer;
    private String manufacturing_year;
    private int breathalyser;
    private String country;
    private String amount;
    private String price;
    private wineAvailability abailability;

    public Wine(String id, String category, String name, String producer, String manufacturing_year, int breathalyser, String country, String amount, String price, wineAvailability abailability) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.producer = producer;
        this.manufacturing_year = manufacturing_year;
        this.breathalyser = breathalyser;
        this.country = country;
        this.amount = amount;
        this.price = price;
        this.abailability = abailability;
    }

    public Wine(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getManufacturing_year() {
        return manufacturing_year;
    }

    public void setManufacturing_year(String manufacturing_year) {
        this.manufacturing_year = manufacturing_year;
    }

    public int getBreathalyser() {
        return breathalyser;
    }

    public void setBreathalyser(int breathalyser) {
        this.breathalyser = breathalyser;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public wineAvailability getAbailability() {
        return abailability;
    }

    public void setAbailability(wineAvailability abailability) {
        this.abailability = abailability;
    }
}
