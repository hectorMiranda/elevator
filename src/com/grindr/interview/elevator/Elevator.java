package com.grindr.interview.elevator;

import com.grindr.interview.*;
import java.util.ArrayList;


public class Elevator {
    private int currentFloor;
    private int numberOfFloors;
    private ElevatorDirection direction;
    private ArrayList<PassengerRequest> requests;
    private int capacity;

    public ArrayList<PassengerRequest> getPendingRequests() {
        return requests;
    }

    public void addPassengerRequest(PassengerRequest request) {
        this.requests.add(request);
    }

    public Elevator(int numberOfFloors, int capacity) {
        this.numberOfFloors = numberOfFloors;
        this.capacity = capacity;
        this.requests = new ArrayList<PassengerRequest>();
        this.currentFloor = 1;
        this.direction = ElevatorDirection.ELEVATOR_UP;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getCurrentFloor(){
        return currentFloor;
    }

    public boolean isFull()
    {
        return requests.size() == capacity ? true: false;

    }

    private void openDoorAt(int floorNumber)
    {
        System.out.println("Now at " + floorNumber);
        evaluateRequestsForFloor();

        System.out.println(this.hashCode() + ": remaining requests for this elevator are");

        for(PassengerRequest r : requests)
            System.out.println(r.getDestinationFloorNumber());
    }


    public void elevatorStep()
    {
        if(this.direction == ElevatorDirection.ELEVATOR_UP)
            openDoorAt(currentFloor++);
        else
            openDoorAt(currentFloor--);
    }


    private void evaluateRequestsForFloor()
    {
        ArrayList<PassengerRequest> remainingRequest = new ArrayList<>();

        for (PassengerRequest r : requests){
            if (currentFloor != r.getDestinationFloorNumber()) {
                remainingRequest.add(r);
            }
            else
            {
                System.out.println("Passenger leaving elevator...");
            }
        }

        this.requests = remainingRequest;

        if(currentFloor+1 == numberOfFloors)
            this.direction = ElevatorDirection.ELEVATOR_DOWN;
        if(currentFloor == 1)
            this.direction = ElevatorDirection.ELEVATOR_UP;
    }

}

