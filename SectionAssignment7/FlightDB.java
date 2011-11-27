/* This database keeps track of all the flight routes
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import acm.util.*;

import java.util.*;

public class FlightDB {
	
	/* Private instance variables */
	private Map <String, FlightCities> flightRoutes = new HashMap <String, FlightCities>(); 
	private String fromCity = " ";
	private String destination = " ";
	
	public FlightDB(String filename) {
		readFile(filename);
	}
	
	//Reads the file with the flight routes
	private void readFile(String filename) {
		try{
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				if(line.length() != 0) {
					parse(line);
					if(flightRoutes.containsKey(fromCity) == false) {
						FlightCities tracker = new FlightCities(fromCity, destination);
						flightRoutes.put(fromCity, tracker);
					}
					else if(flightRoutes.containsKey(fromCity) == true) {
						flightRoutes.get(fromCity).addDestination(destination);
					}
				}
			}
			rd.close();
		} catch(IOException ex) {
				throw new ErrorException(ex);
		}
	}
	
	//parses each line in the flight routes file into the from city and the destination
	private void parse(String line) {
		//name of the from City
		int fromCityEnd = line.indexOf(" ->");
		fromCity = line.substring(0, fromCityEnd);
		
		//name of the to City
		int desinationStart = fromCityEnd + 4;
		destination = line.substring(desinationStart);
	}
	
	//returns all the cities the airline flies from
	public Iterator<String> getCities() {
		return flightRoutes.keySet().iterator();
	}
	
	//finds all the cities a person can fly to from a selected city
	public Iterator<String> findRoute(String fromCity) {
		if(flightRoutes.containsKey(fromCity)) {
			Iterator<String> it = flightRoutes.get(fromCity).getDestinations();
			return it;
		}
		else{
			return null;
		}
	}
	
	//checks to see if the from city is in the database
	public boolean ContainsKey(String fromCity) {
		if(flightRoutes.containsKey(fromCity) == true) {
			return true;
		}
		else{
			return false;
		}
	}
	
}
