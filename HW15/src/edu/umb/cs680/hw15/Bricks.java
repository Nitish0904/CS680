package edu.umb.cs680.hw15;

public class Bricks implements Material {

    private int quantity;

    public Bricks(int quantity){
        this.quantity=quantity;
    }

    @Override
    public void selectMaterial() {
        System.out.println("Material Used\n: Mud Bricks");
    }

    @Override
    public double calculateCost() {
        double unitCost = 10.0;
        return unitCost * quantity;

    }

    @Override
    public void printMaterialDetails() {
        System.out.println("Material : Mud Bricks" );
        System.out.println("Mud Bricks is used to construct Walls");

    }
}
