package edu.umb.cs680.hw13;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;

class CarsTest {
    private static ArrayList<Cars> carsList = new ArrayList<Cars>();

    @BeforeAll
    public static void setUpCarsList() {
        Cars car1 = new Cars("Chevrolet", "Impala", 2016);
        car1.setPrice(32000);
        car1.setMileage(35000);
        carsList.add(car1);

        Cars car2 = new Cars("Ford", "Fusion", 2017);
        car2.setPrice(25000);
        car2.setMileage(30000);
        carsList.add(car2);

        Cars car3 = new Cars("Honda", "Civic", 2018);
        car3.setPrice(28000);
        car3.setMileage(25000);
        carsList.add(car3);

        Cars car4 = new Cars("Toyota", "Corolla", 2019);
        car4.setPrice(30000);
        car4.setMileage(20000);
        carsList.add(car4);

    }


    @Test
    public void verifyYearComparator() {
        Collections.sort(carsList, (c1, c2) -> c1.getYear() - c2.getYear());
        assertEquals("Toyota", carsList.get(3).getMake());
        assertEquals("Ford", carsList.get(1).getMake());
        assertEquals("Honda", carsList.get(2).getMake());
        assertEquals("Chevrolet", carsList.get(0).getMake());
    }

    @Test
    public void verifyMileageComparator() {
        Collections.sort(carsList, (c1, c2) -> c1.getMileage() - c2.getMileage());
        assertEquals("Toyota", carsList.get(0).getMake());
        assertEquals("Ford", carsList.get(2).getMake());
        assertEquals("Honda", carsList.get(1).getMake());
        assertEquals("Chevrolet", carsList.get(3).getMake());
    }

    @Test
    public void verifyPriceComparator() {
        Collections.sort(carsList, (c1, c2) -> (int) (c1.getPrice() - c2.getPrice()));
        assertEquals("Toyota", carsList.get(2).getMake());
        assertEquals("Ford", carsList.get(0).getMake());
        assertEquals("Honda", carsList.get(1).getMake());
        assertEquals("Chevrolet", carsList.get(3).getMake());
    }

    @Test
    public void verifyParetoComparator() {
        Collections.sort(carsList, (c1, c2) -> c1.getDominationCount() - c2.getDominationCount());
        assertEquals("Toyota", carsList.get(0).getMake());
        assertEquals("Ford", carsList.get(2).getMake());
        assertEquals("Honda", carsList.get(1).getMake());
        assertEquals("Chevrolet", carsList.get(3).getMake());
    }
}
