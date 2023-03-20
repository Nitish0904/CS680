package edu.umb.cs680.hw03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Cars_Test {
    private String[] carToStringArray(Cars car) {
        return new String[] { car.getMake(), car.getModel(), Integer.toString(car.getYear()) };
    }

    @Test
    public void verifyCarEqualityWithMakeModelYear() {
        String[] expected = { "Toyota", "RAV4", "2018" };
        Cars actual = new Cars("Toyota", "RAV4", 2018);
        assertArrayEquals(expected, carToStringArray(actual));
    }
}
