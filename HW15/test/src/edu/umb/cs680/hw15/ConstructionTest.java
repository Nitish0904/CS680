package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructionTest {


    @Test
    void countconmaterial(){
        Construction construction=new Construction("Peninsula Apartments","SULLIvan Street");
        construction.addConstructionMaterial(new Bricks(10));
        construction.addConstructionMaterial(new Cement(20));
        construction.addConstructionMaterial(new Wood(26));
        construction.addConstructionMaterial(new POP(77));
        construction.printConstructionDetails();
        assertEquals(4,construction.getConstructionmaterials().size());
    }

    @Test
    public void getconstructionname() {
        Construction construction=new Construction("Peninsula Apartments","Sullivan Street");
        String expected = "Peninsula Apartments";
        String actual = construction.getCname();
        assertEquals(expected, actual);
    }

    @Test
    public void getlocation() {
        Construction construction=new Construction("Peninsula Apartments","Sullivan Street");
        String expected = "Sullivan Street";
        String actual = construction.getLocation();
        assertEquals(expected, actual);
    }

    @Test
    public void addconstructionmaterial() {
        Construction construction=new Construction("Peninsula Apartments","SULLIvan Street");
        Material material = new SteelMaterial(100);
        construction.addConstructionMaterial(material);

        int expectedSize = 1;
        int actualSize = construction.getConstructionmaterials().size();
        assertEquals(expectedSize, actualSize);

        Material actualMaterial = construction.getConstructionmaterials().get(0);
        assertSame(material, actualMaterial);
    }

    @Test
    public void printtest(){

    }

}