package com.grindr.interview.elevator;

public class PassengerRequest {
    private int destinationFloorNumber;
    private int pickupFloorNumber;

    public int getDestinationFloorNumber() {
        return destinationFloorNumber;
    }

    public int getPickupFloorNumber() {
        return pickupFloorNumber;
    }

    public PassengerRequest(int destinationFloorNumber, int pickupFloorNumber){
        this.destinationFloorNumber = destinationFloorNumber;
        this.pickupFloorNumber = pickupFloorNumber;
    }
}

