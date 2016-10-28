package com.grindr.interview.elevator;

import java.util.ArrayList;

public class ElevatorController {

    public static final int MAX_ELEVATORS = 100;
    int numberOfElevators = 0;
    int numberOfFloors = 0;
    int capacity = 5; //ideally we would have multiple types of elevators with different capacities

    Elevator[] elevators;
    ArrayList<PassengerRequest> passengerRequests;

    public ArrayList<PassengerRequest> getRequests() {
        return passengerRequests;
    }

    public void addRequest(PassengerRequest request) {
        this.passengerRequests.add(request);
    }

    public ElevatorController(Integer numberOfElevators, Integer numberOfFloors) throws Exception{
        System.out.println("Elevator Starting");

        if (numberOfElevators < 0 || numberOfFloors <2) System.out.println("Invalid option");

        this.numberOfElevators = (numberOfElevators > MAX_ELEVATORS)? MAX_ELEVATORS : numberOfElevators;
        this.numberOfFloors = numberOfFloors;
        this.passengerRequests = new ArrayList<PassengerRequest>();

        elevators = new Elevator[numberOfElevators];

        for (int i=0;i<this.numberOfElevators;i++){
            elevators[i] = new Elevator(numberOfFloors, capacity);
        }
    }

    public boolean elevatorsAreNeeded(){
        boolean returnValue = false;

        if(passengerRequests.size()>0)
            return true;

        for(Elevator elevator : elevators){
            if(elevator.getPendingRequests().size()>0 ) {
                returnValue = true;
                break;
            }

        }

        return returnValue;
    }

    public void printWaitingRequest()
    {
        System.out.println("unprocesses requests (waiting people)");
        for(PassengerRequest r : passengerRequests)
            System.out.println(r.getDestinationFloorNumber());

    }


    public void printCurrentRequestBeingProcessed()
    {
        for(Elevator elevator : elevators){
            System.out.println("request for Elevator " + elevator.hashCode());
            for(PassengerRequest r : elevator.getPendingRequests())
                System.out.println(r.getDestinationFloorNumber());
        }
    }



    public void step() {
        ArrayList<PassengerRequest> remainingRequest = new ArrayList<>();
        for(Elevator e: elevators)
        {
           for(PassengerRequest r : passengerRequests){
               if(r.getPickupFloorNumber() != e.getCurrentFloor() )
                   remainingRequest.add(r);
               else if(e.isFull() == false)
                   e.addPassengerRequest(r);
               else if(r.getDestinationFloorNumber() != e.getCurrentFloor())
                   remainingRequest.add(r);
           }
            passengerRequests = remainingRequest;
        }


        for(Elevator e: elevators)
            while(e.getPendingRequests().size()>0) {
                e.elevatorStep();
            }

        printWaitingRequest();
        printCurrentRequestBeingProcessed();



    }
}

