package edu.umb.cs680.hw10;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DistanceMatrixTest {

    List<Integer> c1 = Arrays.asList(5000, 2020, 10000);
    List<Integer> c2 = Arrays.asList(2000, 2021, 8000);
    List<Integer> c3 = Arrays.asList(1000, 2022, 6000);
    List<Integer> c4 = Arrays.asList(3000, 2019, 2000);
    List<Integer> c5 = Arrays.asList(4000, 2023, 4000);

    int min_mileage = 1000;
    int min_year = 2019;
    int min_price = 2000;
    int max_mileage = 5000;
    int max_year = 2023;
    int max_price = 10000;

    double v11 = (5000 - min_mileage)/(max_mileage - min_mileage);
    double v21 = (2020 - min_year)/(max_year - min_year);
    double v31 = (10000 - min_price)/(max_price - min_price);

    double v12 = (2000 - min_mileage)/(max_mileage - min_mileage);
    double v22 = (2021 - min_year)/(max_year - min_year);
    double v32 = (8000 - min_price)/(max_price - min_price);

    double v13 = (1000 - min_mileage)/(max_mileage - min_mileage);
    double v23 = (2022 - min_year)/(max_year - min_year);
    double v33 = (6000 - min_price)/(max_price - min_price);

    double v14 = (3000 - min_mileage)/(max_mileage - min_mileage);
    double v24 = (2019 - min_year)/(max_year - min_year);
    double v34 = (2000 - min_price)/(max_price - min_price);

    double v15 = (4000 - min_mileage)/(max_mileage - min_mileage);
    double v25 = (2023 - min_year)/(max_year - min_year);
    double v35 = (4000 - min_price)/(max_price - min_price);

    List<Double> nl1 = Arrays.asList(1.0, 0.0, 1.0);
    List<Double> nl2 = Arrays.asList(0.0, 0.0, 1.0);
    List<Double> nl3 = Arrays.asList(0.0, 1.0, 0.0);
    List<Double> nl4 = Arrays.asList(0.0, 0.0, 0.0);
    List<Double> nl5 = Arrays.asList(1.0, 1.0, 0.0);

    @Test
    void getManhattan1() {
        try {
            assertEquals(1.0, Distance.get(nl1,nl2, new Manhattan()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getManhattan2() {
        try {
            assertEquals(1.0, Distance.get(nl3,nl4, new Manhattan()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getManhattan3() {
        try {
            assertEquals(2.0, Distance.get(nl1,nl5, new Manhattan()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getEuclidean1() {
        try {
            assertEquals(1.4142135623730951, Distance.get(nl1,nl4));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getEuclidean2() {
        try {
            assertEquals(1.7320508075688772, Distance.get(nl2,nl5));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getEuclidean3() {
        try {
            assertEquals(1.0, Distance.get(nl3,nl4));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
