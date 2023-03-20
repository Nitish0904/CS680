package edu.umb.cs680.hw01;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrimeGeneratorTest {

    @Test
    void getp() {
        PrimeGenerator gen = new PrimeGenerator(20, 50);
        gen.generatePrimes();
        Long[] exp = {23L, 29L, 31L, 37L, 41L, 43L, 47L};
        assertArrayEquals(exp, gen.getPrimes().toArray());
    }

    @Test
    void ispeven(){
        PrimeGenerator gen = new PrimeGenerator(10, 20);
        assertTrue(gen.isEven(2));

    }
}