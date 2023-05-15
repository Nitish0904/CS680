package edu.umb.cs680.hw10;

import java.util.Iterator;
import java.util.List;

public class Manhattan implements DistanceMetric {

    public static void main(String[] args) {
        Manhattan m =new Manhattan();
        Distance d= new Distance();
        List<Double> p1= List.of(4.0,6.0);
        List<Double> p2= List.of(5.0,10.0);
        double res;
        res=m.distance(p1,p2);
        System.out.println(res);
        List<List<Double>> mat=List.of(p1,p2);
        List<List<Double>> ress;
        ress=Distance.matrix(mat,m);
        System.out.println(ress);
    }

    @Override
    public double distance(List<Double> p1, List<Double> p2) {
        double sumOfCoordinates = 0;
        Iterator<Double> it1 = p1.iterator();
        Iterator<Double> it2 = p2.iterator();
        while (it1.hasNext() && ((Iterator<?>) it2).hasNext()) {
            double coord1 = it1.next();
            double coord2 = it2.next();
            sumOfCoordinates += Math.abs(coord1 - coord2);
        }
        return sumOfCoordinates;
    }
}
