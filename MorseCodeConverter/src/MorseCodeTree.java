
import java.util.ArrayList;

/**
 * This class represents a generic linked binary tree that inherits from the
 * LinkedConverterTreeInterface which provides methods for inserting, fetching
 * and building the tree. It also allows us to traverse it and convert to an
 * ArrayList.
 * <p>
 * 
 * This class also uses an external generic treeNode class parameterized as a
 * String and Nodes are added based on their morse code value. A ‘.’ (dot) means
 * to traverse left and a ‘-‘ (dash) means to traverse right.
 * 
 * <p>
 * 
 * @author Lima Waziri
 * @see LinkedConverterTreeInterface<String>
 * @Date April 3, 2023
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	private TreeNode<String> root;

	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}

	/**
	 * Returns a reference to the root
	 * 
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	/**
	 * sets the root of the Tree
	 * 
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;

	}

	/**
	 * Adds result to the correct position in the tree based on the code This method
	 * will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String result) {
		addNode(root, code, result);

	}

	/**
	 * This is a recursive method that adds element to the correct position in the
	 * tree based on the code.
	 * 
	 * @param root   the root of the tree for this particular recursive instance of
	 *               addNode
	 * @param code   the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				root.leftChild = new TreeNode<String>(letter);
			} else if (code.equals("-")) {
				root.rightChild = new TreeNode<String>(letter);

			}
		} else {
			if (code.charAt(0) == '.') {
				addNode(root.leftChild, code.substring(1), letter);
			} else if (code.charAt(0) == '-') {
				addNode(root.rightChild, code.substring(1), letter);
			}
		}
	}

	/**
	 * Fetch the data in the tree based on the code This method will call the
	 * recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	/**
	 * This is the recursive method that fetches the data of the TreeNode that
	 * corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of
	 *             addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		if (code.length() == 1) {
			if (code.charAt(0) == '.') {
				return root.leftChild.getData();
			} else {
				return root.rightChild.getData();
			}
		} else {
			if (code.charAt(0) != '.') {
				return fetchNode(root.rightChild, code.substring(1));
			} else {
				return fetchNode(root.leftChild, code.substring(1));
			}
		}
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This operation is not supported for a LinkedConverterTree
	 * 
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T> into
	 * their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		insert(".", "e");
		insert("-", "t");
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");
	}

	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR
	 * (Inorder) Traversal order Used for testing to make sure tree is built
	 * correctly
	 * 
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> newList = new ArrayList<String>();
		LNRoutputTraversal(root, newList);
		return newList;
	}

	/**
	 * The recursive method to put the contents of the linked converter tree in an
	 * ArrayList<T> LNR (Inorder)
	 * 
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR
	 *             order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {
			LNRoutputTraversal(root.leftChild, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rightChild, list);
		} else {
			return;
		}

	}

}
