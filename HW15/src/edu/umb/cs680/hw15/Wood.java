package edu.umb.cs680.hw15;

public class Wood implements Material{

    private int quantity;
    public Wood(int quantity){
        this.quantity=quantity;
    }
    @Override
    public void selectMaterial() {
        System.out.println("Material Used\n: Teak Wood");
    }

    @Override
    public double calculateCost() {
        double unitCost = 120.0;
        return unitCost * quantity;
    }

    @Override
    public void printMaterialDetails() {
        System.out.println("Material : Wood" );
        System.out.println("Wood is used to make Furniture");
    }
}
