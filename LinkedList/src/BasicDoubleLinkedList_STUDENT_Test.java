import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Test cases for the BasicDoubleLinkedList class
 * The tests include adding items to the front and end of the list, getting the first and last elements in the list,
 * getting the size of the list, and testing the iterator functionality of the list.
 * 
 * @author Lima Waziri
 * @date 03/04/2023
 */

public class BasicDoubleLinkedList_STUDENT_Test {
	// Variables
	BasicDoubleLinkedList<String> linkedStrings;
	BasicDoubleLinkedList<Movie> linkedMovie;
	StringComparator comparator;
	MovieComparator comparatorMovie;

	// Movie Objects
	public Movie a = new Movie("Black Panther 2");
	public Movie b = new Movie("Avengers: Endgame");
	public Movie c = new Movie("Grown Ups");
	public Movie d = new Movie("Pathaan");
	public Movie e = new Movie("Forrest Gump");
	public Movie f = new Movie("Interstellar");

	public ArrayList<Movie> fill = new ArrayList<Movie>();

	@Before
	public void setUp() throws Exception {
		// Initialize variables and add data
		linkedStrings = new BasicDoubleLinkedList<String>();
		linkedStrings.addToEnd("Candy");
		linkedStrings.addToEnd("World");
		comparator = new StringComparator();

		linkedMovie = new BasicDoubleLinkedList<Movie>();
		linkedMovie.addToEnd(b);
		linkedMovie.addToEnd(c);
		comparatorMovie = new MovieComparator();
	}

