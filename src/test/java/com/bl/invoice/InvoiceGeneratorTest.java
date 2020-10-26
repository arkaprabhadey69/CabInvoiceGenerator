package com.bl.invoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InvoiceGeneratorTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setup() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTimeReturnCorrectFare() {
        double distance = 4;
        double time = 3;
        double fare = invoiceGenerator.calculateFare(distance, time, "normal");
        Assert.assertEquals(43, fare, 0);
    }

    @Test
    public void givenDistanceAndTimeReturnCorrectMinimumFare() {
        double distance = 0.1;
        double time = 3;
        double fare = invoiceGenerator.calculateFare(distance, time, "normal");
        Assert.assertEquals(5, fare, 0);
    }

    @Test
    public void givenMultipleRidesShouldReturnCorrectFare() {
        List<Rides> rides = new ArrayList<>();
        Rides rides1 = new Rides(10, 4);
        Rides rides2 = new Rides(5, 3);
        rides.add(rides1);
        rides.add(rides2);
        double fare = invoiceGenerator.calculateInvoice(rides);
        System.out.println(fare);
        Assert.assertEquals(157, fare, 0);
    }

    @Test
    public void givenMultipleRidesShouldReturnCorrectAvgFare() {
        List<Rides> rides = new ArrayList<>();
        Rides rides1 = new Rides(10, 4);
        Rides rides2 = new Rides(5, 3);
        rides.add(rides1);
        rides.add(rides2);
        EnhancedInvoice enhancedInvoice = invoiceGenerator.calculateEnhancedInvoice(rides);
        EnhancedInvoice enhancedInvoice1 = new EnhancedInvoice(157, 2);
        Assert.assertEquals(enhancedInvoice1.noOfRides, enhancedInvoice.noOfRides);
        Assert.assertEquals(enhancedInvoice1.avg, enhancedInvoice.avg, 0);
        Assert.assertEquals(enhancedInvoice1.totalFare, enhancedInvoice.totalFare, 0);
    }

    @Test
    public void givenMultipleRidesShouldReturnCorrectInvoicePremium() {
        List<Rides> rides = new ArrayList<>();
        Rides rides1 = new Rides(10, 4, "premium");
        Rides rides2 = new Rides(5, 3, "normal");
        rides.add(rides1);
        rides.add(rides2);
        UserAccount.addRide("Shyam", rides);
        UserAccount.addRide("Ram", rides);
        EnhancedInvoice enhancedInvoice = invoiceGenerator.getInvoiceSummaryPremium("Ram");
        EnhancedInvoice enhancedInvoice1 = new EnhancedInvoice(211, 2);
        Assert.assertEquals(enhancedInvoice1.noOfRides, enhancedInvoice.noOfRides);
        Assert.assertEquals(enhancedInvoice1.avg, enhancedInvoice.avg, 0);
        Assert.assertEquals(enhancedInvoice1.totalFare, enhancedInvoice.totalFare, 0);
    }
}