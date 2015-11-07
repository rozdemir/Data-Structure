package Main;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import Hiprit.HipritClass;




public class MainTest {

	public MainTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HipritClass<Integer> test= new HipritClass<Integer>();
		System.out.println("Test add \n");
		test.add(new Integer(3));
		test.add(new Integer(3));
		test.add(new Integer(3));
		test.add(new Integer(3));
		test.add(new Integer(3));
		test.add(new Integer(3));
		System.out.println("size " + test.size());
		test.printData();
		
		
		System.out.println("Test addwith location\n");
		test.add(1, 4);
		test.add(1, 6);
		test.add(1, 8);
		test.add(1, 90);
		test.add(1, 4);
		test.add(1, 6);
		test.add(1, 8);
		test.add(1, 90);
		System.out.println("size "+ test.size());
		test.printData();
		
		
		System.out.println();
		System.out.println("Test adAll");
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(new Integer(7));
		temp.add(new Integer(8));
		temp.add(new Integer(5));
		temp.add(new Integer(3));
		temp.add(new Integer(8));
		temp.add(new Integer(0));
		test.addAll(temp);
		test.printData();

		
		System.out.println("Test adAllWithLocation");
		System.out.println("part 2 ");
		if(test.addAll(4, temp))
			System.out.println("basarili eklendi");
		test.printData();
		
		
		System.out.println("Test indexof \n");
		System.out.println("index test "+ test.indexOf(7));
		
		System.out.println("Test get()\n");
		System.out.println("get test " + test.get(4));
		
		System.out.println("Test isEmpty()\n");
		if(!test.isEmpty())
			System.out.println("list is not empty\n");
		
		System.out.println("Test remove\n");
		test.remove(0);
		test.remove(0);
		test.printData();
		
		System.out.println("\nTest set()\n");
		test.set(0,new Integer(100));
		test.printData();
		
		System.out.println("Test toArray()");
		System.out.print(" testing to array"+ test.toArray()[0]+ "\n");
		
	
		
		System.out.println("Test iterator()");
		int size=0;
		Iterator iter = test.iterator();

		while(iter.hasNext())
		{
			size++;
			System.out.println(iter.next());
		}
		
		System.out.println("Test listIterator()\n");
		ListIterator listIter = test.listIterator();
		while(listIter.hasNext())
		{
			size++;
			System.out.println(listIter.next());
		}
		
		System.out.println("Test listIteratorwithLocation()\n");
		ListIterator listIter2 = test.listIterator(2);

		while(listIter2.hasNext())
		{
			size++;
			System.out.println(listIter2.next());
		}
		System.out.println("Test contains()");
		//test.addAll(temp);
		if(test.contains(new Integer(3)))
			System.out.println("   3 is contains\n");
			
		
		System.out.println("Test containsAll()");
		//test.addAll(temp);
		if(test.containsAll(temp))
			System.out.println("    All  is contains\n");
		
		System.out.println("Test retainAll ");
		test.retainAll(temp);
		System.out.println(temp.size());
		test.printData();
		
		System.out.println("Test Sub List ");
		System.out.println(test.subList(1, 3));
		
		System.out.println("Test clear ");
		test.clear();
		System.out.println(test.size());
		
		
		
		

	}

}
