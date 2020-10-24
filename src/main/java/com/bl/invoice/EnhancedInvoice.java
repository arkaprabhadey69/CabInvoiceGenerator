package com.bl.invoice;

public class EnhancedInvoice {
    public double totalFare;
    public int noOfRides;
    public double avg;

    public EnhancedInvoice(double totalFare, int noOfRides) {
        this.totalFare = totalFare;
        this.noOfRides = noOfRides;
        this.avg=this.totalFare/this.noOfRides;
    }

    public double getAveragePrice(){
        return this.totalFare/this.noOfRides;
    }

    @Override
    public String toString() {
        return "EnhancedInvoice{" +
                "totalFare=" + totalFare +
                ", noOfRides=" + noOfRides +
                ", avg=" + avg +
                '}';
    }
}
