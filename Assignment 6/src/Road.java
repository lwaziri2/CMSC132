/**
 * This Road class represents the edges of a Graph of Towns. This class
 * will store the references to the two vertices(town endpoints), 
 * the distance of vertices, and the name. This class will also implement
 * the comparable interface
 * 
 * @author Lima Waziri
 * @see Comparable
 *
 */
public class Road implements Comparable<Road>{
	
	private Town town1;
	private Town town2;
	private int weight;
	private String name;
	
	public Road(Town source, Town destination, int weight, String name) {
		town1=source;
		town2=destination;
		this.weight=weight;
		this.name=name;
	}

	public Road(Town source, Town destination, String name) {
		this(source,destination,1,name);
		
	}

	public Town getSource() {
		return town1;
	}

	public void setSource(Town town1) {
		this.town1 = town1;
	}

	public Town getDestination() {
		return town2;
	}

	public void setDestination(Town town2) {
		this.town2 = town2;
	}

	public int getWeight() {
		return weight;
	}

	public void setDistance(int distance) {
		this.weight = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean contains(Town town) {
		return ((town.getName().equalsIgnoreCase(town1.getName()))|| (town.getName().equalsIgnoreCase(town2.getName())));
	}

	@Override
	public int compareTo(Road r) {
		return name.compareToIgnoreCase(r.getName());
	}

	@Override
	public boolean equals(Object r) {
		if(!(r instanceof Road)) {
			return false;
		}
		else {
			String rTown1=((Road) r).getSource().getName();
			String rTown2=((Road) r).getDestination().getName();
			if((town1.getName().equalsIgnoreCase(rTown1)||town1.getName().equalsIgnoreCase(rTown2))&&(town2.getName().equalsIgnoreCase(rTown1)||town2.getName().equalsIgnoreCase(rTown2))) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	/**
	 * @return string format of road information
	 */
	@Override
	public String toString() {
		return name + " connects " + town1.getName() + " and " + town2.getName()+" and is "+ weight + " miles long";
		
	}
}