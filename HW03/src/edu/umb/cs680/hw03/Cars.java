package edu.umb.cs680.hw03;

public class Cars {
    private String make, model;
    private int mileage, year;
    private float price;

    public Cars(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
}

