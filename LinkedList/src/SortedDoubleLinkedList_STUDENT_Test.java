
import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Studen Test cases for the SortedDoubleLinkedList class
 * @author Lima Waziri
 * @date 03/04/2023
 */
public class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedString;
	SortedDoubleLinkedList<Double> sortedLinkedDouble;
	SortedDoubleLinkedList<Movie> sortedLinkedMovie;
	StringComparator comparator;
	DoubleComparator comparatorD;
	MovieComparator comparatorMovie;
	
	//Movie Objects
	public Movie a = new Movie("Black Panther 2", 2022, "Action");
	public Movie b = new Movie("Avengers: Endgame", 2019, "Science Fiction");
	public Movie c = new Movie("Grown Ups", 2010, "Comedy");
	public Movie d = new Movie("Pathaan", 2023, "Thriller");
	public Movie e = new Movie("Forrest Gump", 1994, "Romantic Comedy");
	public Movie f = new Movie("Interstellar", 2014, "Adventure");
	// alphabetic order: b, a, e,c,f,d

	@Before
	public void setUp() throws Exception {
		// Initialize variables and add data
		comparator = new StringComparator();
		sortedLinkedString = new SortedDoubleLinkedList<String>(comparator);

		comparatorD = new DoubleComparator();
		sortedLinkedDouble = new SortedDoubleLinkedList<Double>(comparatorD);

		comparatorMovie = new MovieComparator();
		sortedLinkedMovie = new SortedDoubleLinkedList<Movie>(comparatorMovie);

	}

	@After
	public void tearDown() throws Exception {
		// Reset variables
		comparator = null;
		comparatorD = null;
		comparatorMovie = null;
		sortedLinkedString = null;
		sortedLinkedDouble = null;
		sortedLinkedMovie = null;
	}
	/**
	 * Test adding an item to the end of the list
	 */
	@Test
	public void testAddToEnd() {
		try {
			sortedLinkedString.addToEnd("WAKANA");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	/**
	 * Test adding an item to the front of the list
	 */
	@Test
	public void testAddToFront() {
		try {
			sortedLinkedString.addToFront("WAKANDA");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	/**
	 * This method tests the iterator for a linked list of movies. It adds elements to the beginning 
	 * and end of the lists, creates iterators, and tests that the iterators return the correct values using the next() method.
	 */
	@Test
	public void testIteratorSuccessfulNext() {
		// Test the iterator's next() method
		sortedLinkedMovie.add(e);
		sortedLinkedMovie.add(f);
		sortedLinkedMovie.add(d);
		ListIterator<Movie> iterator = sortedLinkedMovie.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(e, iterator.next());
		assertEquals(f, iterator.next());
		assertEquals(true, iterator.hasNext());
	}
	
	/**
	 * This method tests the iterator for a linked list of strings using the previous method
	 */
	@Test
	public void testIteratorSuccessfulStringPrevious() {
		sortedLinkedString.add("Begin");
		sortedLinkedString.add("World");
		sortedLinkedString.add("Hello");
		sortedLinkedString.add("Zebra");
		ListIterator<String> iterator = sortedLinkedString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Begin", iterator.next());
		assertEquals("Hello", iterator.next());
		assertEquals("World", iterator.next());
		assertEquals("Zebra", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Zebra", iterator.previous());
		assertEquals("World", iterator.previous());
		assertEquals("Hello", iterator.previous());
	}
	
	/**
	 * This method tests the iterator for a linked list of movies using the previous() method.
	 */
	@Test
	public void testIteratorSuccessfulMoviePrevious() {
		// Test the iterator's next() method for the movie object
		// alphabetic order: b, a, e,c,f,d
		sortedLinkedMovie.add(b);
		sortedLinkedMovie.add(c);
		ListIterator<Movie> iterator = sortedLinkedMovie.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(c, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals(c, iterator.previous());
	}
	/**
	 * This method tests the iterator for a linked list of doubles using the next() method
	 */
	@Test
	public void testIteratorSuccessfulDoubleNext() {
		// Test the iterator's next() method for a double
		sortedLinkedDouble.add((Double) 8.0);
		sortedLinkedDouble.add((Double) 4.0);
		sortedLinkedDouble.add((Double) 1.0);
		sortedLinkedDouble.add((Double) 2.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals((Double) 1.0, iterator.next());
		assertEquals((Double) 2.0, iterator.next());
		assertEquals((Double) 4.0, iterator.next());
		assertEquals(true, iterator.hasNext());
	}
	/**
	 * This method tests the iterator for a linked list of double using the previous() method 
	 */
	@Test
	public void testIteratorSuccessfulDoublePrevious() {
		// Test the iterator's next() method for a double
		sortedLinkedDouble.add((Double) 8.0);
		sortedLinkedDouble.add((Double) 10.0);
		sortedLinkedDouble.add((Double) 9.0);
		sortedLinkedDouble.add((Double) 3.0);
		ListIterator<Double> iterator = sortedLinkedDouble.iterator();
		assertEquals((Double) 3.0, iterator.next());
		assertEquals((Double) 8.0, iterator.next());
		assertEquals((Double) 9.0, iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals((Double) 9.0, iterator.previous());
		assertEquals(true, iterator.hasPrevious());
	}
	/**
	 * This method tests that a NoSuchElementException is thrown when using the next()
	 * and hasNext() method
	 */
	@Test
	public void testIteratorNoSuchElementException() {
		sortedLinkedMovie.add(b);
		sortedLinkedMovie.add(d);
		// alphabetic order: b, a, e,c,f,d
		ListIterator<Movie> iterator = sortedLinkedMovie.iterator();

		assertEquals(true, iterator.hasNext());
		assertEquals(b, iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		try {
			iterator.next();
			assertTrue("Did not throw a NoSuchElementException", false);
		} catch (NoSuchElementException e) {
			assertTrue("Successfully threw a NoSuchElementException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the NoSuchElementException", false);
		}
	}
	
	/**
	 * This method tests that an UnsupportedOperationException is thrown for a string
	 */
	@Test
	public void testIteratorUnsupportedOperationExceptionString() {
		sortedLinkedMovie.add(e);
		sortedLinkedMovie.add(c);
		ListIterator<Movie> iterator = sortedLinkedMovie.iterator();

		try {
			iterator.remove();
			assertTrue("Did not throw a UnsupportedOperationException", false);
		} catch (UnsupportedOperationException e) {
			assertTrue("Successfully threw a UnsupportedOperationException", true);
		} catch (Exception e) {
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}
	
	/**
	 * tests the add() method for the movie object
	 */
	@Test
	public void testAddMovie() {
		// alphabetic order: b, a, e,c,f,d
		sortedLinkedMovie.add(e);
		sortedLinkedMovie.add(f);
		assertEquals(e, sortedLinkedMovie.getFirst());
		assertEquals(f, sortedLinkedMovie.getLast());
		sortedLinkedMovie.add(d);
		sortedLinkedMovie.add(b);
		assertEquals(d, sortedLinkedMovie.retrieveLastElement());
		assertEquals(f, sortedLinkedMovie.getLast());
	}
	
	/**
	 * tests the remove() method for movie object to remove the first movie
	 */
	@Test
	public void testRemoveFirstMovie() {
		// alphabetic order: b, a, e,c,f,d
		sortedLinkedMovie.add(f);
		sortedLinkedMovie.add(c);
		assertEquals(c, sortedLinkedMovie.getFirst());
		assertEquals(f, sortedLinkedMovie.getLast());
		sortedLinkedMovie.add(e);
		sortedLinkedMovie.remove(e, comparatorMovie);
		assertEquals(c, sortedLinkedMovie.getFirst());
	}
	
	/**
	 * tests the remove() method for movie object to remove the last movie
	 */
	@Test
	public void testRemoveEndMovie() {
		sortedLinkedMovie.add(e);
		sortedLinkedMovie.add(a);
		assertEquals(a, sortedLinkedMovie.getFirst());
		assertEquals(e, sortedLinkedMovie.getLast());
		sortedLinkedMovie.add(d);
		sortedLinkedMovie.remove(d, comparatorMovie);
		assertEquals(e, sortedLinkedMovie.getLast());
	}
	
	/**
	 * tests the remove() method for movie object to remove the middle movie
	 */
	@Test
	public void testRemoveMiddleMiddle() {
		// alphabetic order: b, a, e,c,f,d
		sortedLinkedMovie.add(e);
		sortedLinkedMovie.add(f);
		assertEquals(e, sortedLinkedMovie.getFirst());
		sortedLinkedMovie.add(a);

		assertEquals(f, sortedLinkedMovie.getLast());
		assertEquals(3, sortedLinkedMovie.getSize());

		sortedLinkedMovie.remove(e, comparatorMovie);
		assertEquals(a, sortedLinkedMovie.getFirst());
		assertEquals(2, sortedLinkedMovie.getSize());
	}
	


	private class StringComparator implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class DoubleComparator implements Comparator<Double> {

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}

	}

	private class MovieComparator implements Comparator<Movie> {

		@Override
		public int compare(Movie arg0, Movie arg1) {
			// Just put cars in alphabetic order by make
			return arg0.getName().compareTo(arg1.getName());
		}
	}
/**
 * Private inner class that is used in the class obove to test the SortedBasicDoubleLinkedList class
 * @author Lima Waziri
 *
 */
	private class Movie {
		String name;
		String genre;
		int year;

		public Movie(String name, int year, String genre) {
			this.name = name;
			this.genre = genre;
			this.year = year;
		}

		public String getName() {
			return name;
		}

		public String getGenre() {
			return genre;
		}

		public int getYear() {
			return year;
		}

		public String toString() {
			return (getName() + " " + getYear() + " " + getGenre());
		}
	}
}
