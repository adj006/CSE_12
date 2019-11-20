/**
* @author Adrian Jimenez login name: cs12scx PID: A10748304
* @version 5/1/13
*
* Assignment #: 3
**/

/**
* This program is to test for good and bad implimentation of a specified
* file. it will pass for good implimentation and fail for bad implimentation
**/

import java.util.*;

public class BoundedDequeTester extends junit.framework.TestCase
{
	/**
	* Main method is the driver of this program
	**/	
	public static void main(String args[])
	{
		// Require this to run the JUnit program as a text
		junit.textui.TestRunner.main(new String[] {"BoundedDequeTester"});
	}
	/**
	* This method tests if the Constructor is storing the correct values
	*
	* @see Deque12<E>
	**/
	public void testDeque12Ctor()
	{
		Deque12<Integer> d = new Deque12<Integer>(5);
		assertTrue(d.capacity() == 5);
		assertTrue(d.size() == 0);
	}
	/**
	* This method tests the addBack() method to determine if it is storing
	* and returning the correct values, also if the size is increasing
	*
	* @see Deque12<E>
	**/
	public void testAddBack()
	{
		Deque12<Integer> d = new Deque12<Integer>(5);
		assertTrue(d.size() == 0);
		d.addFront(1);
		d.addFront(1);
		d.addFront(1);
		assertTrue(d.size() == 3);
		d.addFront(1);
		assertTrue(d.addBack(2));
		assertFalse(d.addBack(2));
		assertTrue(d.peekBack() == 2);
		assertTrue(d.size() == 5);
	}
	/**
	* This method test the addBack() method for exceptions
	*
	* @see Deque12<E>
	**/
	public void testAddBackException()
	{
		try
		{
			BoundedDeque<Integer> d = new Deque12<Integer>(5);
			d.addBack(null);
			fail("Null Pointer Exception");
		}
		catch(java.lang.NullPointerException e)
		{
		}
		catch(java.lang.Exception e)
		{
			fail("Unexpected Exception");
		}
	}
	/**
	* This method tests the addFront() method to determine if it is storing
	* and returning the correct values, also if the size is increasing
	*
	* @see Deque12<E>
	**/
	public void testAddFront()
	{
		BoundedDeque<Integer> d = new Deque12<Integer>(5);
		assertTrue(d.size() == 0);
		d.addFront(1);
		d.addFront(1);
		d.addFront(1);
		assertTrue(d.size() == 3);
		d.addFront(1);
		assertTrue(d.addFront(2));
		assertFalse(d.addFront(5));
		assertTrue(d.peekFront() == 2);
		assertTrue(d.size() == 5);
	}
	/**
	* This method test the addFront() method for exceptions
	*
	* @see Deque12<E>
	**/
	public void testAddFrontException()
	{
		try
		{
			BoundedDeque<Integer> d = new Deque12<Integer>(5);
			d.addBack(null);
			fail("Null Pointer Exception");
		}
		catch(java.lang.NullPointerException e)
		{
		}
		catch(java.lang.Exception e)
		{
			fail("Unexpected Exception");
		}
	}
	/**
	* This method tests the capacity() method by ensuring that the method 
	* is returning the correct value
	*
	* @see Deque12<E>
	**/
	public void testCapacity()
	{
		BoundedDeque<Integer> d = new Deque12<Integer>(12);
		assertTrue(d.capacity() == 12);
		int i;
		for(i = 0; i < 12; i++)
			d.addBack(i);
		assertTrue(d.capacity() == i);
	}
	/**
	* This method tests the equals() method by checking if it is returning 
	* the correct value
	*
	* @see Deque12<E>
	**/
	public void testEquals()
	{
		BoundedDeque<Integer> d1 = new Deque12<Integer>(12);
		BoundedDeque<Integer> d2 = new Deque12<Integer>(12);
		BoundedDeque<Integer> d3 = new Deque12<Integer>(13);
		for(int i = 0; i < 12; i++)
			d1.addBack(i);
		for(int i = 0; i < 12; i++)
			d2.addBack(i);
		for(int j = 0; j < 12; j++)
			d3.addFront(j + j);
		assertTrue(d1.equals(d2));
		assertFalse(d1.equals(d3));
	}
	/**
	* This method tests the peekBack() method by checking if it is returning the
	* correct value
	*
	* @see Deque12<E>
	**/
	public void testPeekBack()
	{
		BoundedDeque<Integer> d = new Deque12<Integer>(12);
		assertTrue(d.peekBack() == null);
		int i;
		for(i = 0; i < 12; i++)
			d.addBack(i);
		assertTrue(d.peekBack() == (i - 1));
	}
	/**
	* This method tests the peekFront() method by checking if it is returning the
	* correct value
	*
	* @see Deque12<E>
	**/
	public void testPeekFront()
	{
		BoundedDeque<Integer> d = new Deque12<Integer>(12);
		assertTrue(d.peekBack() == null);
		for(int i = 0; i < 12; i++)
			d.addBack(i);
		assertTrue(d.peekFront() == 0);
	}
	/**
	* This method tests the removeBack() method by checking if it is removing
	* and returning the correct value and checking if the size is decreasing
	*
	* @see Deque12<E>
	**/
	public void testRemoveBack()
	{
		BoundedDeque<Integer> d = new Deque12<Integer>(12);
		assertTrue(d.removeBack() == null);
		assertTrue(d.size() == 0);
		int i;
		for(i = 0; i < 12; i++)
			d.addBack(i);
		assertTrue(d.size() == 12);
		assertTrue(d.removeBack() == (i - 1));
		assertTrue(d.removeBack() == (i - 2));
		assertTrue(d.removeBack() == (i - 3));
		assertTrue(d.removeBack() == (i - 4));
		assertTrue(d.removeBack() == (i - 5));
		assertTrue(d.size() == 7);
	}
	/**
	* This method tests the removeFront() method by checking if it is removing
	* and returning the correct value and checking if the size is decreasing
	*
	* @see Deque12<E>
	**/
	public void testRemoveFront()
	{
		BoundedDeque<Integer> d = new Deque12<Integer>(12);
		assertTrue(d.removeFront() == null);
		assertTrue(d.size() == 0);
		for(int i = 0; i < 12; i++)
			d.addBack(i);
		assertTrue(d.size() == 12);
		for(int i = 0; i < 12; i++)
			assertTrue(d.removeFront() == i);
		assertTrue(d.size() == 0);
	}
	/**
	* This method tests the size() method by checking if it is
	* returning the correct value
	*
	* @see Deque12<E>
	**/
	public void testSize()
	{
		BoundedDeque<Integer> d = new Deque12<Integer>(12);
		assertTrue(d.size() == 0);
		int i;
		for(i = 0; i < 12; i++)
			d.addBack(i);
		assertTrue(d.size() == i);
	}
}
