
import acm.util.*;
import java.util.*;

public class FlightCities {
	
	private ArrayList <String> destinations = new ArrayList<String>();
	private String city = " ";
	private String destination = " ";
	
	public FlightCities(String fromCity, String aDestination) {
		city = fromCity;
		destination = aDestination;
		destinations.add(destination);
	}
	
	public String getFromCity() {
		return city;
	}
	
	public Iterator<String> getDestinations() {
		return destinations.iterator();
	}
	
	public void addDestination(String aDestination) {
		destinations.add(aDestination);
	}
	
}
