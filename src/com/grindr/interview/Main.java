package com.grindr.interview;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.grindr.interview.elevator.*;


public class Main {

    Elevator elevator;
    static final int NUMBER_OF_ELEVATORS = 2;
    static final int NUMBER_OF_FLOORS = 10;
    static final int PASSENGERS_TO_GENERATE = 10;

    public static void main(String[] args) {

        try {

            ElevatorController controller = new ElevatorController(NUMBER_OF_ELEVATORS, NUMBER_OF_FLOORS);


            for(PassengerRequest r: generateRandomPassengersRequests(PASSENGERS_TO_GENERATE, NUMBER_OF_FLOORS))
                controller.addRequest(r);

            controller.printWaitingRequest();


            do {
                controller.step();

            }while(controller.elevatorsAreNeeded());

        }catch( Exception ex){
            System.out.println(ex.getMessage());
        }

    }


    public static ArrayList<PassengerRequest> generateRandomPassengersRequests(int passengersToCreate, int maxNumberOfFloors){
        ArrayList<PassengerRequest> passengersRequest = new ArrayList<>();

        for(int i = 0; i<passengersToCreate; i++) {
            int passengerCurrentFloor = 1;//ThreadLocalRandom.current().nextInt(1, maxNumberOfFloors); // all this request will be done in the first floor
            int passengerDestinationFloor = ThreadLocalRandom.current().nextInt(1, maxNumberOfFloors);
            passengersRequest.add(new PassengerRequest(passengerDestinationFloor, passengerCurrentFloor));

        }
        return passengersRequest;
    }






}
