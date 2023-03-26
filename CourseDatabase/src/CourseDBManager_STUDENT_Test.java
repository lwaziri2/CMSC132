import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
/**
 * This is a test class for the CourseDBManager class
 * @author Lima Waziri
 *
 */
class CourseDBManager_STUDENT_Test {
	private CourseDBManager manag = new CourseDBManager();
	
	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		manag = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		manag = null;
	}
	
	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			manag.add("MATH120",902843,4,"SC301","Steven Chadwick");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		manag.add("BIO270",28429,4,"SC109","Heather Brown");
		manag.add("MATH182",20458,4,"SC105","Steven Chadwick");
		
		ArrayList<String> list = manag.showAll();
		
		assertEquals(list.get(0),"\nCourse:BIO270 CRN:28429 Credits:4 Instructor:Heather Brown Room:SC109");
	 	assertEquals(list.get(1),"\nCourse:MATH182 CRN:20458 Credits:4 Instructor:Steven Chadwick Room:SC105");
	}
	
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("BIO270 28429 4 SC109 Heather Brown");
			inFile.print("MATH120 20458 4 SC105 Steven Chadwick");
			
			inFile.close();
			
			manag.readFile(inputFile);
			assertEquals("MATH120",manag.get(20458).getID());
			assertEquals("SC105",manag.get(20458).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
	/**
	 * Tests for the get method
	 */
	@Test
	public void testGet() {
		CourseDBElement element = new CourseDBElement("CMSC131", 20987,4, "IRIB20", "Nelson P.");
		manag.add("CMSC131", 20987, 4, "IRIB20", "Nelson P.");
		assertEquals(0,manag.get(20987).compareTo(element));
}

		
	
}
