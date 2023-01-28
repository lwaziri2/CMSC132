import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
/*
 * @author Lima Waziri
 */

class GradeBookTester {
		private GradeBook obj1;
		private GradeBook obj2;
			
	// 1a setUp method
		@Before
		public void setUp() {
			obj1 = new GradeBook(5);
			obj2 = new GradeBook(5);
			obj1.addScore(85);
			obj1.addScore(70);
			obj2.addScore(60);
			obj2.addScore(90);
		}
		
	// 1b tearDown method
		@After
		public void tearDown() {
			obj1 = null;
			obj2 = null;
		}
		
	// 5a test addScore
		@Test
		public void testAddScore() {
			setUp();
			assertTrue(obj1.toString().equals("85.0 70.0"));
			assertTrue(obj2.toString().equals("60.0 90.0"));
			assertEquals(obj1.getScoreSize(),2);
			assertEquals(obj2.getScoreSize(),2);
			tearDown();
		}
		
	//5b test sum
		@Test
		public void testSum() {
			setUp();
			assertEquals(155, obj1.sum(), .0001);
			assertEquals(150, obj2.sum(), .0001);
			tearDown();
		}
	//5c test minimum
		@Test
		public void testMinimum() {
			setUp();
			assertEquals(obj1.minimum(), 70, .001);
			assertEquals(obj2.minimum(),60, .001);
			tearDown();
		}
	//5d test finalScore
		@Test
		public void testFinalScore() {
			setUp();
			assertEquals(obj1.finalScore(),85, .001);
			assertEquals(obj2.finalScore(),90, .001);
			tearDown();
			
		}
		

}
