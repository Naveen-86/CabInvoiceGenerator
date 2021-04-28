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

    @Test
    public void whenGivenLessDistanceOrTimeShouldReturnMinimumFare() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        System.out.println("Minimum Fare = " +fare);
        Assertions.assertEquals(5, fare,0.0);
    }

    @Test
    public void whenGivenMultipleRidesShouldReturnInvoiceSummary() {
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();
        Ride[] rides = { new Ride(2.0, 5),
                new Ride(0.1, 1)};
        double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
        System.out.println("Total Fare = "+totalFare);
        Assertions.assertEquals(30, totalFare,0.0);
    }


    @Test
    public void givenMultipleRides_shouldReturnSizeAndAverageFare(){
        CabInvoiceGenerator cabInvoiceGenerator = new CabInvoiceGenerator();

        Ride[] rides = { new Ride(20.0,4),
                new Ride(45.0,1),
                new Ride(75.0,1),
                new Ride(45.5,1)};

        double totalFare = cabInvoiceGenerator.calculateTotalFare(rides);
        int numberOfRides = cabInvoiceGenerator.getNumberOfRides(rides);
        double averageTotalFare = cabInvoiceGenerator.calculateAverageRideCost(rides);

        System.out.println("Total Fare = " +totalFare);
        System.out.println("Number of ride = " +numberOfRides);
        System.out.println("Average Total Fare " +averageTotalFare);

        Assertions.assertEquals(1862,totalFare,0.0);
        Assertions.assertEquals(4,numberOfRides);
        Assertions.assertEquals(465,averageTotalFare,0.5);
    }
}