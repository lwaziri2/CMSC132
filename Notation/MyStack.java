/*
 * @author Lima Waziri
 * @date 2/16/2023
 */
import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	private Node<T> topStack;
	private int stackSize;
	private int max = 100;

	/**
	 * Provide two constructors 1. takes in an int as the size of the stack 2.
	 * default constructor - uses default as the size of the stack
	 */
	public MyStack(int size) {
		this.topStack = null;
		this.max = size;

	}

	public MyStack() {
		topStack = null;
	}

	/**
	 * Determines if Stack is empty
	 * 
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		return topStack == null;
	}

	/**
	 * Determines if Stack is full
	 * 
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		return this.stackSize >= max;

	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * 
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T pop() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			T value = top();
			topStack = topStack.getNext();
			stackSize--;
			return value;
		}
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * 
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	public T top() throws StackUnderflowException {
		if (isEmpty()) {
			throw new StackUnderflowException();
		} else {
			return topStack.getData();
		}

	}

	/**
	 * Number of elements in the Stack
	 * 
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return this.stackSize;
	}

	/**
	 * Adds an element to the top of the Stack
	 * 
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		} else {
			Node<T> node = new Node<T>(e);
			node.setNext(topStack);
			topStack = node;
			stackSize++;
			return true;
		}
	}

	/**
	 * Returns the elements of the Stack in a string from bottom to top, the
	 * beginning of the String is the bottom of the stack
	 * 
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String answer = "";
		Node<T> node = topStack;
		while (node != null) {
			answer = node.getData() + answer;
			node = node.getNext();
		}
		return answer;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning
	 * of the string is the bottom of the stack Place the delimiter between all
	 * elements of the Stack
	 * 
	 * @return string representation of the Stack from bottom to top with elements
	 *         separated with the delimiter
	 */
	public String toString(String delimiter) {
		String answer = "";
		Node<T> node = topStack;

		while (node != null) {
			if (answer.length() == 0)
				answer = (String) node.getData();
			else
				answer = node.getData() + delimiter + answer;
			node = node.getNext();
		}

		return answer;

	}

	/**
	 * Fills the Stack with the elements of the ArrayList, First element in the
	 * ArrayList is the first bottom element of the Stack YOU MUST MAKE A COPY OF
	 * LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the list reference
	 * within your Stack, you will be allowing direct access to the data of your
	 * Stack causing a possible security breech.
	 * 
	 * @param list elements to be added to the Stack from bottom to top
	 * @throws StackOverflowException if stack gets full
	 */
	public void fill(ArrayList<T> list) throws StackOverflowException {
		ArrayList<T> copyList = new ArrayList<T>(list);
		for (T element : copyList) {
			push(element);
		}
	}

}
