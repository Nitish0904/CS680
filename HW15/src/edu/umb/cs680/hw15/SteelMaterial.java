package edu.umb.cs680.hw15;

public class SteelMaterial implements Material {
    private int quantity;

    public SteelMaterial(int quantity){
        this.quantity=quantity;
    }

    @Override
    public void selectMaterial() {
        System.out.println("Material Used\n: Steel");
    }

    @Override
    public double calculateCost() {
        double unitCost = 100.0;
        return unitCost * quantity;
    }

    @Override
    public void printMaterialDetails() {
        System.out.println("Material : Steel" );
        System.out.println("Steel is used to construct pillars with high Durability");
    }

}
