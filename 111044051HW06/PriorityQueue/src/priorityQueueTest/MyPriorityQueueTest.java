package priorityQueueTest;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;















import static org.junit.Assert.*;

import org.junit.Test;

import priorityQueue.MyPriorityQueue;

/**
 * 
 */

/**
 * @author Ramazan
 *
 */
public class MyPriorityQueueTest{

	/**
	 * 
	 */
	private PriorityQueue<Integer> myQueue;
	
	public MyPriorityQueueTest() {
		// TODO Auto-generated constructor stub
		this.myQueue = new PriorityQueue<Integer>() ;
	}
	
	public PriorityQueue<Integer> factory()
	{
		return new PriorityQueue<Integer>() ;
		
	}

	
	//public boolean offer(Object item) 
	// testing null pointer Exception
	@Test
	public void offerTest1(){
		
		Integer e= new Integer(3);
		try{
			this.myQueue= this.factory();
			this.myQueue.offer(null);
			
		}
		catch(NullPointerException ex)
		{
			assertTrue("Exception Handling", true);
		}
	}
	
	//public boolean offer(Object item) 
	// testing Class cast exception
	@Test
	public void offerTest2(){
		
		Object e= new String();
		try{
			this.myQueue= this.factory();
			this.myQueue.offer( (Integer) e);
			
		}
		catch(ClassCastException ex)
		{
			assertTrue("Exception Handling", true);
		}
	}
	
	
	
	//public boolean offer(Object item) 
	// testing offer is element true
	@Test
	public void offerTest3(){
		
		Integer e= new Integer(3);
		
		this.myQueue= this.factory();
		assertEquals(true,this.myQueue.offer(e));
			
		
	}
	
	//public boolean offer(Object item) 
	// testing offer is element true
	@Test
	public void offerTest4(){
		
		Integer e= new Integer(3);
		
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		
		assertEquals(true,this.myQueue.offer(e));
			
		
	}

	@Test
	//public booelan remove(Object o) 
	public void testRemoveTest1(){
		
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		assertEquals(e,this.myQueue.remove());
		
		
	}
	
	
	@Test
	//public booelan remove(Object o) 
	public void testRemoveTest2(){
		
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		try{
			this.myQueue.remove();
		}
		catch(NoSuchElementException ex)
		
		{
			assertTrue(true);
		}
		
		
	}
	
	
	@Test
	//public booelan remove(Object o) 
	public void testRemoveTest3(){
		
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		this.myQueue.offer(new Integer(5));
		assertEquals(e,this.myQueue.remove());
		
		
	}
	
	@Test
	//public booelan remove(Object o) 
	public void testRemoveTest4(){
		
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		this.myQueue.offer(new Integer(5));
		
		assertEquals(e,this.myQueue.remove());
		
		
	}

	@Test
	//public Object poll() 
	public void pollTest1(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		this.myQueue.offer(new Integer(5));
		
		assertEquals(e,this.myQueue.poll());
	}

	@Test
	//public Object poll() 
	public void pollTest2(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		this.myQueue.offer(new Integer(5));
		
		assertNotEquals(new Integer(5),this.myQueue.poll());
	}
	
	@Test
	//public Object poll() 
	public void pollTest3(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		this.myQueue.offer(e);
		this.myQueue.offer(new Integer(5));
		this.myQueue.offer(new Integer(5));
		this.myQueue.offer(new Integer(5));
		assertEquals(e,this.myQueue.poll());
	}
	
	
	
	@Test
	//public Object poll() 
	public void pollTest4(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.offer(e);
		this.myQueue.offer(e);
		this.myQueue.offer(new Integer(5));
		this.myQueue.offer(new Integer(58));
		this.myQueue.offer(new Integer(7));
		assertNotEquals(new Integer(58),this.myQueue.poll());
	}
	
	@Test
	//public Object peek() 
	// null pointer testing
	public void peekTest1(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		try{
			this.myQueue.peek();
		}
		catch(NullPointerException ex)
		{
			assertTrue("Exception Handiling", true);
		}
		
	}
	@Test
	//public Object peek() 
	public void peekTest2(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.add(e);
		
		assertEquals(e, this.myQueue.peek());
	}
	
