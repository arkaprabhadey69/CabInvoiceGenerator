package com.bl.invoice;

public class InvoiceGenerator {
    public static int costPerKm = 10;
    public static int costPerMin = 1;
    public static int minimumFare = 5;

    public static void welcome() {
        System.out.println("Welcome to CabInvoiceGenerator");
    }

    public double calculateFare(double distance, double time) {
        double fare = (distance * costPerKm + time * costPerMin);
        if (fare < minimumFare) {
            return minimumFare;
        }
        return fare;
    }
}
