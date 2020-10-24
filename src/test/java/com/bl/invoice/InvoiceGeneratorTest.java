package com.bl.invoice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTimeReturnCorrectFare() {
        InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
        double distance=4;
        double time=3;
        double fare=invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(43,fare,0);
    }
    @Test
    public void givenDistanceAndTimeReturnCorrectMinimumFare() {
        InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
        double distance=0.1;
        double time=3;
        double fare=invoiceGenerator.calculateFare(distance,time);
        Assert.assertEquals(5,fare,0);
    }
    @Test
    public void givenMultipleRidesShouldReturnCorrectFare() {
        InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
        List<Rides> rides= new ArrayList<>();
        Rides rides1= new Rides(10,4);
        Rides rides2= new Rides(5,3);
        rides.add(rides1);
        rides.add(rides2);
        double fare=invoiceGenerator.calculateInvoice(rides);
        System.out.println(fare);
        Assert.assertEquals(157,fare,0);
    }
    @Test
    public void givenMultipleRidesShouldReturnCorrectAvgFare() {
        InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
        List<Rides> rides= new ArrayList<>();
        Rides rides1= new Rides(10,4);
        Rides rides2= new Rides(5,3);
        rides.add(rides1);
        rides.add(rides2);
        EnhancedInvoice enhancedInvoice=invoiceGenerator.calculateEnhancedInvoice(rides);
        System.out.println(enhancedInvoice);
        EnhancedInvoice enhancedInvoice1= new EnhancedInvoice(157,2);
        Assert.assertEquals(enhancedInvoice1.noOfRides,enhancedInvoice.noOfRides);
        Assert.assertEquals(enhancedInvoice1.avg,enhancedInvoice.avg,0);
        Assert.assertEquals(enhancedInvoice1.totalFare,enhancedInvoice.totalFare,0);
    }
    @Test
    public void givenMultipleRidesShouldReturnCorrectFareUsingUerID() {
        InvoiceGenerator invoiceGenerator= new InvoiceGenerator();
        List<Rides> rides= new ArrayList<>();
        List<Rides> rides5= new ArrayList<>();
        Rides rides1= new Rides(10,4);
        Rides rides2= new Rides(5,3);
        Rides rides3= new Rides(6,4);
        Rides rides4= new Rides(11,3);
        rides.add(rides1);
        rides.add(rides2);
        rides5.add(rides3);
        rides5.add(rides4);
        String userID="Ram";
        String userID2="Shyam";
        UserAccount.addRide(userID,rides);
        UserAccount.addRide(userID2,rides5);
        EnhancedInvoice enhancedInvoice=invoiceGenerator.getInvoiceSummary("Shyam");
        EnhancedInvoice enhancedInvoice1= new EnhancedInvoice(177,2);
        Assert.assertEquals(enhancedInvoice1.noOfRides,enhancedInvoice.noOfRides);
        Assert.assertEquals(enhancedInvoice1.avg,enhancedInvoice.avg,0);
        Assert.assertEquals(enhancedInvoice1.totalFare,enhancedInvoice.totalFare,0);
    }
}