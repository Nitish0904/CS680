package edu.umb.cs680.hw11;

import java.util.ArrayList;

public class Cars {
    private String make, model;
    private int mileage;
    private int year;
    private float price;
    private int dominationCount;

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

    public float getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getDominationCount() {
        return this.dominationCount;
    }

    public void setDominationCount(ArrayList<Cars> cars) {
        int dominationCount = 0;
        float thisPrice = this.getPrice();
        int thisYear = this.getYear();
        int thisMileage = this.getMileage();
        for (Cars car : cars) {
            if (car != this) {
                float carPrice = car.getPrice();
                int carYear = car.getYear();
                int carMileage = car.getMileage();
                boolean thisDominatesCar =
                        thisPrice <= carPrice && thisYear >= carYear && thisMileage <= carMileage
                                && (thisPrice < carPrice || thisYear > carYear || thisMileage < carMileage);
                if (thisDominatesCar) {
                    dominationCount++;
                }
            }
        }
        this.dominationCount = dominationCount;
    }


}
