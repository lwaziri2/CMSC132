/**
 * This is a test class for the Road class. It tests all the methods
 * in the Road class such as the contains, equals, getName, getWeight,
 * getDestination, getSource and the toString.
 * 
 * @author Lima Waziri
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
	private Road roadOne;
	private Road roadTwo;
	private Town townOne;
	private Town townTwo;
	
	@Before
	public void setUp() throws Exception{
		townOne = new Town("College Park");
		townTwo = new Town("White Oak");
		roadOne = new Road(townOne, townTwo, 5, "Stewart Lane");
		roadTwo = new Road(townOne, townTwo, 7, "Campus Drive");
		
	}
	
	@After
	public void tearDown() throws Exception{
		townOne = null;
		townTwo = null;
		roadOne = null;
		roadTwo = null;
	}
	
	 @Test
	 public void testContains() {
		 assertTrue(roadOne.contains(townOne));
		 assertTrue(roadOne.contains(townTwo));
	    }
	 
	 @Test
	 public void testEquals() {
		 Road roadThree = new Road(townOne, townTwo, 5, "Stewart Lane");
		 assertTrue(roadOne.equals(roadThree));
		 assertEquals(roadOne, roadTwo);
	    } 
	 @Test
	 public void testToString() {
		 Road road = new Road(townOne, townTwo, 10, "Stewart Lane");
		 String expected = "Stewart Lane connects College Park and White Oak and is 10 miles long";
		 String actual = road.toString();
		 assertEquals(expected, actual);

		 expected = "Campus Drive connects College Park and White Oak and is 7 miles long";
		 actual = roadTwo.toString();
		 assertEquals(expected, actual);
	    }
	 
	 @Test
	 public void testGetName() {
		 assertEquals("Campus Drive", roadTwo.getName());
		 assertEquals("Stewart Lane", roadOne.getName());

	 }
	 
	 @Test
	 public void testGetWeight() {
		 assertEquals(5, roadOne.getWeight());
		 assertEquals(7, roadTwo.getWeight());
	 }
	 @Test
	 public void testGetDestination() {
		 assertEquals(townTwo, roadOne.getDestination());
		 assertEquals(townTwo, roadOne.getDestination());
	 }
	 
	 @Test
	 public void testGetSource() {
		 assertTrue(roadTwo.getSource().getName().equals("College Park"));
		 assertTrue(roadTwo.getSource().getName().equals("College Park"));
	 }
}
