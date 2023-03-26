import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The CourseDBStructure class represents a hash table data structure for
 * storing CourseDBElement objects. It also implements
 * CourseDBStructureInterface which defines the methods: add, get, showAll, and
 * getTableSize
 *
 * When building a hash table, an array of linked lists is used to group
 * together items that have the same "hash" value. So, each linked list in the
 * array contains all the items that share a common hash value. To figure out
 * how big the hash table needs to be, we consider the number of items we want
 * to store in it. First, we divide that number by a loading factor of 1.5 that
 * was given to us. Then, we find the next prime number that is larger than the
 * result we got. That's how big the hash table should be.
 * <p>
 * 
 * @see CourseDBStructureInterface
 * @see CourseDBElement
 * @author Lima Waziri
 * @date 03/25/2023
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	protected ArrayList<LinkedList> hashTable;
	protected int hashSize;
	protected final double LOADINGFACTOR = 1.5;

	/**
	 * The constructor will create a new CourseDBStructure object with the specified
	 * number of elements that will be store
	 * 
	 * @param n the number of elements
	 */
	public CourseDBStructure(int n) {
		hashSize = tableSize(n);
		hashTable = new ArrayList<LinkedList>();
		for (int i = 0; i < hashSize; i++) {
			hashTable.add(null);
		}
	}

	/**
	 * This second constructor will create a new CourseDBStructure object with the
	 * specified size of the hash table
	 * 
	 * @param testing
	 * @param size    the size of the hash table
	 */
	public CourseDBStructure(String testing, int size) {
		hashSize = size;
		hashTable = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			hashTable.add(null);
		}
	}

	/**
	 * Adds a CourseDBElement object to the CourseDBStructure using the hashcode of
	 * the CourseDatabaseElemen object's crn value. If the CourseDatabaseElement
	 * already exists, exit quietly
	 * 
	 * @param element the CourseDBElement to be added to CourseDBStructure
	 */

	@Override
	public void add(CourseDBElement element) {
		int index = hash(element.getCRN());
		LinkedList<CourseDBElement> list;
		boolean isFound = false;
		CourseDBElement t;
		if (hashTable.get(index) == null) {
			list = new LinkedList<CourseDBElement>();
			list.add(element);
			hashTable.set(index, list);
		} else {
			list = hashTable.get(index);
			for (int i = 0; i < list.size(); i++) {
				t = list.get(i);
				if (element.compareTo(t) == 0) {
					isFound = true;
					if (!element.compareData(t)) {
						t.setCredits(element.getCredits());
						t.setID(element.getID());
						t.setInstructor(element.getInstructor());
						t.setRoomNum(element.getRoomNum());
					}
					break;
				}
			}
			if (!isFound) {
				list.add(element);
			}
		}
	}

	/**
	 * Find a courseDatabaseElement based on the key (crn) of the
	 * courseDatabaseElement If the CourseDatabaseElement is found return it If not,
	 * throw an IOException
	 * 
	 * @param crn crn (key) whose associated courseDatabaseElement is to be returned
	 * @return a CourseDBElement whose crn is mapped to the key
	 * @throws IOException if key is not found
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		LinkedList<CourseDBElement> list = null;
		int index = hash(crn);
		list = hashTable.get(index);
		if (list != null) {
			for (CourseDBElement e : list) {
				if (e.getCRN() == crn) {
					return e;
				}
			}
		}
		throw new IOException();
	}

	/**
	 * @return an array list of string representation of each course in the data
	 *         structure separated by a new line. Refer to the following example:
	 *         Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular
	 *         Room:SC100 Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody
	 *         Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> courseList = new ArrayList<>();
		for (LinkedList<CourseDBElement> course : hashTable) {
			if (course != null) {
				for (CourseDBElement e : course) {
					courseList.add("\n" + e.toString());
				}
			}
		}
		return courseList;
	}

	/**
	 * Returns the size of the ConcordanceDataStructure (number of indexes in the
	 * array)
	 */
	@Override
	public int getTableSize() {
		return hashSize;
	}

	/**
	 * the tableSize method will calculate the size of the hash table based on the
	 * given loading factor of 2.5 and then return the next prime number greater or
	 * equal to this size.
	 * 
	 * @param nextPrime the next prime number after the number of CRNs to be stored
	 * @return the size of the hash table
	 */
	public int tableSize(int nextPrime) {
		boolean primeFound = false;
		int length, prime;

		length = (int) (nextPrime / LOADINGFACTOR);
		if (length % 2 == 0) {
			prime = length + 1;
		} else {
			prime = length + 2;
		}
		while (!primeFound) {
			primeFound = true;
			for (int i = 2; i <= Math.sqrt(prime); i++) {
				if (prime % i == 0) {
					prime += 2;
					primeFound = false;
					break;
				}
			}
			if (primeFound) {
				while (prime % 4 != 3) {
					prime += 2;
					primeFound = false;
				}
			}
		}
		return prime;
	}

	/**
	 * The hash method will take a CRN as an input and returns the index where the
	 * CRN should be store in the hash table.
	 * 
	 * @param crn the CRN to be stored in the hash table.
	 * @return the index where the CRN should be put in the hash table
	 */
	public int hash(int crn) {
		String code = Integer.toString(crn);
		int hash = code.hashCode();
		int index = hash % hashSize;
		return index;
	}

}
