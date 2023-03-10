/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		try {
			emptyList.remove(0);
			fail("check out of bouns");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			emptyList.remove(-1);
			fail("check out of bouns");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			longerList.remove(10);
			fail("check out of bouns");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		emptyList.add(1);
		assertEquals("AddEnd: check first element is correct ", (Integer)1, emptyList.get(0));
		
		shortList.add("C");
		LLNode<String> node = shortList.head;
		LLNode<String> prevNode = null;
		for (int i=0; i<3; i++) {
			prevNode = node;
			node = node.next;
		}
		assertEquals("AddEnd: check the end element is correct ", "C", shortList.get(2));
		assertEquals("AddEnd: check the prev node of the added element is correct ", prevNode.next, node);
		assertEquals("AddEnd: check the added element.next is sentinel node ", shortList.tail, node.next);
		assertEquals("AddEnd: check the added element.prev is correct", shortList.get(1), node.prev.data);
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("the size of empty list is 0", 0, emptyList.size());
		assertEquals("the size of longerList list is correct", LONG_LIST_LENGTH, longerList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			emptyList.add(0, null);
			fail("Null pointer");
		}
		catch(NullPointerException e) {
			
		}
		try {
			emptyList.add(1, 100);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			emptyList.add(-1, 100);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			longerList.add(11, 100);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
		
		}
		emptyList.add(0, 100);
		assertEquals("check adding at index 0 ", (Integer)100, emptyList.get(0));
		
		list1.add(1, 100);
		assertEquals("check adding at middle index ", (Integer)65, list1.get(0));
		assertEquals("check adding at middle index ", (Integer)100, list1.get(1));
		assertEquals("check adding at middle index ", (Integer)21, list1.get(2));
		
		longerList.add(10, 100);
		assertEquals("check adding at last index ", (Integer)100, longerList.get(10));
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			emptyList.set(0, 123);
			fail("check out of bouns");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		try {
			longerList.set(10, 123);
			fail("check out of bouns");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		int a = list1.set(0, 1000);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)1000, list1.get(0));
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
