package com.bl.invoice;

import javax.print.DocFlavor;

public class RideType {
    public static String normalRide = "normal";
    public static String premiumRide = "premium";
    public double costPerTime;
    public double costPerKilometer;
    public double minimumFare;

    public RideType(String rideType)
    {
        if(rideType.toLowerCase()== premiumRide)
        {
            costPerTime = 2;
            costPerKilometer = 15;
            minimumFare = 20;
        }
        else
        {
            costPerTime = 1;
            costPerKilometer = 10;
            minimumFare = 5;
        }
    }
}
