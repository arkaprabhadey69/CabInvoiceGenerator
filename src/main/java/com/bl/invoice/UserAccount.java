package com.bl.invoice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Acts as Repository to add rides to a particular user-ID

public class UserAccount {
    public static Map<String, List<Rides>> userRides;

    public UserAccount() {
        userRides = new HashMap<>();
    }
//Method to Add rides
    public void addRide(String userID, List<Rides> rides) {
        try {
            if (userID == null || rides == null) {
                throw new NullPointerException("Null value not allowed");
            }
            if (userRides.containsKey(userID)) {
                for (Rides rides1 : rides) {
                    userRides.get(userID).add(rides1);

                }

            } else
                userRides.put(userID, rides);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
