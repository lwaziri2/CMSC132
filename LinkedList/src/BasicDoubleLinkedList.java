import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * This class is a basic implementation of a generic doubly linked list. It allows the
 * user to add and remove elements from both ends of the list and provides
 * methods to retrieve the first and last element in the list. It also
 * implements the Iterable interface, allowing for iteration through the
 * elements in the list. <br>
 * <p>
 * <br>
 * The class defines two protected entities: <br>  
 * <br>
 *   1) an inner class named DoubleLinkedListIterator that implements the 
 *   listIterator, and this inner class only implements the following methods: 
 *   next() , hasNext(), previous(), and hasPreviuous() methods from the 
 *   listIterator class, and all the other implemented by the listIterator will 
 *   throw an UnsupportedOperationException as we didn't need them for this particular class.<br>
 * 
 * <br>
 *   2) an inner class named Node, which has three variables: data, prev, and next reference
 * <br>
 * </p>
 * 
 * @see LinkedList
 * @see ListIterator
 * @see DoubleLinkedListIterator
 * @param <T> The type of elements that the list holds.<br> 
 *  
 * @author Lima Waziri
 * @date 03/04/2023
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {
	protected Node head;
	protected Node tail;
	protected int size;

	public BasicDoubleLinkedList() {
		this.head = null;
		this.tail = null;
		size = 0;
	}

	/**
	 * This method adds an element to the end of the linked list and increases the
	 * size of the list.
	 *
	 * @param data The data that has to be added to the end of the list.
	 */
	public void addToEnd(T data) {
		Node<T> newNode = new Node<T>(data);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		size++;
	}

	/**
	 * This method adds an element to the front of the linked list and increases the
	 * size of the list.
	 *
	 * @param data The data that has to be added to the front of the list.
	 */
	public void addToFront(T data) {
		Node<T> newNode = new Node<T>(data);
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			head.prev = newNode;
			newNode.next = head;
			head = newNode;
		}
		size++;

	}

	/**
	 * This method returns the first element in the list without removing it. And if
	 * the list is empty, it will return null
	 *
	 * @return The first element in the list.
	 */
	public T getFirst() {
		if (size == 0) {
			return null;
		} else {
			return (T) head.data;
		}

	}

	/**
	 * This method returns the last element in the list without removing it. And if
	 * the list is empty, it will return null.
	 *
	 * @return The last element in the list.
	 */
	public T getLast() {
		if (size == 0) {
			return null;
		} else {
			return (T) tail.data;
		}
	}

	/**
	 * This method returns the number of nodes in the list.
	 *
	 * @return The number of nodes in the list.
	 */
	public int getSize() {
		return size;

	}

	/**
	 * This method returns an iterator for the linked list.
	 *
	 * @return The iterator for the linked list.
	 */
	public ListIterator<T> iterator() {
		return new DoubleLinkedListIterator(head);

	}

	/**
	 * Removes the first occurrence of an element that matches the target data using
	 * the given comparator. The method updates the size of the list.
	 *
	 * @param targetData the data to search for and remove
	 * @param comparator the comparator to use for equality comparison
	 * 
	 * @return the removed node, or null if the element was not found
	 */
	public Node remove(T targetData, Comparator<T> comparator) {
		Node<T> current = head;
		while (current != null && comparator.compare(targetData, (T) current.data) != 0) {
			current = current.next;
		}
		if (current == null) {
			return null;
		}
		if (current == head) {
			head = head.next;
		} else {
			current.prev.next = current.next;
		}
		if (current == tail) {
			tail = tail.prev;
		} else {
			current.next.prev = current.prev;
		}
		size--;
		return current;

	}

	/**
	 * Removes and returns the first element of the list.
	 * 
	 * @return the first element of the list, or null if the list is empty.
	 */
	public T retrieveFirstElement() {
		Node<T> newNode = new Node<T>(null);
		if (size != 0) {
			newNode = head;
			head = head.next;
			size--;
			if (size != 0) {
				head.prev = null;
			}
			return newNode.data;
		} else {
			return null;

		}
	}

	/**
	 * Removes and returns the last element of the list.
	 * 
	 * @return the last element of the list, or null if the list is empty.
	 */
	public T retrieveLastElement() {
		Node<T> newNode = new Node<T>(null);
		if (size != 0) {
			newNode = tail;
			tail = tail.prev;
			size--;
			if (size == 0 && tail != null) {
				tail.prev = null;
			}
			return newNode.data;
		} else {
			return null;

		}
	}

	/**
	 * Returns an array list of all the items in the double linked list.
	 * 
	 * @return an ArrayList of all the items in the double linked list.
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> List = new ArrayList<T>();
		Node<T> currentNode = head;
		while (currentNode != null) {
			List.add(currentNode.data);
			currentNode = currentNode.next;
		}
		return List;
	}

	/**
	 * The Node class represents a node in the double linked list.
	 */
	protected class Node<T> {
		protected T data;
		protected Node<T> next;
		protected Node<T> prev;

		/**
		 * Constructs a DoubleLinkedListIterator object with the given data.
		 * 
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	/**
	 * This is a protected class that implements the `ListIterator` interface. This
	 * class provides an iterator that can traverse a doubly linked list.
	 *
	 * @param <T> The type of element in the linked list.
	 */
	protected class DoubleLinkedListIterator<T> implements ListIterator {
		private Node head;
		private Node current;
		private Node previous;
		private int index;

		/**
		 * Constructor for the `DoubleLinkedListIterator` class.
		 *
		 * @param data The node to start iterating from.
		 */
		public DoubleLinkedListIterator(Node data) {
			this.head = data;
			this.current = data;
			this.previous = null;
			index = 0;
		}

		/**
		 * Returns true if there is at least one more element in the linked list to be
		 * iterated over, false otherwise.
		 *
		 * @return True if there is at least one more element in the linked list to be
		 *         iterated over, otherwise return false.
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/**
		 * Returns the next element in the linked list and advances the iterator
		 * position by one.
		 *
		 * @return The next element in the linked list.
		 * @throws NoSuchElementException If there are no more elements to iterate over.
		 */
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T temp = (T) current.data;
			previous = current;
			current = (Node) current.next;
			index++;
			return temp;
		}

		/**
		 * Returns true if there is at least one more element in the linked list to be
		 * iterated over in the reverse direction, otherwise it will return false.
		 *
		 * @return True if there is at least one more element in the linked list to be
		 *         iterated over in the reverse direction, otherwise it will return
		 *         false.
		 */
		@Override
		public boolean hasPrevious() {
			return previous != null;
		}

		/**
		 * Returns the previous element in the linked list and moves the iterator
		 * position backwards by one.
		 *
		 * @return The previous element in the linked list.
		 * @throws NoSuchElementException If there are no more elements to iterate over.
		 */
		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			T temp = (T) previous.data;
			current = previous;
			previous = previous.prev;
			index--;
			return temp;
		}

		/**
		 * Unimplemented method
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException("Not supported");
		}

		/**
		 * Unimplemented method
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException("Not supported");
		}

		/**
		 * Unimplemented method
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void remove() {
			throw new UnsupportedOperationException("Not supported");
		}

		/**
		 * Unimplemented method
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void set(Object e) {
			throw new UnsupportedOperationException("Not supported");
		}

		/**
		 * Unimplemented method
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void add(Object e) {
			throw new UnsupportedOperationException("Not supported");
		}

	}
}
