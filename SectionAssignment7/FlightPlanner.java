/* This is the solution to Stanford CS106A Section Assignment 8 - Data Structures. 
 * Your task for this section is to write a  program that reads in a file containing flight 
destinations from various cities, and then allow the user to plan a round-trip flight route.
 * 
 */

import java.util.*;
import acm.program.*;

public class FlightPlanner extends ConsoleProgram {
	
	/* Private instance variables */
	private FlightDB flights; //creates a new database
	private ArrayList<String> enteredCities = new ArrayList<String>(); //keeps track of entered cities
	private String firstCity; //keeps track of the first city entered by the user
	
	public void init() {
		//passes the text file to the database to read and parse
		flights = new FlightDB("flights.txt");
	}
	
	public void run() {
		welcome();
		askForFistCity();
		askForMoreCities();
		printFinalRoute();
	}
	
	/* Welcomes the user */
	private void welcome() {
		println("Welcome to Flight Planner");
		println("Here is a list of all the cities in our database");
		Iterator<String> it = flights.getCities();
		while(it.hasNext()) {
			println(" " + it.next());
		}
		println("Let's plan a round-trip route!");
	}
	
	/* asks the user for the starting city and prints out 
	 * all the possible destination cities for that city */
	private void askForFistCity() {
		while(true) {
			firstCity = readLine("Enter the starting city: ");
			if(flights.ContainsKey(firstCity)) {
				enteredCities.add(firstCity);
				break;
			}
			else{
				println("You can't get to that city by a direct flight.");
				println("Here is a list of all the cities in our database");
				Iterator<String> it = flights.getCities();
				while(it.hasNext()) {
					println(" " + it.next());
				}
			}
		}
		println("From " + firstCity + " you can fly directly to:");
		Iterator<String> it = flights.findRoute(firstCity);
		while(it.hasNext()) {
			println(" " + it.next());
			}
	}
	
	/* asks the user for the cities he/she wants to fly to, 
	 * and prints out possible destination cities for each city
	 * until the user enters the starting city */
	private void askForMoreCities() {
		String city = firstCity;
		String lastCity = city;
		while(true) {
			city = readLine("Where do you want to go from " + city + "? ");
			if(city.equals(firstCity)) {
				break;
			}
			if(flights.ContainsKey(city) == true) {
				lastCity = city;
				enteredCities.add(city);
				}
			else{
				city = lastCity;
				println("You can't get to that city by a direct flight.");
			}
			println("From " + city + " you can fly directly to:");
			Iterator<String> it = flights.findRoute(city);
			while(it.hasNext()) {
				println(" " + it.next());
			}
			
		}
	}
	
	/* prints out the chosen route */
	private void printFinalRoute() {
		println("The route you've chosen is");
		String route = enteredCities.get(0);
		for(int i = 1; i<enteredCities.size(); i++) {
			route += " -> " + enteredCities.get(i);
		}
		route += " -> " + enteredCities.get(0);
		println(route);
	}
	
}
