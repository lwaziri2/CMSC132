/**
 * This TreeNode class represents a node in a binary tree and it 
 * stores a generic type of data and has left and right child nodes.
 * 
 * @author Lima Waziri
 * @Date April 3, 2023
 *
 * @param <T> the type of data that needs to be stored in the TreeNode
 */
public class TreeNode <T>{
	private T data;
	TreeNode<T> leftChild;
	TreeNode <T> rightChild;

	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		data = dataNode;
		leftChild = null;
		rightChild = null;
	}
	/**
	 * used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		leftChild = node.leftChild;
		rightChild = node.rightChild;
		
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return - the data within the TreeNode
	 */
	public T getData() {
		return data;
		
	}

}
