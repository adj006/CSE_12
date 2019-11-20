/**
* @author Adrian Jimenez login name: cs12scx PID: A10748304
* @version 5/1/13
*
* Assignment #: 3
**/

/**
* An implementation of the Stack interface that adapts from the Deque12 class
*
* @see Deque12<E>
**/

public class Stack12<E> implements BoundedStack<E>
{
	// the top element of stack is stored at the back pointer
	private Deque12<E> stack;
	/**
	* Create an empty stack
	*
	* @see Deque12<E>
	* @param c
	**/
	public Stack12(int c)
	{
		stack = new Deque12<E>(c);
	}
	/**
	* This is the capacity() method which returns the capacity of the stack
	*
	* @return int
	**/
	public int capacity()
	{
		return stack.capacity();
	}
	/**
	* This is the equals method that compares 2 objects to determine if they
	* are equal
	*
	* @param o
	* @return boolean
	**/
	public boolean equals(java.lang.Object o)
	{
		if(o instanceof Stack12)	// Checks if the object is of type Stack12
		{
			Stack12<E> o2 = (Stack12<E>)(o);
			o2.stack.equals(this.stack);
		}
		return false;
	}
	/**
	* This is the peek() method that returns the element that is next
	* to be removed
	*
	* @return E
	**/
	public E peek()
	{
		return stack.peekBack();
	}
	/**
	* This is the pop() method that removes and returns the element that is next
	* to be removed
	*
	* @return E
	**/
	public E pop()
	{
		return stack.removeBack();
	}
	/**
	* This is the push() method that adds the element to the top of the stack
	*
	* @param e
	* @return boolean
	**/
	public boolean push(E e)
	{
		return stack.addBack(e);
	}
	/**
	* This is the size method that returns the size of the stack
	*
	* @return int
	**/
	public int size()
	{
		return stack.size();
	}
}
