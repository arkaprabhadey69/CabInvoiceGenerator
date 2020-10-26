package com.bl.invoice;

import java.util.Objects;

public class EnhancedInvoice {
    public double totalFare;
    public int noOfRides;
    public double avg;

    public EnhancedInvoice(double totalFare, int noOfRides) {
        this.totalFare = totalFare;
        this.noOfRides = noOfRides;
        this.avg=this.totalFare/this.noOfRides;
    }

    public EnhancedInvoice() {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnhancedInvoice that = (EnhancedInvoice) o;
        return Double.compare(that.totalFare, totalFare) == 0 &&
                noOfRides == that.noOfRides &&
                Double.compare(that.avg, avg) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalFare, noOfRides, avg);
    }
}
