
import java.util.Comparator;
import java.util.ListIterator;
/**
 * This class represents a sorted doubly linked list that extends BasicDoubleLinkedList class.
 * It sorts the elements in ascending order using the Comparator interface.<br>
 * <p>
 * This class defines two entities: 
 * <br>
 *    1) The inner class named DoubleLinkedListIterator, which implements the listIterator interface.
 *        And this inner class provides an iterator that can traverse the elements of the sorted doubly
 *        linked list class 
 *    2)The inner class named Node, which represents a node in the doubly linked list which has three
 *      variables: data, prev, and next reference. The data variable holds the actual data, and the prev
 *      and next variable reference the previous and the next nodes in the list
 *  <br>
 *  And both of these entities are defined as protected so that they can only be accessed by the sortedDoubleLinkedList
 *  class and its subclasses.<br>
 *  There is also a  protected Comparator object used to compare elements in the list during sorting. <br>
 *  </p>
 *  @see BasicDoubleLinkedList
 *  @see Comparator  
 * @param <T> The type of elements that the list holds.<br>
 * 
 * @author Lima Waziri
 * @date 03/04/2023
*/
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	protected Comparator comparator = null;

	/**
	 * Constructor for SortedDoubleLinkedList class
	 * 
	 * @param compareableObject The comparator used to compare elements of the list.
	 */
	public <T> SortedDoubleLinkedList(Comparator<T> compareableObject) {
		this.head = null;
		this.tail = null;
		this.comparator = compareableObject;
	}

	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * 
	 * It traverse the list only once in order to perform the insertion.
	 * 
	 * @param data The data of the element to be added.
	 */
	public void add(T data) {
		 Node<T> newNode = new Node<T>(data);
		    if (head == null) {
		        head = newNode;
		        tail = newNode;
		    } else if (comparator.compare(data, head.data) < 0) {
		        newNode.next = head;
		        head.prev = newNode;
		        head = newNode;
		    } else {
		        Node<T> current = head;
		        while (current.next != null && comparator.compare(data, current.next.data) >= 0) {
		            current = current.next;
		        }
		        newNode.prev = current;
		        newNode.next = current.next;
		        if (current.next != null) {
		            current.next.prev = newNode;
		        } else {
		            tail = newNode;
		        }
		        current.next = newNode;
		        
		    }
		    size++;
		    
	}

	/**
	 * Throws an UnsupportedOperationException because it is not supported in a
	 * sorted doubly linked list.
	 * 
	 * @param data The data of the element to be added to the end of the list.
	 * 
	 * @throws UnsupportedOperationException when called because it is not supported
	 * in a sorted doubly linked list.
	 */
	@Override
	public void addToEnd(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}

	/**
	 * Throws an UnsupportedOperationException because it is not supported in a
	 * sorted doubly linked list.
	 * 
	 * @param data The data of the element to be added to the front of the list.
	 * 
	 * @throws UnsupportedOperationException when called because it is not supported
	 * in a sorted doubly linked list.
	 */
	@Override
	public void addToFront(T data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");

	}

	/**
	 * Returns a ListIterator object to iterate through the elements of the sorted
	 * doubly linked list.
	 * 
	 * @return A ListIterator object to iterate through the elements of the sorted
	 * doubly linked list.
	 */
	@Override
	public ListIterator<T> iterator() {
		return super.iterator();

	}

	/**
	 * Removes the first occurrence of the specified element from the sorted doubly
	 * linked list using the given comparator.
	 * 
	 * @param data The data of the element to be removed.
	 * 
	 * @param comparator The comparator used to compare elements of the list.
	 * 
	 * @return The node that contains the removed element, or null if the element is
	 * not found in the list.
	 */
	public BasicDoubleLinkedList.Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);

	}

}
