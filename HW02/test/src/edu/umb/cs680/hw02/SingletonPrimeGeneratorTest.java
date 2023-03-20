package edu.umb.cs680.hw02;

import java.util.Arrays;
import java.util.LinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonPrimeGeneratorTest {

    @Test
    public void testGetInstance() {
        SingletonPrimeGenerator generator = SingletonPrimeGenerator.getInstance(1, 20);
        generator.generatePrimes();
        assertNotNull(generator);
    }

    @Test
    public void testIdenticalInstances() {
        SingletonPrimeGenerator generator1 = SingletonPrimeGenerator.getInstance(1, 20);
        SingletonPrimeGenerator generator2 = SingletonPrimeGenerator.getInstance(1, 40);
        assertSame(generator1, generator2);
    }

    @Test
    public void testGetPrimes() {
        SingletonPrimeGenerator generator = SingletonPrimeGenerator.getInstance(1, 20);
        generator.generatePrimes();
        LinkedList<Long> expectedPrimes = new LinkedList<>(Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L));
        assertIterableEquals(expectedPrimes, generator.getPrimes());
    }

}

