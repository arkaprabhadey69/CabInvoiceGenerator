package com.bl.invoice;

import org.junit.Assert;
import org.junit.Test;

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
}