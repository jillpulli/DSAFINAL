package airlineDemo;
import list.*;
import map.*;
import queue.PriorityQueue;

import java.io.*;
import java.util.Scanner;


/**
 * Manage network of airline flights
 * Find a path, not necessarily shortest,
 * from an Airport to another Airport.
 * input is text file of Direct Flights.
 * @author Jill
 * @version (6 Dec 2016)
 *
 */
public class Airline {

	Map<String, Airport> map;
	
	//map of direct destinations for each origin
	//Map <String, List<Airport>> destMap;
	Map <String, PriorityQueue<Airport>> destMap;
	
	public static void main(String[] args) {
		Airline airline = new Airline();
		airline.getFlights();
		
		System.out.println("Map is " + airline.map);
		System.out.println("Destination map is " + airline.destMap + "\n");
		
		System.out.println("Path from CVG to Paris: ");
		System.out.println(airline.path("CVG", "Paris"));
		
		airline.map.get("PHL").setHub(true);
		
		System.out.println("Path from CVG to Paris (PHL is a hub): ");
		System.out.println(airline.path("CVG", "Paris"));
		
		System.out.println("Path from PHL to Paris: ");
		System.out.println(airline.path("PHL", "Paris"));
	}
	
	/**
	 * @return a list of airports forming a path from
	 * origin to dest. Empty list if no path.
	 */
	private List<Airport> path (String origin, String dest){
		Airport o = map.get(origin);
		Airport d = map.get(dest);
		List<Airport> result = path(o,d);
		//Clear all the visited flags
		getFlights();
		return result;
	}
	
	/**
	 * @return a list of airports forming a path from
	 * origin to dest. Empty list if no path.
	 */
	private List<Airport> path (Airport origin, Airport dest) {
		List <Airport> result = new LinkedList<Airport>();
		//PriorityQueue<Airport> result = new PriorityQueue<Airport>();
		origin.visited = true;
		
		if(origin.equals(dest)){
			result.add(origin);
			return result;
		}
		
		//no paths, empty list
		if (! destMap.containsKey(origin.name)){
			return result;
		}
		
		Airport port;
		//Iterate over all destinations from origin
		Iterator<Airport> itty = destMap.get(origin.name).iterator();
		while (itty.hasNext()){
			port = itty.next();		//dest
			if (! port.visited){
				result = path(port, dest);
				if (result.size() > 0){
					result.add(0, origin);
					return result;
				}
			}
		}
		return result; //empty list, no path found
	}
	
	
	//fill in the maps from a text file
	private void getFlights(){
		
		File inFile = new File ("flights.txt");	//open the file
		map = new HashMap<String, Airport>();
		//destMap = new HashMap<String, List<Airport>>();
		destMap = new HashMap<String, PriorityQueue<Airport>>();
		String flight, origin, dest;
		Airport o,d;
		//List <Airport> dests;	//destinations from one origin 
		PriorityQueue<Airport> dests;
		Scanner scanner;
		try {
			scanner = new Scanner (inFile);
			
			while (scanner.hasNextLine()){
				flight = scanner.nextLine();	//next line
				origin = flight.split(" ")[0];
				dest = flight.split(" ")[1];
			
				if (! map.containsKey(origin)){
					map.put(origin, new Airport (origin));
				}
				if (! map.containsKey(dest)){
					map.put(dest,  new Airport (dest));
				}
			
				o = map.get(origin);	//Airport
				d = map.get(dest);		//Airport
				dests = destMap.get(origin);
			
				if (dests == null){
					//dests = new LinkedList<Airport>();
					dests = new PriorityQueue<Airport>();
				}
				dests.add(d);	//destination airport
				destMap.put(origin, dests);
			}
			scanner.close();

		} 
		catch (FileNotFoundException e) {
			System.out.println("file not found " + e);
		}
		
	}
	
}
