/**
 * This class is a test class for the Town class and it tests all the 
 * methods in the Town class such as the compareTo, equals, hashCode and
 * the toString method.
 * 
 * @author Lima Waziri
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {
	Town townOne;
	Town townTwo;

	@Before
	public void setUp() throws Exception{
		townOne = new Town("College Park");
		townTwo = new Town("White Oak");
	}
	
	@After
	public void tearDown() {
		townOne = null;
		townTwo = null;
	}

	@Test
	public void testCopyConstructor() {
		Town originalTown = new Town("Original Town");
		Town copiedTown = new Town(originalTown);
		assertEquals("Original Town", copiedTown.getName());
	}

	@Test
	public void testCompareTo() {
		townOne = new Town("Town A");
		townTwo = new Town("Town B");
		
		assertTrue(townOne.compareTo(townTwo) < 0);
		assertTrue(townTwo.compareTo(townOne) > 0);

}
	@Test
	public void testEquals() {
		townOne = new Town("Town A");
		townTwo= new Town("Town B");
		
		assertFalse(townOne.equals(townTwo));
		assertFalse(townTwo.equals(townOne));
		assertFalse(townOne.equals(null));
		assertFalse(townOne.equals("Town A"));
	}
	@Test
	public void testHashCode() {
		townOne = new Town("Town A");
		townTwo = new Town("Town B");
		
		assertFalse(townOne.hashCode() == townTwo.hashCode());
	}

	@Test
	public void testToString() {
		Town town = new Town("Test Town");
	    town.addAdjacentTowns(new Town("Adjacent Town 1"));
	    town.addAdjacentTowns(new Town("Adjacent Town 2"));
	    String expected = "Name of Town: Test Town\t Adjacent Towns: Adjacent Town 1 Adjacent Town 2 \n";
	    String actual = town.toString();
	    assertEquals(expected, actual);
	}
}
