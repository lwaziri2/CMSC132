import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTreeStudentTest {

	MorseCodeTree tree;
	TreeNode<String> newNode = new TreeNode<>("RANDOM");

	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}
	
	@Test
	public void getRootTest() {
		assertTrue(tree.getRoot().getData().equals(""));
		newNode.leftChild = tree.getRoot().leftChild;
		tree.setRoot(newNode);
	    assertEquals(newNode, tree.getRoot());
	}

	@Test
	public void fetchTest() {
		assertTrue(tree.fetch(".-..").equals("l"));
		assertTrue(tree.fetch(".---").equals("j"));
		assertTrue(tree.fetch("---").equals("o"));
		assertTrue(tree.fetch("-.-.").equals("c"));
		assertTrue(tree.fetch("..-.").equals("f"));

	}
	
	@Test
	public void insertTest() {
		tree.insert(".", "A");
		tree.insert(".-", "C");
		assertEquals("A", tree.getRoot().leftChild.getData());
	    assertEquals("C", tree.getRoot().leftChild.rightChild.getData());

	}
	
	@Test
	public void toArrayListTest() {
		assertTrue(tree.toArrayList().toString().equals("[h, s, v, i, f, u, e, l, r, a, p, w, j, , b, d, x, n, c, k, y, t, z, g, q, m, o]"));
		tree.insert("----", "GH");
		
	}

}
