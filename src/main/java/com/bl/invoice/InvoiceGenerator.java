package com.bl.invoice;

import java.util.List;

public class InvoiceGenerator {
    public static int costPerKm = 10;
    public static int costPerMin = 1;
    public static int minimumFare = 5;
    static int numOfRides=0;

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
    public double calculateInvoice(List<Rides> rides){
        int fare=0;
        for(Rides ride:rides){
            fare+=this.calculateFare(ride.distance,ride.time);
        }
        return fare;

    }
    public EnhancedInvoice calculateEnhancedInvoice(List<Rides> rides){
        int fare=0;
        for(Rides ride:rides){
            numOfRides++;
            fare+=this.calculateFare(ride.distance,ride.time);
        }
        EnhancedInvoice enhancedInvoice= new EnhancedInvoice(fare,numOfRides);
        return enhancedInvoice;
    }
}
