package com.bl.invoice;

import java.util.List;

public class InvoiceGenerator {
    public static int costPerKm = 10;
    public static int costPerMin = 1;
    public static int minimumFare = 5;

    public static void welcome() {
        System.out.println("Welcome to CabInvoiceGenerator");
    }

    public double calculateFare(double distance, double time, String type)
    {
        RideType rideType = new RideType(type);
        double totalFare = distance * rideType.costPerKilometer + time * rideType.costPerTime;
        if (totalFare < rideType.minimumFare)
        {
            return rideType.minimumFare;
        }
        return totalFare;
    }
    public double calculateInvoice(List<Rides> rides){
        int fare=0;
        for(Rides ride:rides){
            fare+=this.calculateFare(ride.distance,ride.time,"normal");
        }
        return fare;

    }
    public EnhancedInvoice calculateEnhancedInvoice(List<Rides> rides){
        int fare=0;
        int numOfRides=0;
        for(Rides ride:rides){
            numOfRides++;
            fare+=this.calculateFare(ride.distance,ride.time,"normal");
        }
        EnhancedInvoice enhancedInvoice= new EnhancedInvoice(fare,numOfRides);
        return enhancedInvoice;
    }

    public EnhancedInvoice getInvoiceSummary(String userID){
        try{
            if(userID==null)
                throw new NullPointerException("Null not allowed");
            if(UserAccount.userRides.containsKey(userID)){
                double totalFare=0;
                int numRides=0;
                for(Rides ride:UserAccount.userRides.get(userID)){
                    numRides++;
                    totalFare+=this.calculateFare(ride.distance,ride.time,"normal");
                }
                EnhancedInvoice invoiceSummary = new EnhancedInvoice(totalFare,numRides);
                return  invoiceSummary;

            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;

    }
    public EnhancedInvoice getInvoiceSummaryPremium(String userID){
        try{
            if(userID==null)
                throw new NullPointerException("Null not allowed");
            if(UserAccount.userRides.containsKey(userID)){
                double totalFare=0;
                int noOfRides=0;
                int count=0;
                for(Rides ride:UserAccount.userRides.get(userID)){
                    noOfRides++;
                    totalFare+=this.calculateFare(ride.distance,ride.time,ride.rideType);
                }
                EnhancedInvoice invoiceSummary = new EnhancedInvoice(totalFare,noOfRides);
                return  invoiceSummary;

            }
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
        return null;

    }
}
