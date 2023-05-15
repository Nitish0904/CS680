package edu.umb.cs680.hw11;

import java.util.Comparator;

public class MileageComparator implements Comparator<Cars> {

    public int compare(Cars c1, Cars c2) {
        return c1.getMileage() - c2.getMileage();
    }
}
