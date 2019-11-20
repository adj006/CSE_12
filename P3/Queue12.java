/**
* @author Adrian Jimenez login name: cs12scx PID: A10748304
* @version 5/1/13
*
* Assignment #: 3
**/

/**
* An implementation of the Queue interface that adapts from the Deque12 class
*
* @see Deque12<E>
**/

public class Queue12<E> implements BoundedQueue<E>
{
	// the first element of queue is stored at the front pointer
	private Deque12<E> queue;
	/**
	* Create an empty queue
	*
	* @see Deque12<E>
	* @param c
	**/
	public Queue12(int c)
	{
		queue = new Deque12<E>(c);
	}
	/**
	* This is the capacity() method which returns the capacity of the queue
	*
	* @return int
	**/
	public int capacity()
	{
		return queue.capacity();
	}
	/**
	* This is the dequeue() method that removes and returns the element that is
	* next to be removed
	*
	* @return E
	**/
	public E dequeue()
	{
		return queue.removeFront();
	}
	/**
	* This is the enqueue() method that adds the element to the back of the queue
	*
	* @param e
	* @return boolean
	**/
	public boolean enqueue(E e)
	{
		return queue.addBack(e);
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
		if(o instanceof Queue12)	// Checks if the object is of type Queue12
		{
			Queue12<E> o2 = (Queue12<E>)(o);
			o2.queue.equals(this.queue);
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
		return queue.peekFront();
	}
	/**
	* This is the size method that returns the size of the queue
	*
	* @return int
	**/
	public int size()
	{
		return queue.size();
	}
}
