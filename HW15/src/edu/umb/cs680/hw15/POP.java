package edu.umb.cs680.hw15;

public class POP implements Material{
    private int quantity;
    public POP(int quantity){
        this.quantity=quantity;
    }
    @Override
    public void selectMaterial() {
        System.out.println("Material Used\n: Plaster Of Paris");
    }

    @Override
    public double calculateCost() {
        double unitCost = 50.0;
        return unitCost * quantity;
    }

    @Override
    public void printMaterialDetails() {
        System.out.println("Material : POP" );
        System.out.println("Plaster of Paris is used to do water proofing");

    }
}
