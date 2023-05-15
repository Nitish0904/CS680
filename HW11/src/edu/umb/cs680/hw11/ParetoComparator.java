package edu.umb.cs680.hw11;

import java.util.Comparator;

public class ParetoComparator implements Comparator<Cars> {

    public int compare(Cars c1, Cars c2) {
        return c1.getDominationCount() - c2.getDominationCount();
    }
}
