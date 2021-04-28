package com.invoicegenerator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCabInvoiceGenerator {

    @Test
    public void whenGivenDistanceAndTimeShouldReturnTotalFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double totalFare = cabInvoiceGenerator.calculateFare(distance,time);
        System.out.println("Total Fare = " +totalFare);
        Assertions.assertEquals(25, totalFare,0.0);
    }
}
