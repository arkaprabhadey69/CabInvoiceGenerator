package com.bl.invoice;

import java.util.List;

public class InvoiceGenerator {

    public static void welcome() {
        System.out.println("Welcome to CabInvoiceGenerator");
    }
//Method to calculate fare
    public double calculateFare(double distance, double time, String type) {
        RideType rideType = new RideType(type);
        double totalFare = distance * rideType.costPerKilometer + time * rideType.costPerTime;
        return Math.max(totalFare, rideType.minimumFare);
    }
//Method to get fare for multiple rides
    public double calculateInvoice(List<Rides> rides) {
        int fare = 0;
        for (Rides ride : rides) {
            fare += this.calculateFare(ride.distance, ride.time, "normal");
        }
        return fare;

    }
//Method to get invoice summary
    public EnhancedInvoice calculateEnhancedInvoice(List<Rides> rides) {
        int fare = 0;
        int numOfRides = 0;
        for (Rides ride : rides) {
            numOfRides++;
            fare += this.calculateFare(ride.distance, ride.time, "normal");
        }
        EnhancedInvoice enhancedInvoice = new EnhancedInvoice(fare, numOfRides);
        return enhancedInvoice;
    }
//Method to get invoice summary by userID and normal/premium type
    public EnhancedInvoice getInvoiceSummary(String userID) {
        try {
            if (userID == null)
                throw new NullPointerException("Null not allowed");
            if (UserAccount.userRides.containsKey(userID)) {
                double totalFare = 0;
                int noOfRides = 0;
                for (Rides ride : UserAccount.userRides.get(userID)) {
                    noOfRides++;
                    totalFare += this.calculateFare(ride.distance, ride.time, ride.rideType);
                }
                EnhancedInvoice invoiceSummary = new EnhancedInvoice(totalFare, noOfRides);
                return invoiceSummary;

            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return null;

    }
}
