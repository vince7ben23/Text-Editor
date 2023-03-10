package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author Cheng-Ying Chen
 * @date 2023/03/07
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	private int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
		
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (null == element) {
			throw new NullPointerException();
		}
		LLNode<E> newNode = new LLNode<E>(element);
		
		LLNode<E> prev = tail.prev;
		newNode.next = tail;
		newNode.prev = prev;
		prev.next = newNode;
		tail.prev = newNode;
		size++;		
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> cur = head;
		for (int i=0; i<index+1; i++) {
			cur = cur.next;
			if (null == cur.next) {
				throw new IndexOutOfBoundsException();
			}
		}
		return cur.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (null==element) {
			throw new NullPointerException();
		}
		if (index>size || index<0) {
			throw new IndexOutOfBoundsException();
		}
		// add element at the end of the list
		if (index==size) {
			add(element);
			return;
		}
		
		LLNode<E> node = new LLNode<E>(element);
		// add element at the begin of the list
		if (index==0 && size>0) {
			node.prev = head;
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
			size++;
			return;
			
		}
		LLNode<E> cur = head;
		// add element at the middle of the list
		for (int i=0; i<index; i++) {
			cur = cur.next;
		}
		node.prev = cur;
		node.next = cur.next;
		cur.next.prev = node;
		cur.next = node;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		
		if (size==0 || index>size-1 || index<0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> cur = head;
		for (int i=0; i<=index; i++) {
			cur = cur.next;
		}
		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		size--;
		return cur.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (null==element) {
			throw new NullPointerException();
		}
		if (size==0 || index>size-1 || index<0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> cur = head;
		for (int i=0; i<=index; i++) {
			cur = cur.next;
		}
		E oldVal = cur.data;
		cur.data = element;
		return oldVal;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
