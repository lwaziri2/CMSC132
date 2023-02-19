/*
 * @author Lima Waziri
 * @02/16/2023
 */
import java.util.ArrayList;
import java.util.LinkedList;

public class MyQueue<T> implements QueueInterface<T> {
	private Node<T> queueHead, queueTail;
	private int size = 0;
	private int capacity = 100;

	/**
	 * provide two constructors 1. takes an int as the size of the queue 2. default
	 * constructor - uses a default as the size of the queue
	 * 
	 */
	public MyQueue(int cap) {
		this.queueHead = null;
		this.queueTail = null;
		this.capacity = cap;
	}

	public MyQueue() {
		this.queueHead = null;
		this.queueTail = null;
	}

	/**
	 * Determines if Queue is empty
	 * 
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		return queueHead == null && queueTail == null;

	}

	/**
	 * Determines of the Queue is Full
	 * 
	 * @return true if Queue is full, false if not
	 */
	@Override
	public boolean isFull() {
		return this.size >= capacity;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * 
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T data = queueHead.getData();
			if (queueHead == queueTail) {
				queueHead = null;
				queueTail = null;
			} else {
				queueHead = queueHead.getNext();
			}
			size--;
			return data;
		}
	}

	/**
	 * Returns number of elements in the Queue
	 * 
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {
		return this.size;

	}

	/**
	 * Adds an element to the end of the Queue
	 * 
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful
	 * @throws QueueOverflowException if queue is full
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}

		Node<T> newNode = new Node<>(e);
		if (isEmpty()) {
			queueHead = newNode;
		} else {
			queueTail.setNext(newNode);
		}
		queueTail = newNode;
		size++;
		return true;

	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue
	 * 
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String answer = "";
		Node<T> curr = queueHead;
		while (curr != null) {
			answer += curr.getData().toString();
			curr = curr.getNext();
		}
		return answer;

	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning
	 * of the string is the front of the queue Place the delimiter between all
	 * elements of the Queue
	 * 
	 * @return string representation of the Queue with elements separated with the
	 *         delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String answer = "";
		Node<T> node = queueHead;
		while (node != null) {
			answer += node.getData().toString();
			node = node.getNext();
			if (node != null) {
				answer += delimiter;
			}
		}
		return answer;

	}

	/**
	 * Fills the Queue with the elements of the ArrayList, First element in the
	 * ArrayList is the first element in the Queue YOU MUST MAKE A COPY OF LIST AND
	 * ADD THOSE ELEMENTS TO THE QUEUE, if you use the list reference within your
	 * Queue, you will be allowing direct access to the data of your Queue causing a
	 * possible security breech.
	 * 
	 * @param list elements to be added to the Queue
	 * @throws QueueOverflowException if queue is full
	 * 
	 */
	@Override
	public void fill(ArrayList<T> list) throws QueueOverflowException {
		ArrayList<T> copyList = new ArrayList<T>(list);
		for (T element : copyList) {
			enqueue(element);
		}

	}

}