	@After
	public void tearDown() throws Exception {
		// Reset variables
		linkedStrings = null;
		linkedMovie = null;
		comparator = null;
	}
	/**
	 * Test the getSize() method
	 */
	@Test
	public void testGetSize() {
		assertEquals(2, linkedStrings.getSize());
		assertEquals(2, linkedMovie.getSize());
	}
	/**
	 *Test adding an item to the front of the list
	 */
	@Test
	public void testAddToFront() {
		assertEquals(b, linkedMovie.getFirst());
		linkedMovie.addToFront(a);
		assertEquals(a, linkedMovie.getFirst());

		assertEquals("Candy", linkedStrings.getFirst());
		linkedStrings.addToFront("Begin");
		assertEquals("Begin", linkedStrings.getFirst());
	}
	/**
	 *Test adding an item to the end of the list
	 */
	@Test
	public void testAddToEnd() {
		assertEquals("World", linkedStrings.getLast());
		linkedStrings.addToEnd("Yummy");
		assertEquals("Yummy", linkedStrings.getLast());

		assertEquals(c, linkedMovie.getLast());
		linkedMovie.addToEnd(d);
		assertEquals(d, linkedMovie.getLast());
	}
	/**
	 * Test getting the last element in the list
	 */
	@Test
	public void testGetLast() {
		assertEquals(c, linkedMovie.getLast());
		linkedMovie.addToEnd(d);
		assertEquals(d, linkedMovie.getLast());

		assertEquals("World", linkedStrings.getLast());
		linkedStrings.addToEnd("DIS");
		assertEquals("DIS", linkedStrings.getLast());

	}
	/**
	 * Test getting the first element in the list
	 */
	@Test
	public void testGetFirst() {
		assertEquals(b, linkedMovie.getFirst());
		linkedMovie.addToFront(a);
		assertEquals(a, linkedMovie.getFirst());

		assertEquals("Candy", linkedStrings.getFirst());
		linkedStrings.addToFront("New");
		assertEquals("New", linkedStrings.getFirst());

	}
	/**
	 * Test the iterator's previous() method
	 */
	@Test
	public void testIteratorSuccessfulPrevious() {
		linkedMovie.addToFront(a);
		linkedMovie.addToEnd(d);
		ListIterator<Movie> iteratorCar = linkedMovie.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());
	}
	
	/**
	 * Tests the toArrayList() method
	 */
	@Test
	public void testToArrayList() {
		ArrayList<Movie> list;
		linkedMovie.addToFront(a);
		linkedMovie.addToEnd(d);
		list = linkedMovie.toArrayList();
		assertEquals(a, list.get(0));
		assertEquals(b, list.get(1));
	}
	/**
	 *  This method tests the iterator for a linked list of strings and a linked list
	 *  of movies. It adds elements to the beginning and end of the lists, creates iterators,
	 *  and tests that the iterators return the correct values using the next() method.
	 */
	@Test
	public void testIteratorSuccessfulNext() {
		linkedStrings.addToFront("Begin");
		linkedStrings.addToEnd("Candy");
		ListIterator<String> iterator = linkedStrings.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Candy", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Candy", iterator.next());

		linkedMovie.addToFront(a);
		linkedMovie.addToEnd(d);
		ListIterator<Movie> iteratorCar = linkedMovie.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());
	}
	/**
	 * This method tests that an UnsupportedOperationException is thrown 
	 * when using the remove() method
	 */

	@Test
	public void testIteratorUnsupportedOperationException() {
		linkedMovie.addToFront(a);
		linkedMovie.addToEnd(d);
		ListIterator<Movie> iteratorCar = linkedMovie.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());

		try {
			iteratorCar.remove();
			assertTrue("Did not throw a UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw a UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}

	}
	/**
	 *  This method tests that a NoSuchElementException is thrown when using the next() method
	 */

	@Test
	public void testIteratorNoSuchElementExceptionNext() {
		linkedMovie.addToFront(a);
		linkedMovie.addToEnd(d);
		ListIterator<Movie> iteratorCar = linkedMovie.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(d, iteratorCar.next());

		try {
			iteratorCar.next();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}
	/**
	 * This method tests that a NoSuchElementException is thrown using the 
	 * previous() method
	 */

	@Test
	public void testIteratorNoSuchElementExceptionPrevious() {
		linkedMovie.addToFront(a);
		linkedMovie.addToEnd(d);
		ListIterator<Movie> iteratorCar = linkedMovie.iterator();
		assertEquals(true, iteratorCar.hasNext());
		assertEquals(a, iteratorCar.next());
		assertEquals(b, iteratorCar.next());
		assertEquals(c, iteratorCar.next());
		assertEquals(d, iteratorCar.next());
		assertEquals(true, iteratorCar.hasPrevious());
		assertEquals(d, iteratorCar.previous());
		assertEquals(c, iteratorCar.previous());
		assertEquals(b, iteratorCar.previous());
		assertEquals(a, iteratorCar.previous());

		try {
			iteratorCar.previous();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}

	}
	
	/**
	 * This method tests the remove() method of the linked list. 
	 */
	@Test
	public void testRemove() {
		// Test the remove() method
		assertEquals(b, linkedMovie.getFirst());
		assertEquals(c, linkedMovie.getLast());
		linkedMovie.addToFront(a);

		assertEquals(a, linkedMovie.getFirst());
		linkedMovie.remove(a, comparatorMovie);
		assertEquals(b, linkedMovie.getFirst());

		linkedMovie.addToFront(a);
		assertEquals(a, linkedMovie.getFirst());
		assertEquals(c, linkedMovie.getLast());
		linkedMovie.remove(b, comparatorMovie);
		assertEquals(a, linkedMovie.getFirst());
		assertEquals(c, linkedMovie.getLast());

	}
	/**
	 *  This method tests the retrieveFirstElement() method of the linked list. 
	 */
	@Test
	public void testRetrieveFirstElement() {
		// Test the retreieveFirstElement() method
		assertEquals(b, linkedMovie.getFirst());
		linkedMovie.addToFront(a);
		assertEquals(a, linkedMovie.getFirst());
		assertEquals(a, linkedMovie.retrieveFirstElement());

		assertEquals("Candy", linkedStrings.getFirst());
		linkedStrings.addToFront("Bye");
		assertEquals("Bye", linkedStrings.getFirst());
		assertEquals("Bye", linkedStrings.retrieveFirstElement());
		assertEquals("Candy", linkedStrings.getFirst());
		assertEquals("Candy", linkedStrings.retrieveFirstElement());
		assertEquals("World", linkedStrings.getFirst());

	}
	/**
	 * This method tests the retrieveLastElement() method of the linked list. 
	 */
	@Test
	public void testRetrieveLastElement() {
		assertEquals(c, linkedMovie.getLast());
		linkedMovie.addToEnd(d);
		assertEquals(d, linkedMovie.getLast());
		assertEquals(d, linkedMovie.retrieveLastElement());

		assertEquals("World", linkedStrings.getLast());
		linkedStrings.addToEnd("Bye");
		assertEquals("Bye", linkedStrings.getLast());
		assertEquals("Bye", linkedStrings.retrieveLastElement());
	}

	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class MovieComparator implements Comparator<Movie> {

		@Override
		public int compare(Movie arg0, Movie arg1) {
			// Just put Movies in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}

	}
	
	/**
	 * Private inner class Movie that is used to test the BasicDoubleLinkedList class in the class obove
	 */
	private class Movie {
		String name;

		public Movie(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			return getName();
		}
	}

}