	@Test
	//public Object peek() 
	public void peekTest3(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.add(e);
		this.myQueue.peek();
		this.myQueue.peek();
		assertEquals(1,this.myQueue.size());
	}

	@Test
	//public Object peek() 
	public void peekTest4(){
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.add(e);
		this.myQueue.add(e);
		this.myQueue.add(e);
		this.myQueue.peek();
		this.myQueue.peek();
		assertEquals(3,this.myQueue.size());
	}
	@Test
	//public boolean add(E e)
	// nullpointer testing
	public void addTest1()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		try{
			this.myQueue.add(null);
		}
		catch(NullPointerException ex)
		{
			assertTrue("Exception Handling", true);
		}
	}
	
	
	@Test
	//public boolean add(E e)
	// class cast excepiton test
	public void addTest2()
	{
		Object e= new String();
		try{
			this.myQueue= this.factory();
			this.myQueue.add( (Integer) e);
			
		}
		catch(ClassCastException ex)
		{
			assertTrue("Exception Handling", true);
		}
		
	}
	
	
	@Test
	//public boolean add(E e)
	public void addTest3()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		
		assertEquals(true,this.myQueue.add(e));
		
		
	}
	
	
	@Test
	//public boolean add(E e)
	public void addTest4()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.add(e);
		
		assertEquals(true,this.myQueue.add(e));
		
		
	}
	
	@Test
	//public void clear()
	public void clearTest1()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.clear();
		assertEquals(0, this.myQueue.size());
	}
	
	@Test
	//public void clear()
	public void clearTest2()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.add(e);
		
		this.myQueue.clear();
		assertEquals(0, this.myQueue.size());
	}
	
	@Test
	//public void clear()
	public void clearTest3()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.add(e);
		this.myQueue.add(e);
		this.myQueue.add(e);
		this.myQueue.clear();
		assertEquals(0, this.myQueue.size());
	}
	
	@Test
	//public void clear()
	public void clearTest4()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		this.myQueue.add(e);
		this.myQueue.add(new Integer(4));
		this.myQueue.clear();
		assertEquals(0, this.myQueue.size());
	}
	
	@Test
	//public Comparator<? super E> comparator()
	public void comparatorTest1()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		
		myQueue.add(6);  
		myQueue.add(9);
		myQueue.add(5);
		myQueue.add(64);
		myQueue.add(6);
		assertEquals(null, myQueue.comparator());
		
	}
	
	@Test
	//public Comparator<? super E> comparator()
	public void comparatorTest2()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		myQueue.add(9);
		myQueue.add(6);  
	

		assertEquals(null, myQueue.comparator());
		
	}
	
	@Test
	//public Comparator<? super E> comparator()
	public void comparatorTest3()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		
		myQueue.add(6);  
		myQueue.add(9);
		myQueue.add(5);
		myQueue.add(64);
		myQueue.add(6);
		assertEquals(null, myQueue.comparator());
		
	}
	
	@Test
	//public Comparator<? super E> comparator()
	public void comparatorTest4()
	{
		Integer e= new Integer(3);
		this.myQueue= this.factory();
		
		myQueue.add(6);  
		myQueue.add(9);
		myQueue.add(5);
		myQueue.add(64);
		myQueue.add(6);
		assertEquals(null, myQueue.comparator());
		
	}
	
	@Test
	//public boolean contains(Object arg0) 
	public void containsTest1(){

		this.myQueue= this.factory();
		
		Integer e= new Integer(3);
		
		this.myQueue.add(e);
		assertEquals(true, this.myQueue.contains(e));
		
	}
	
	@Test
	//public boolean contains(Object arg0) 
	public void containsTest2(){
		
		this.myQueue= this.factory();
		
		Integer e= new Integer(3);
		
		this.myQueue.add(e);
		assertEquals(false, this.myQueue.contains(new Integer(87)));
	}
	
	@Test
	//public boolean contains(Object arg0) 
	public void containsTest3(){
		this.myQueue= this.factory();
		
		Integer e= new Integer(3);
		
		this.myQueue.add(e);
		try{
			this.myQueue.contains("");
		}
		catch(ClassCastException ex){
			assertTrue(true);
		}
		
	}
	@Test
	//public boolean contains(Object arg0)
	//NUll pointer testing
	public void containsTest4(){

		this.myQueue= this.factory();
		
		Integer e= new Integer(3);
		
		this.myQueue.add(e);
		try{
			
			this.myQueue.contains(null);
		}
		catch(NullPointerException ex)
		{
			assertTrue("Exception Handling",true);
		}
	}
	
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest1(){
		this.myQueue= this.factory();
		
		Integer e= new Integer(3);
		
	
		assertEquals(false,this.myQueue.iterator().hasNext());
		
	}
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest2(){
		this.myQueue= this.factory();
		Integer e= new Integer(3);
		this.myQueue.add(e);
		
		assertEquals(true,this.myQueue.iterator().hasNext());
		
		
	}
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest3(){
		this.myQueue= this.factory();
		Integer e= new Integer(3);
		this.myQueue.add(e);
		
		assertEquals(e,this.myQueue.iterator().next());
		
	}
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest4(){
		this.myQueue= this.factory();
		Integer e= new Integer(3);
		
		

		
		try{
			this.myQueue.iterator().next();
		}
		catch(NoSuchElementException ex)
		{
			assertTrue("exception handling",true);
		}
		
	}
	
	
	@Test
	//public int size() 
	public void sizeTest1(){
		this.myQueue= this.factory();
		Integer e= new Integer(3);
		
		
		this.myQueue.add(new Integer(3));
		assertEquals(1,this.myQueue.size());
	
		
	}
	
	@Test
	//public int size() 
	public void sizeTest2(){
		this.myQueue= this.factory();
		Integer e= new Integer(3);
		
		
		this.myQueue.add(new Integer(3));
		this.myQueue.add(new Integer(3));
		this.myQueue.add(new Integer(3));
		assertEquals(3,this.myQueue.size());
		
	}
	
	@Test
	//public int size() 
	public void sizeTest3(){
		this.myQueue= this.factory();
		assertEquals(0,this.myQueue.size());
		
	}
	
	@Test
	//public int size() 
	public void sizeTest4(){
		this.myQueue= this.factory();
		this.myQueue.add(new Integer(6));
		this.myQueue.remove();
		assertEquals(0,this.myQueue.size());
		
	}
	
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest1(){
		this.myQueue= this.factory();
		this.myQueue.add(new Integer(6));
		assertEquals(6, this.myQueue.toArray()[0]);
		
		
	}
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest2(){
		this.myQueue= this.factory();
		this.myQueue.add(new Integer(6));
		this.myQueue.add(new Integer(5));
		assertEquals(6, this.myQueue.toArray()[1]);
		
	}
	
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest3(){
		this.myQueue= this.factory();
		
	
		try{
			this.myQueue.toArray();
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue("Exception Handling", true);
		}
	
	}
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest4(){
		this.myQueue= this.factory();
		this.myQueue.add(new Integer(6));
		this.myQueue.add(new Integer(4));
		this.myQueue.add(new Integer(3));
		assertEquals(4, this.myQueue.toArray()[2]);
		
	}
	
	
	@Test
	//public <T> T[] toArray(T[] a)
	public void toArrayContainTest1(){
		this.myQueue= this.factory();
		this.myQueue.add(new Integer(6));
		try{
			this.myQueue.toArray(null);
		}
		catch(NullPointerException e)
		{
			assertTrue("Exception Handling",true);
		}
		
		
	}
	
	@Test
	//public <T> T[] toArray(T[] a)
	public void toArrayContainTest2(){
		this.myQueue= this.factory();
		this.myQueue.add(new Integer(6));
		this.myQueue.add(new Integer(5));
		try{
			this.myQueue.toArray(new Array[10]);
		}
		catch(ArrayStoreException e)
		{
			assertTrue("Exception Handling",true);
		}
	}
	
	
	@Test
	//public <T> T[] toArray(T[] a)
	public void toArrayContainTest3(){
		this.myQueue= this.factory();
		
	
		try{
			this.myQueue.toArray();
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue("Exception Handling", true);
		}
	
	}
	
	@Test
	//public <T> T[] toArray(T[] a)
	public void toArrayContainTest4(){
		this.myQueue= this.factory();
		
	
		this.myQueue.add(new Integer(4));
		Integer[] x= new Integer[12];
		x[0]=new Integer(4);
		assertEquals(new Integer(4),this.myQueue.toArray(x)[0]);

		
	}
	

}
