package com.bl.invoice;

import java.util.List;

public class InvoiceGenerator {
    public static int costPerKm = 10;
    public static int costPerMin = 1;
    public static int minimumFare = 5;
    static int numOfRides=0;
    static int noOfRides;

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

    public EnhancedInvoice getInvoiceSummary(String userID){
        try{
            if(userID==null)
                throw new NullPointerException("Null not allowed");
            if(UserAccount.userRides.containsKey(userID)){
                double totalfare=0;
                int count=0;
                for(Rides ride:UserAccount.userRides.get(userID)){
                    noOfRides++;
                    totalfare+=this.calculateFare(ride.distance,ride.time);
                }
                EnhancedInvoice invoiceSummary = new EnhancedInvoice(totalfare,noOfRides);
                return  invoiceSummary;

            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;

    }
}
