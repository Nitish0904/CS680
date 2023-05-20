package edu.umb.cs680.hw15;

import java.util.ArrayList;

public class Construction {
    private String Cname;
    private String Location;


    private ArrayList<Material> constructionmaterials=new ArrayList<>();;
    private ArrayList<Double> construction_cost=new ArrayList<>();

    public Construction(String Cname,String Location){
        this.Cname=Cname;
        this.Location=Location;
    }


    public String getLocation() {
        return Location;
    }

    public String getCname() {
        return Cname;
    }

    public void addConstructionMaterial(Material material) {
        constructionmaterials.add(material);
    }


    public double getConstructioncost() {
        double totalCost = 0.0;
        for (Material material : constructionmaterials) {
            totalCost += material.calculateCost();
        }
        return totalCost;
    }

    public ArrayList<Material> getConstructionmaterials() {
        return constructionmaterials;
    }

    public void printConstructionDetails() {
        System.out.println("Construction Name: " + getCname());
        System.out.println("Location: " + getLocation());
        System.out.println("Construction Materials:" );
        for (Material material : constructionmaterials) {
            material.selectMaterial();
            material.printMaterialDetails();
            System.out.println("--------------------------");
        }
        System.out.println("Total Construction Cost: $" + getConstructioncost());
    }
}
