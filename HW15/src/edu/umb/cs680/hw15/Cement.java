package edu.umb.cs680.hw15;

public class Cement implements Material{

    private int quantity;

    public Cement(int quantity){
        this.quantity=quantity;
    }
    @Override
    public void selectMaterial() {
        System.out.println("Material Used\n: Concrete Cement");
    }

    @Override
    public double calculateCost() {
        double unitCost = 20.0;
        return unitCost * quantity;
    }

    @Override
    public void printMaterialDetails() {
        System.out.println("Material : Concrete Cement" );
        System.out.println("Cement is used in the mixture which is used to building walls");
    }

}
