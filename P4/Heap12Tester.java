/**
* @author Adrian Jimenez login name: cs12scx PID: A10748304
* @version 5/14/13
*
* Assignment #: 4
**/

/**
* This program is to test for good and bad implimentation of a specified
* file. it will pass for good implimentation and fail for bad implimentation
**/

public class Heap12Tester extends junit.framework.TestCase
{
	Heap12<Integer> h;
	/**
	* Main method is the driver of this program
	**/	
	public static void main(String args[])
	{
		// Require this to run the JUnit program as a text
		junit.textui.TestRunner.main(new String[] {"Heap12Tester"});
	}
	/**
	* This is a tester for the no argument constructor checking if it is storing
	* the correct variables
	**/
	public void testNoArgCtor()
	{
		h = new Heap12<Integer>();
		assertTrue(h.size() == 0);
		for(int i = 0; i < 5; i++)
		{
			h.add(i);
			assertTrue(h.peek() == i);
			assertTrue(h.size() == (i + 1));
		}
		for(int i = 0; i < 5; i++)
		{
			assertTrue(h.remove() == (4 - i));
		}
	}
	/**
	* This is the tester for the copy constructor to make sure it is copying the
	* existing heap correctly
	**/
	public void testCtor()
	{
		h = new Heap12<Integer>();
		for(int i = 0; i < 5; i++)
		{
			h.add(i);
			assertTrue(h.peek() == i);
			assertTrue(h.size() == (i + 1));
		}
		Heap12<Integer> h2 = new Heap12<Integer>(h);
		assertTrue(h.equals(h2));
		assertTrue(h.hashCode() == h2.hashCode());
		assertTrue(h2.peek() == 4);
		assertTrue(h2.size() == 5);
	}
	/**
	* This is the tester for the add() method to make sure it is adding the
	* correct element and storing it in the correct location
	**/
	public void testAdd()
	{
		h = new Heap12<Integer>();
		for(int i = 0; i < 10; i++)
		{
			h.add(i);
			assertTrue(h.peek() == i);
			assertTrue(h.size() == (i + 1));
		}
	}
	/**
	* This is the tester for the add method checking if it is throwing the
	* correct exception
	**/
	public void testAddException()
	{
		h = new Heap12<Integer>();
		try
		{
			h.add(null);
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
	* This is the tester for the equals() method to make sure it is comparing the
	* elements of the two heaps in interest correctly
	**/
	public void testEquals()
	{
		Heap12<Integer> h1 = new Heap12<Integer>();
		Heap12<Integer> h2 = new Heap12<Integer>();
		Heap12<Integer> h3 = new Heap12<Integer>();
		for(int i = 1; i <= 5; i++)
			h1.add(i);	
		for(int i = 1; i <= 5; i++)
			h2.add(i);
		for(int i = 5; i > 0; i--)
			h3.add(i);
		assertTrue(h1.equals(h2));
		assertFalse(h1.equals(h3));
		assertTrue(h1.size() == h2.size());
	}
	/**
	* This is the tester for the hashCode() method making sure it is returning
	* the correct hash code of the heap
	**/
	public void testHashCode()
	{
		Heap12<Integer> h1 = new Heap12<Integer>();
		Heap12<Integer> h2 = new Heap12<Integer>();
		Heap12<Integer> h3 = new Heap12<Integer>();
		for(int i = 1; i <= 5; i++)
			h1.add(i);	
		for(int i = 1; i <= 5; i++)
			h2.add(i);
		for(int i = 5; i > 0; i--)
			h3.add(i);
		assertTrue(h1.hashCode() == h2.hashCode());
		assertFalse(h1.hashCode() == h3.hashCode());
	}
	/**
	* This is the tester to test for the isEmpty() method making sure it's
	* returning the correct value
	**/
	public void testIsEmpty()
	{
		h = new Heap12<Integer>();
		assertTrue(h.isEmpty());
		assertTrue(h.size() == 0);
		for(int i = 0; i < 5; i++)
		{
			h.add(i);
			assertFalse(h.isEmpty());
			assertTrue(h.peek() == i);
			assertTrue(h.size() == (i + 1));
		}
	}
	/**
	* This is the tester for the peek() method to test if it is returning
	* the correct value which is the next element to be removed
	**/
	public void testPeek()
	{
		h = new Heap12<Integer>();
		assertTrue(h.peek() == null);
		h.add(12);
		h.add(8);
		h.add(11);
		h.add(30);
		h.add(15);
		assertTrue(h.peek() == 30);
		assertTrue(h.size() == 5);
		assertTrue(h.peek() == 30);
		assertTrue(h.size() == 5);
		h.add(100);
		assertTrue(h.peek() == 100);
		assertTrue(h.size() == 6);
	}
	/**
	* This is the tester for the remove() method to test if it is removing and
	* returning the correct value. Also implicitly tests if the trickleDown()
	* method is working as well
	**/
	public void testRemove()
	{
		h = new Heap12<Integer>();
		assertTrue(h.remove() == null);
		h.add(4);
		h.add(2);
		h.add(5);
		h.add(8);
		h.add(1);
		h.add(8);
		h.add(1);
		assertTrue(h.remove() == 8);
		assertTrue(h.size() == 6);
		assertTrue(h.remove() == 8);
		assertTrue(h.size() == 5);
		assertTrue(h.remove() == 5);
		assertTrue(h.size() == 4);
		assertTrue(h.remove() == 4);
		assertTrue(h.size() == 3);
		assertTrue(h.remove() == 2);
		assertTrue(h.size() == 2);
		assertTrue(h.remove() == 1);
		assertTrue(h.size() == 1);
		assertTrue(h.remove() == 1);
		assertTrue(h.size() == 0);
	}
	/**
	* This is the tester for the size() method to make sure it is
	* storing the correct value
	**/
	public void testSize()
	{
		h = new Heap12<Integer>();
		for(int i = 0; i < 5; i++)
		{
			h.add(i);
			assertTrue(h.size() == (i + 1));
		}
	}
	/**
	* This is the tester for the sort() method making sure it is
	* sorting the passed array in non-decreasing order
	**/
	public void testSort()
	{
		h = new Heap12<Integer>();
		Integer[] a = {3, 1, 5, 2, 4};
		h.sort(a);
		for(int i = 0; i < 5; i++)
			assertTrue(a[i] == (i + 1));
	}
	/**
	* This is the tester for the sort() method checking if the
	* method is catching the correct exception
	**/
	public void testSortException()
	{
		try
		{
			h = new Heap12<Integer>();
			h.sort(null);
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
}
