# README #

This project is a quick and dirty attempt to build a very basic elevator controller as part of a coding question during my Grindr interview.

The Main program will generate randomly a bunch of PassengerRequest which then will be split among the elevators(as long as they are not full).

This program does not handle the case where we add more request as we reach another floor, it will process that batch of generated request in the Main program only, tweaking the program to add request on each of the stops shouldn't be hard, but I already ran out of time.


### Classes and enumerations ###

* Elevator: Originally I thought of using this as an abstract class, but I didn't end up implementing multiple models for my elevator, so I just removed the interfaces I showed yesterday and keep this very simple.
* ElevatorController:This class holds the assignment logic and initialization of objects.
* ElevatorDirection: Just a simple enumeration indicating the elevator direction
* PassengerRequest: A passenger wrapper that could potentially hold other properties that passengerWeight or floorAccess


### Sample output ###

Please refer to the output.txt file located at the root of this repo to see a sample output of the execution of this program
