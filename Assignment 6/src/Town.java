import java.util.ArrayList;
/**
 * This town class represents a town with a name and a list of adjacent towns.
 * It also implement the comparable interface, so 2 towns would be considered 
 * the same if their names are the same
 * 
 * 
 * @author Lima Waziri
 * @see Comparable
 *
 */

public class Town implements Comparable <Town>{

	private String name;
	private ArrayList<Town> adjTowns;
	
	/**
	 * constructor
	 */
	public Town(String name) {
		this.name=name;
		adjTowns=new ArrayList<Town>();
		
	}
	/**
	 * copy constructor
	 */
	public Town(Town templateTown) {
		this(templateTown.getName());
		setAdjacentTowns(templateTown.getAdjacentTowns());
	}


	public void setName(String name) {
		this.name=name;
	}


	public String getName() {
		return name;
	}


	public void setAdjacentTowns(ArrayList<Town> towns) {
		
		for(int i=0;i<towns.size();i++) {
			adjTowns.add(towns.get(i));
		}
	}


	public void addAdjacentTowns(Town town) {
		adjTowns.add(town);
	}
	


	public ArrayList<Town> getAdjacentTowns(){
		return adjTowns;
	}

	@Override
	public int compareTo(Town town) {
		if(town.getName().equalsIgnoreCase(name)) {
			return 0;
		}
		else {
			return name.compareToIgnoreCase(town.getName());
		}
	}

	public int hashCode() {
		return name.hashCode();
	}

	public String toString() {
		String town="";
		for(int i=0;i<adjTowns.size();i++) {
			town+=adjTowns.get(i).getName()+" ";
		}
		return "Name of Town: "+name +"\t Adjacent Towns: "+ town+"\n";
	}

}