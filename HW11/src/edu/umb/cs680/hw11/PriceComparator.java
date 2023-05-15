package edu.umb.cs680.hw11;

import java.util.Comparator;

public class PriceComparator implements Comparator<Cars> {

    public int compare(Cars c1, Cars c2) {
        return (int) (c1.getPrice() - c2.getPrice());
    }
}
