package airlineDemo;

/**
 * Airport available to the Airline
 * Airport has a name
 * @author Jill
 * @version (6 Dec 2016)
 *
 */
public class Airport implements Comparable<Airport>{
	String name;
	boolean visited = false;
	boolean hub;
	
	public Airport(String name) {
		this.name = name;
	}
	
	public Airport(String name, boolean hub){
		this.name = name;
		this.hub = hub;
	}
	
	/**
	 * @return true only if this Airport equals obj
	 */
	public boolean equals (Object obj) {
		if (! (obj instanceof Airport)) {
			return false;
		}
		Airport other = (Airport) obj;
		return name.equals(other.name) && hub==other.hub;
	}
	
	public void setHub(boolean hub){
		this.hub = hub;
	}
	
	public String toString() {
		String result = name;
		if (hub)
			result += ".hub";
		if (visited)
			result += "*";
		return result;
	}

	@Override
	public int compareTo(Airport o) {
		Airport other = o;
		if (hub && (! other.hub)){
			return 1;
		}
		if ((! hub) && (other.hub)){
			return -1;
		}
		return 0;		//both are/aren't hubs	
	}

}
