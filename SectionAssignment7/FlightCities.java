
import acm.util.*;
import java.util.*;

public class FlightCities {
	
	/* Private instance variables */
	private ArrayList <String> destinations = new ArrayList<String>();
	private String city = " ";
	private String destination = " ";
	
	public FlightCities(String fromCity, String aDestination) {
		city = fromCity;
		destination = aDestination;
		destinations.add(destination); //adds the first destination to the array list
	}
	
	/* returns the starting city */
	public String getFromCity() {
		return city;
	}
	
	/* returns the destination cities for each starting city */
	public Iterator<String> getDestinations() {
		return destinations.iterator();
	}
	
	/* adds a destination to the array list */
	public void addDestination(String aDestination) {
		destinations.add(aDestination);
	}
	
}
