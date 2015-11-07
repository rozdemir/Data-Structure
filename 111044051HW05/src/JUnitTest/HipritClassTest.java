package JUnitTest;
// Ramazan Ozdemir  

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Hiprit.HipritClass;



// test class for List  
// Testing ArrayList and LinkedList 
// Before All test all member data clear and testing



public class HipritClassTest{

	// degiskenler
	private List[] test;
	private boolean tempBool;
	private Integer tempInt;
	private Integer addElement;
	
	

	// factory le 0 a arraylist 1 e linkedlist
	// bir oncekinden sadece link list olani hiprit olarak degisitirldi testlerde 
	// herhangi bir degisiklik yok
	public HipritClassTest() {
		super();
		
		this.test= new List[2];
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		// TODO Auto-generated constructor stub
		
	}
	

	// the factory method
	public List<Integer> factory(String factor)
	{
		
		if(factor.equals("Array"))
			return new ArrayList<Integer>();
		if (factor.equals("Hiprid"))
			return new LinkedList<Integer>();
		if (factor.equals("Hiprid"))
			return new HipritClass<Integer>();
		else
			return null;

	}

	@After
	public void allTestAfter(){
		test=null;
	}
	
	
	@Test
	// testing add element aftersize
	public void addTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		addElement= new Integer(3);
		
		
		for(int i=0;i<test.length;i++){
			tempBool=this.test[i].add(addElement);
			assertEquals(1,test[i].size());
		}
	}
	@Test
	// testing if element is add
	public void addTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		addElement= new Integer(3);
		
		
		for(int i=0;i<test.length;i++){
			tempBool=this.test[i].add(addElement);
			assertEquals(true,tempBool);
		}
	}
	@Test
	// Testing if element adding at the end of list
	public void addTest3(){
		assertEquals(addElement,tempInt);
	}

	@Test
	// Testing if element adding at the end of list
	public void addTest4(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			try{
				
					tempBool=test[i].add(null);
				//assertEquals(false,tempBool);
				
			}
			catch(NullPointerException e)
			{
				assertTrue(true);
			}
		}
	}

	// test Null pointer exception 
	@Test
	public void addTestNullPointerException() {
	    
		for(int i=0;i<test.length;i++){
			try{
				
					test[i].add(null);
		    }
		    catch(Exception NullPointerException){
		    	assertTrue(true);
		    }
		}
	    
	}
	// class cast exception
	@Test
	public void addTest6() {
	    
		
		for(int i=0;i<test.length;i++){
			try{
				Object x = new Integer(4);
				test[i].add((String)x);
			
		    }
		    catch(ClassCastException e){
		    	assertTrue(true);
		    }
		}
	    
	}
	
	// index out of exception testing
	@Test
	// test public boolean add(Object arg0)
	public void testAddWithLocationIndexOutOfBoundsException() {
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		try{
			for(int i=0;i<test.length;i++)
					test[i].add(-1,tempInt);
		
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue("Excaption Handdiling", true);
		}
		
	}
	
	// Null poniter exceotipn testing
	@Test
	// test public boolean add(Object arg0)
	public void testAddWithLocationNullPointerException() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		try{
		for(int i=0;i<test.length;i++)
			test[i].add(0,null);
		
		}
		catch(NullPointerException e)
		{
			assertTrue("Excaption Handdiling", true);
		}
		
	}
	
	@Test
	// test public boolean add(Object arg0)
	public void testAddWithLocationIndexOutOfBoundsException2() {
		// tekrar yer aliniyor bastan test etmek icin
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		try{
			for(int i=0;i<test.length;i++)
				test[i].add(test[i].size()+1,tempInt);
		
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue("Excaption Handdiling", true);
		}
		
	}
	
	@Test
	// test public boolean add(Object arg0)
	
	public void testAddWithLocation2() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(0, tempInt);
			assertEquals(1, test[i].size());
		}
		
		
	}
	@Test
	// test public boolean add(Object arg0)
	
	public void testAddWithLocation3() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(0, tempInt);
			assertEquals(tempInt, test[i].get(0));
		}
		
		
	}
	
	// test public boolean add(Object arg0)
	@Test
	public void addWithLocationTest4() {
	    
		
		for(int i=0;i<test.length;i++){
			try{
				Object x = new Integer(4);
				test[i].add(0,(String)x);
			
		    }
		    catch(ClassCastException e){
		    	assertTrue(true);
		    }
		}
	    
	}
	


	@Test
	//public boolean addAll(Collection arg0)
	public void addAllTestNullPointerException(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		try{
			for(int i=0;i<test.length;i++)
				test[i].addAll(test2[i]);
		}
		catch(NullPointerException e)
		{
			assertTrue("Excaption Handdiling", true);
		}
		
	}
	@Test
	//public boolean addAll(Collection arg0)
	public void addAllTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		test2[0].add(3);
		test2[1].add(3);
		for(int i=0;i<test.length;i++){
			test[i].addAll(test2[i]);

			assertEquals(1,test[i].size());
		}

		
	}
	@Test
	//public boolean addAll(Collection arg0)
	public void addAllTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
			test[i].addAll(test2[i]);

			assertEquals(tempInt,test[i].get(0));
		}

		
	}
	@Test
	//public boolean addAll(Collection arg0)
	public void addAllTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
			test[i].addAll(test2[i]);
	
			tempBool=test[i].addAll(test2[i]);

			assertEquals(true,tempBool);
		}

		
	}
	
	@Test
	//public boolean addAll(Collection arg0)
	public void addAllTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
		}
		try{
			for(int i=0;i<test.length;i++){
				test[i].addAll(null);
				
			}
		}
		catch(NullPointerException e)
		{
			// exception handilin
			assertTrue("Exception ", true);
			
		}
		
		

		
	}
	

	@Test
	//public boolean addAll(int arg0, Collection arg1) 

	public void testAddAllWithLocationIndexOutOfBoundsException() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
		}
		try{
			for(int i=0;i<test.length;i++)
				test[i].addAll(-1, test2[i]);
		
		}
		catch(IndexOutOfBoundsException e)
		{
			assertTrue("Excaption Handdiling", true);
		}
		
	}
	@Test
	// NUll pointer testing
	//public boolean addAll(int arg0, Collection arg1) 
	public void testAddAllWithLocationNullPointerException() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		
	
		
		for(int i=0;i<test.length;i++){
			try{
				
				test[i].addAll(0, null);
			
			}
			catch(NullPointerException e)
			{
				assertTrue("Excaption Handdiling", true);
			}
		}
		
	}
	
	@Test
	// index out of exception test
	//public boolean addAll(int arg0, Collection arg1) 
	public void testAddAllWithLocationIndexOutOfBoundsException2() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
		}
		for(int i=0;i<test.length;i++){
			try{
				test[i].addAll(test[i].size()+1, test2[i]);
			
			}
	
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Excaption Handdiling", true);
			}
		}
		
	}
	
	@Test
	
	//public boolean addAll(int arg0, Collection arg1) 
	
	public void testAddAllWithLocation2() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
		}
		
		
		
		for(int i=0;i<test.length;i++){
			test[i].addAll(0, test2[i]);
			assertEquals(1, test[i].size());
		}
		
		
	}
	@Test
	//public boolean addAll(int arg0, Collection arg1) 
	public void testAddAllWithLocation3() {
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
		}
		for(int i=0;i<test.length;i++){
			test[i].add(0, tempInt);
			assertEquals(tempInt, test[i].get(0));
		}
		
		
	}

	@Test
	//public void clear() 
	public void clearTest1()
	{
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
		}
		for(int i=0;i<test.length;i++){
			test[i].clear();
			assertEquals(0, test[i].size());
		}
		
	}
	
	@Test
	//public void clear() 
	public void clearTest2()
	{
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].clear();
		}
		
		for(int i=0;i<test.length;i++){
			try{
				test[i].get(0);
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Conditon Handiling", true);
			}
		}
		
	}
	@Test
	//public void clear() 
	public void clearTest3()
	{
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(3));
			
			test[i].add(new Integer(4));
			test[i].add(new Integer(5));
		}
		
		for(int i=0;i<test.length;i++){
			test[i].clear();
			assertEquals(0,test[i].size());
		}
		
		
	}
	@Test
	//public void clear() 
	public void clearTest4()
	{
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(3));
			
			test[i].add(new Integer(4));
			test[i].add(new Integer(5));
			test[i].remove(0);
			test[i].clear();
			assertEquals(0,test[i].size());
		}
		
		
		
		
	}
	@Test
	//public void clear() 
	public void clearTest5()
	{
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test[i].clear();
			assertEquals(0,test[i].size());
		}
		
		
	}
	@Test
	//public boolean contains(Object arg0) 
	public void containsTest1(){

		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i< test.length;i++){
				test[i].add(tempInt);
				assertEquals(true, test[i].contains(tempInt));
		}
	}
	
	@Test
	//public boolean contains(Object arg0) 
	public void containsTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i< test.length;i++){
				test[i].add(tempInt);
				assertEquals(false, test[i].contains(7));
		}
		
	}
	
	@Test
	//public boolean contains(Object arg0) 
	public void containsTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i< test.length;i++){
			test[i].add(tempInt);
			assertEquals(false, test[i].contains("string"));
		}
		
	}
	@Test
	//public boolean contains(Object arg0)
	//NUll pointer testing
	public void containsTest4(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i< test.length;i++){
				test[i].add(tempInt);
				
		
		
			try{
				
				test[i].contains(null);
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
	}
	@Test
	//public boolean contains(Object arg0)
	// class cast exception Testing
	public void containsTest5(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i< test.length;i++){
			Object x= new Integer(12);
			test[i].add((Integer) x);
		
			
				
		
		
			
			try{
				test[i].contains((String)x);
			}
			catch(ClassCastException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
	}
	
	@Test
	//public boolean containsAll(Collection arg0)
	public void containsAllTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
			test[i].add(test2[i]);
		
			assertEquals(false, test[i].containsAll(test2[i]));
		}
		
	}
	
	@Test
	//public boolean containsAll(Collection arg0)
	public void containsAllTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test2[i].add(tempInt);
			assertEquals(false, test[i].containsAll(test2[i]));
		}
		
	}
	
	@Test
	//public boolean containsAll(Collection arg0)
	public void containsAllTest3(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=new ArrayList<String>();
		test2[1]=new LinkedList<String>();
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test2[i].add("     ");
			assertEquals(false, test[i].containsAll(test2[i]));
		}
		
		
		
		
		
		
	}
	@Test
	//public boolean containsAll(Collection arg0)
	// NUll pointer excepiton testing
	public void containsAllTest4(){

		for(int i=0;i<test.length;i++){
			try{
				
				test[i].containsAll(null);
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
	}
	@Test
	// class cast exception
	//public boolean containsAll(Collection arg0)
	public void containsAllTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			
			try{
				test[i].containsAll((LinkedList<Integer>)test2[i]);
			}
			catch(ClassCastException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
	}

	@Test
	//public Object get(int arg0)
	public void getTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(tempInt,test[i].get(0));
		}
		
	}
	
	@Test
	//public Object get(int arg0)
	// index out of exception test
	public void getTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(tempInt,test[i].get(0));
			try{
				test[i].get(-1);
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Exception test", true);
			}
		}
		
	}
	
	@Test
	//public Object get(int arg0)
	public void getTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(tempInt);
			test[i].add(tempInt);
			
			assertEquals(tempInt,test[i].get(0));
		}
		
	}
	
	
	@Test
	//public Object get(int arg0)
	
	public void getTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);	
			try{
				test[i].get(test[i].size());
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Exception test", true);
			}
		}
		
	}
	
	@Test
	//public Object get(int arg0)
	public void getTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			try{
				test[i].get(test[i].size());
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Exception test", true);
			}
		}
		
	}

	@Test
	//public int indexOf(Object arg0) 
	public void indexOfTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			
			assertEquals(0,test[i].indexOf(tempInt));
		}
	}
		

	@Test
	//public int indexOf(Object arg0) 
	public void indexOfTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			Object x = new Integer(12);
			test[i].add((Integer) x);
			try{
				test[i].indexOf((String)x);
			}
			catch(ClassCastException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}
	
	@Test
	//public int indexOf(Object arg0) 
	public void indexOfTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			try{
				test[i].indexOf(null);
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}
	
	@Test
	//public int indexOf(Object arg0) 
	public void indexOfTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
		// bulunmayacak
			assertEquals(-1,test[i].indexOf(tempInt));
		}
	}
	
	
	@Test
	//public int indexOf(Object arg0) 
	public void indexOfTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
		// bulunmayacak
			test[i].add(tempInt);
			test[i].add(tempInt);
		// ilk bastan arama yapiyor
			assertEquals(0,test[i].indexOf(tempInt));
		}
	}
	
	
	
	@Test
	//public boolean isEmpty() 
	public void isEmptyTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			assertEquals(true, test[i].isEmpty());
		}
	}
	
	@Test
	//public boolean isEmpty() 
	public void isEmptyTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(false, test[i].isEmpty());
		}
	}
	
	@Test
	//public boolean isEmpty() 
	public void isEmptyTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(tempInt);
			assertEquals(false, test[i].isEmpty());
		}
	}
	
	@Test
	//public boolean isEmpty() 
	public void isEmptyTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(5));
			test[i].add(new Integer(6));
			assertEquals(false, test[i].isEmpty());
		}
	}
	
	
	
	@Test
	//public boolean isEmpty() 
	public void isEmptyTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(5));
			test[i].add(new Integer(6));
			test[i].remove(0);
			assertEquals(false, test[i].isEmpty());
		}
	}
	
	

	@Test
	//public Iterator iterator() 
	public void iteratorTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++)
			assertEquals(false,test[i].iterator().hasNext());
		
	}
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(true,test[i].iterator().hasNext());
		}
		
	}
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);

			assertEquals(tempInt,test[i].iterator().next());
		}
		
	}
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){

		
			try{
				test[i].iterator().next();
			}
			catch(NoSuchElementException e)
			{
				assertTrue("exception handling",true);
			}
		}
	}
	
	@Test
	//public Iterator iterator() 
	public void iteratorTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(4));
			test[i].add(tempInt);
		
			assertNotEquals(tempInt,test[i].iterator().next());
		}
		
	}
	
	
	
	

	@Test
	//public int lastIndexOf(Object arg0) 
	public void lastIndexOfTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(0,test[i].lastIndexOf(tempInt));
		}
	}

	@Test
	//public int lastIndexOf(Object arg0) 
	// class cast exception
	public void lastIndexOfTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			Object x = new Integer(12);
			test[i].add((Integer) x);
			try{
				test[i].lastIndexOf((String)x);
			}
			catch(ClassCastException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}
	
	@Test
	//public int lastIndexOf(Object arg0) 
	// Null pointer excepiton test
	public void lastIndexOfTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].lastIndexOf(null);
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}
	
	@Test
	//public int lastIndexOf(Object arg0) 
	public void lastIndexOfTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
		// bulunmayacak
			assertEquals(-1,test[i].lastIndexOf(tempInt));
		}
	}
	
	
	@Test
	//public int lastIndexOf(Object arg0) 
	public void lastIndexOfTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(4));
			test[i].add(new Integer(5));
			test[i].add(new Integer(4));
			// sondan bastan arama yapiyor
			assertEquals(3,test[i].lastIndexOf(new Integer(4)));
		}
	}

	@Test
	//public ListIterator listIterator() 
	// bos listede hasnext olmaz
	public void listIteratorTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			assertEquals(false,test[i].listIterator().hasNext());
		}
		
	}
	
	@Test
	//public ListIterator listIterator() 
	// bitane ekleyip hasnext i var mi diye
	public void listIteratorTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(true,test[i].listIterator().hasNext());
		}
		
	}
	
	@Test
	//public ListIterator listIterator() 
	// bitane ekleyip ekledigimiz elemani next veriyor mu diye
	public void listIteratorTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);

			assertEquals(tempInt,test[i].listIterator().next());
		}
		
	}
	
	@Test
	//public ListIterator listIterator() 
	// No such element exception test
	public void listIteratorTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			try{
				test[i].listIterator().next();
			}
			catch(NoSuchElementException e)
			{
				assertTrue("exception handling",true);
			}
		}
	}
	
	@Test
	//public ListIterator listIterator()  
	// farkli eleman ekleyip next i esit olmayacigi test ediliyor
	public void listIteratorTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(4));
			test[i].add(tempInt);
			assertNotEquals(tempInt,test[i].listIterator().next());
		}
		
	}
	
	
	@Test
	//public ListIterator listIterator()  
	// farkli eleman ekleyip index test ediliyor
	public void listIteratorTest6(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(4));
			test[i].add(tempInt);
			assertEquals(0,test[i].listIterator().nextIndex());
		}
		
	}
	
	
	@Test
	//public ListIterator listIterator()  
	public void listIteratorTest7(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(4));
			test[i].add(tempInt);
			// listenin basindayiz zaten
			assertEquals(-1,test[i].listIterator().previousIndex());
		}
		
	}
	
	
	@Test
	//public ListIterator listIterator()  
	public void listIteratorTest8(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(4));
			test[i].add(tempInt);
			// listenin basindayiz zaten
			assertEquals(false,test[i].listIterator().hasPrevious());
		}
		
	}


	@Test
	//public ListIterator listIterator(int arg0)
	// bos listin has next i 
	public void listIteratorwithLocation1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			assertEquals(false,test[i].listIterator(0).hasNext());
		}
		
	}
	
	@Test
	//public ListIterator listIterator(int arg0)
	// bir eleman ekleyip has next
	public void listIteratorwithLocation2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(true,test[i].listIterator(0).hasNext());
		}
		
	}
	
	@Test
	//public ListIterator listIterator(int arg0)
	
	public void listIteratorwithLocation3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(tempInt,test[i].listIterator(0).next());
		}
		
	}
	
	@Test
	//public ListIterator listIterator(int arg0)
	// no such element testing
	public void listIteratorwithLocation4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
		
			try{
				test[i].listIterator(0).next();
			}
			catch(NoSuchElementException e)
			{
				assertTrue("exception handling",true);
			}
		}
	}
	
	@Test
	//public ListIterator listIterator(int arg0)  
	public void listIteratorwithLocation5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(4));
			test[i].add(tempInt);
		
			assertNotEquals(tempInt,test[i].listIterator().next());
		}
		
	}
	
	
	
	@Test
	//public ListIterator listIterator()  
	// farkli eleman ekleyip next i esit olmayacigi test ediliyor
	public void listIteratorWithIteratorTest6(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(4));
			test[i].add(tempInt);
			assertEquals(0,test[i].listIterator(0).nextIndex());
		}
		
	}


	@Test
	//public ListIterator listIterator(int arg0)  
	// farkli eleman ekleyip next i esit olmayacigi test ediliyor
	public void listIteratorWithLocationTest7(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(4));
			test[i].add(tempInt);
			// listenin basindayiz zaten
			assertEquals(-1,test[i].listIterator(0).previousIndex());
		}
		
	}
	
	
	@Test
	//public ListIterator listIterator(int arg0)  
	
	public void listIteratorWithLocationTest8(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(4));
			test[i].add(tempInt);
			// listenin basindayiz zaten
			assertEquals(false,test[i].listIterator(0).hasPrevious());
		}
		
	}
	
	@Test
	//public ListIterator listIterator(int arg0)  
	
	public void listIteratorWithLocationTest9(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			try{
				test[i].add(new Integer(4));
				test[i].add(tempInt);
				// listenin basindayiz zaten
				test[i].listIterator(0).previous();
			}
			catch(NoSuchElementException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
		
	}
	
	@Test
	//public E remove(int index)
	public void removeTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].remove(0);
			assertEquals(0,test[i].size());
		}
	}
		
	@Test
	//public E remove(int index)
	public void removeTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(tempInt,test[i].remove(0));
		}
	}
	@Test
	//public E remove(int index)
	// Index out of exception test
	public void removeTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
				
			try{
				test[i].remove(-1);
			}
			catch(IndexOutOfBoundsException e){
				assertTrue("Exception Handlin",true);
			}
		}
	}
	@Test
	//public E remove(int index)
	
	public void removeTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
				
			try{
				test[i].remove(test[i].size());
			}
			catch(IndexOutOfBoundsException e){
				assertTrue("Exception Handlin",true);
			}
		}
	}
		
	@Test
	//public E remove(int index)
	
	public void removeTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(3));
			test[i].add(new Integer(4));
			test[i].add(new Integer(5));
			test[i].remove(0);
			test[i].remove(0);
			assertEquals(new Integer(5), test[i].remove(0));
		}
	}
		
	@Test
	//public boolean remove(Object arg0)
	public void removeTestWithObject1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].remove(tempInt);
			assertEquals(0,test[i].size());
		}
	}
		
	@Test
	//public boolean remove(Object arg0)
	public void removeTestWithObject2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(true,test[i].remove(tempInt));
		}
	}
	@Test
	//public boolean remove(Object arg0)
	// Test Null pointer exception
	public void removeTestWithObject3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].remove(null);
			}
			catch(NullPointerException e){
				assertTrue("Exception Handlin",true);
			}
		}
	}
	@Test
	//public boolean remove(Object arg0)
	// Class cast excepiton testing
	public void removeTestWithObject4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
				
			Object x = new Integer(4);
			test[i].add((Integer) x);
			x = new String();
			try{
				test[i].remove(x);
			}
			catch(ClassCastException e){
				assertTrue("Exception Handling",true);
			}
		}
	}
		
	@Test
	//public boolean remove(Object arg0)
	public void removeTestWithObject5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			
			test[i].add(new Integer(3));
			test[i].add(new Integer(4));
			test[i].add(new Integer(3));
			// remove first bulundugu yer ve kaydirir
			test[i].remove(new Integer(3));
			
			assertEquals(new Integer(3), test[i].get(1));
		}
	}


	@Test
	//public boolean removeAll(Collection arg0) 
	// Class cast exception testing
	public void removeAllTest1(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			try{
				test[i].removeAll((LinkedList)test2[i]);
				
			}
			catch(ClassCastException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}
	
	@Test
	//public boolean removeAll(Collection arg0) 
	// Null pointer excepiton testing
	public void removeAllTest2(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){;
			try{
				test[i].removeAll(null);
				
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}

	@Test
	//public boolean removeAll(Collection arg0) 
	public void removeAllTest3(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test2[i].add(tempInt);
			assertEquals(true,test[i].removeAll(test2[i]));
		}
		

	}
	
	@Test
	//public boolean removeAll(Collection arg0) 
	public void removeAllTest4(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test2[i].add(tempInt);
			test[i].removeAll(test2[i]);
			assertEquals(0,test[i].size());
		}
		

	}
	@Test
	//public boolean removeAll(Collection arg0) 
	public void removeAllTest5(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(4));
			test2[i].add(new Integer(5));
			
			assertEquals(false,test[i].removeAll(test2[i]));
		}
		

	}
	
	
	@Test
	////public boolean retainAll(Collection arg0)  
	public void retainAllTest1(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Hiprid");
		test2[1]=this.factory("Array");
		
		for(int i=0;i<test.length;i++){
			try{
				test[i].retainAll(test2[i]);
				
			}
			catch(ClassCastException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}
	
	@Test
	//public boolean retainAll(Collection arg0) 
	public void retainAllTest2(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			try{
				test[i].retainAll(null);
				
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
	}

	@Test
	//public boolean retainAll(Collection arg0) 
	public void retainAllTest3(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(4));
			test2[i].add(new Integer(4));
			assertEquals(true,test[i].retainAll(test2[i]));
		}
		

	}
	
	@Test
	//public boolean retainAll(Collection arg0) 
	public void retainAllTest4(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test2[i].add(new Integer(1));
			test[i].retainAll(test2[i]);
			assertEquals(0,test[i].size());
		}
		

	}
	@Test
	//public boolean retainAll(Collection arg0)
	public void retainAllTest5(){
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(4));
			test2[i].add(new Integer(4));
			
			assertEquals(false,test[i].retainAll(test2[i]));
		}
		

	}
	
	@Test
	//public Object set(int arg0, Object arg1)
	public void setTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].set(0,null);
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
	}
	@Test
	//public Object set(int arg0, Object arg1)
	public void setTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].set(1,tempInt);
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
	}
	
	@Test
	//public Object set(int arg0, Object arg1)
	public void setTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			Object x= new String();
			try{
				test[i].set(1,(Integer) x);
			}
			catch(ClassCastException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
	}
	
	@Test
	//public Object set(int arg0, Object arg1)
	public void setTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		final List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			
			try{
				test2[i].add(tempInt);
				test2[i].set(0,tempInt);
			}
			catch(UnsupportedOperationException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
		
	}
	
	@Test
	//public Object set(int arg0, Object arg1)
	public void setTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(tempInt,test[i].set(0,tempInt));
		}
		
		
	}

	@Test
	//public int size() 
	public void sizeTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(3));
			assertEquals(1,test[i].size());
		}
		
	}
	
	@Test
	//public int size() 
	public void sizeTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(3));
			test[i].add(new Integer(3));
			test[i].add(new Integer(3));
			assertEquals(3,test[i].size());
		}
		
	}
	
	@Test
	//public int size() 
	public void sizeTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
		
			
			assertEquals(0,test[i].size());
		}
		
	}
	
	@Test
	//public int size() 
	public void sizeTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(3));
			test[i].remove(0);
			assertEquals(0,test[i].size());
		}
		
	}
	
	@Test
	//public int size() 
	public void sizeTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(3));
			test[i].add(new Integer(3));
			test[i].add(new Integer(3));
			test[i].add(new Integer(3));
			test[i].add(new Integer(3));
			assertEquals(5,test[i].size());
		}
		
	}

	@Test
	//public List subList(int arg0, int arg1) 
	public void subListTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].subList(-1,1);
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
	}
	
	@Test
	//public List subList(int arg0, int arg1) 
	public void subListTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].subList(0,test[i].size()+1);
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
	}
	
	
	@Test
	//public List subList(int arg0, int arg1) 
	public void subListTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(tempInt);
			test[i].add(tempInt);
			test[i].add(tempInt);
			assertEquals(4, test[i].subList(0, test[i].size()).size());
		}
		
	}
	
	@Test
	//public List subList(int arg0, int arg1) 
	public void subListTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(3));
			test[i].add(new Integer(4));
			test[i].add(new Integer(5));
			assertEquals(tempInt, test[i].subList(0, test[i].size()).get(0));
		}
			
	}
	
	@Test
	//public List subList(int arg0, int arg1) 
	public void subListTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(3));
			test[i].add(new Integer(4));
			test[i].add(new Integer(5));
			assertEquals(new Integer(4), test[i].subList(2, test[i].size()).get(0));
		}
		
	}
	@Test
	//public Object[] toArray() 
	public void toArrayTest1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			assertEquals(tempInt, test[i].toArray()[0]);
		}
		
	}
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(3));
			assertEquals(new Integer(3), test[i].toArray()[1]);
		}
		
	}
	
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			try{
				test[i].toArray();
			}
			catch(IndexOutOfBoundsException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
		
	}
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			
			test[i].add(new Integer(5));
			test[i].add(new Integer(6));
			assertEquals(new Integer(6), test[i].toArray()[2]);
		}
		
	}
	
	
	@Test
	//public Object[] toArray() 
	public void toArrayTest5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			
			test[i].add(new Integer(5));
			test[i].add(new Integer(6));
			assertNotEquals(null, test[i].toArray());
		}
		
	}

	@Test
	//public Object[] toArray(Object[] arg0) 
	public void toArray2Test1(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].toArray(null);
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
	}
	
	@Test
	//public Object[] toArray(Object[] arg0) 
	public void toArray2Test2(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			try{
				test[i].toArray(new Array[10]);
			}
			catch(ArrayStoreException e)
			{
				assertTrue("Exception Handling",true);
			}
		}
		
	}
	@Test
	//public Object[] toArray(Object[] arg0) 
	public void toArray2Test3(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			Integer[] x= new Integer[12];
			x[0]=tempInt;
			assertEquals(tempInt,test[i].toArray(x)[0]);
		}
	}
	
	@Test
	//public Object[] toArray(Object[] arg0) 
	public void toArray2Test4(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			Integer[] x= new Integer[12];
			x[0]=tempInt;
			x[1]=new Integer(78);
			assertEquals(new Integer(78),test[i].toArray(x)[1]);
		}
	}
	
	
	@Test
	//public Object[] toArray(Object[] arg0) 
	public void toArray2Test5(){
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			Integer[] x= new Integer[12];
			x[0]=tempInt;
			x[1]=new Integer(78);
			assertNotEquals(null,test[i].toArray(x));
		}
	}
	@Test
	// public boolean  equals(Object o)
	public void equalTest1()
	{
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
		
			
			test2[i].add(tempInt);
			
			assertEquals(true,test[i].equals(test2[i]));
		}
	}
	
	@Test
	// public boolean  equals(Object o)
	public void equalTest2()
	{
		
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(3));
			
			
			test2[i].add(tempInt);
			test2[i].add(new Integer(3));
			
			assertEquals(true,test2[i].equals(test[i]));
		}
	}
	
	
	@Test
	// public boolean  equals(Object o)
	public void equalTest3()
	{
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
			test[i].add(new Integer(3));
			
			
			test2[i].add(tempInt);
			test[i].add(new Integer(4));
			
			assertEquals(false,test2[i].equals(test[i]));
		}
	}
	
	
	@Test
	// public boolean  equals(Object o)
	public void equalTest4()
	{
		// eklemeleri farkli sirada yaptim
		this.test[0]=this.factory("Array");
		this.test[1]=this.factory("Hiprid");
		List[] test2=new List[2];
		test2[0]=this.factory("Array");
		test2[1]=this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(new Integer(3));
			test[i].add(tempInt);
			
			
			
			test2[i].add(tempInt);
			test[i].add(new Integer(4));
			
			assertEquals(false,test2[i].equals(test[i]));
		}
	}
	
	@Test
	// public boolean  equals(Object o)
	public void equalTest5()
	{
		// eklemeleri farkli sirada yaptim
		
		test[0]= null;
		test[1]= null;
		
		
		List[] test2= new List[2];
		test2[0]= null;
		test2[1]= null;
		for(int i=0;i<test.length;i++){
			try{
				test[i].equals(test2[i]);
			}
			catch(NullPointerException e)
			{
				assertTrue("Exception Handling", true);
			}
		}
		
	}
	@Test
	//int hashCode()
	public void hashCodeTest1()
	{
		for(int i=0 ; i<test.length;i++)
			assertNotEquals(null,test[i].hashCode());
	}
	
	@Test
	//int hashCode()
	public void hashCodeTest2()
	{
		for(int i=0;i<test.length;i++)
			assertNotEquals(1234+i,test[i].hashCode());
	}
	
	@Test
	//int hashCode()
	public void hashCodeTest3()
	{
		List[] test2= new List[2];
		test2[0]= this.factory("Array");
		test2[1]= this.factory("Hiprid");
		for(int i=0;i<test2.length;i++)	{
			test2[i].add(tempInt);
			assertNotNull(test2[i].hashCode());
			
		}
	}
	
	@Test
	//int hashCode()
	public void hashCodeTest4()
	{
		List[] test2= new List[2];
		test2[0]= this.factory("Array");
		test2[1]= this.factory("Hiprid");
		for(int i=0;i<test.length;i++){
			test[i].add(tempInt);
		    test2[i].add(tempInt);
			assertEquals(0,test2[i].hashCode()-test[i].hashCode());
		}
	}
	
	@Test
	//int hashCode()
	public void hashCodeTest5()
	{
		List[] test2= new List[2];
		test2[0]= this.factory("Array");
		test2[1]= this.factory("Hiprid");
		for(int i=0;i<test.length;i++)
			assertEquals(0,test[i].hashCode()-test2[i].hashCode());
	}
}
