package com.bl.invoice;

public class Rides {
    public double distance;
    public double time;
    public String rideType;

    public Rides(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }

    public Rides(double distance, double time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }
}
