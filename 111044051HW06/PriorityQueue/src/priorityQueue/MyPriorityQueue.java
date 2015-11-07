
/*kitap dan yardimlar alinmistir */

package priorityQueue;

import java.awt.RenderingHints.Key;
import java.io.Serializable;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;



public class MyPriorityQueue<E> extends AbstractQueue<E> implements Serializable,Queue<E>{

	
	 /*Priority queue insert and delete like binary tree */
	 private Node<E> root=null;
	 private Comparator<E> comparator;
	 private int nodeCount = 0; 
	 

	 private static class Node<E> {
	        protected E data; /*inner class data*/          
	        protected Node<E> next;        /*inner class left */
	       
	        
	        private Node(E data)
	        {
	        	this.data=data;
	        	this.next=null;
	        	
	        }
	        
	        private Node()
	        {
	        	this.data=null;
	        	this.next=null;
	        	
	        }
	      
	        
	 }
	 
	 private class PItr implements Iterator
	    {
	        public Object next()
	        {
	        	Node<E> tempRoot=myRoot;
	        	if(myRoot==null)
	        		throw new NoSuchElementException();
	        	if(myRoot.next!=null)
	        		myRoot=myRoot.next;
	        	
	        	
	        		
	        	mySize++;
	        	
	            return tempRoot.data;
	        }
	        
	        public boolean hasNext()
	        {
	            if(mySize>=size())
	            	return false;
	            else 
	            	return true;
	        } 
	        private int mySize = 0;
	        private Node<E> myRoot=root;
	
	        
	    }
	 public MyPriorityQueue() {
	  
	      			
	        nodeCount = 0;
	        root=null;
	        comparator = null;
	        
	    }
	
	    
	    public MyPriorityQueue(int cap, Comparator< E > comp) {
	    
	        nodeCount = 0;
	        if (cap < 1)
	            throw new IllegalArgumentException();
	        root = null;
	        comparator = (Comparator<E>) comp;
	    }
	    
	    public Comparator<? super E> comparator()
	    {
	    	return this.comparator;
	    }
	    /*inner methods for binary tree structore*/
	    private boolean isInnerEmpty()/*my list structure*/
	    {
	    	return size()==0;
	    }
	    
	    private void setInner(int index,E data) {
	        Node<E> temp=root;
	        if(index<size()){
		        for(int i=0;i<index;i++)
		        	temp=temp.next;
		        temp.data=data;
	        }
	    }
	    private E getInner(Node<E> root,int index)
	    {
	    	if(root.next==null)
	    		return null;
	    	else if(index==0)
	    		return root.next.data;
	    	else
	    		return getInner(root.next,index-1);
	    
	    }
	    private E getInner(int index)
	    {
	    	if(root==null)
	    		return null;
	    	else if(index==0)
	    		return root.data;
	    	else return getInner(root,index-1);
	    	
	    		
	    }
	    
	    private void addInner(E data)
	    {
	    	if(root==null){
	    		root= new Node<E>(data);
	    		return;
	    	}
	    	addInner(root,data);
	    }
	    private void addInner(Node<E> root, E data)
	    {
	    	if(root.next==null){
	    		root.next=new Node<>(data);
	    		//System.out.println("girdi");
	    	}
	    	else
	    		addInner(root.next,data);
	
	    		
	    }
	    private E removeInner(int index)
	    {
	    	if(index==0){
	    		E data=root.data;
	    		root=root.next;
	    		return data;
	    	}
	    	/*	
	    	return removeInner(root.next,root,index);*/
	    	Node<E> previous = null;
			Node<E> current = root;
	    	Node<E> temp=root;
	    	Node<E> root2;
	    	E data;
	    	for(int i=0;i<index;i++)
	    	{
	    		previous=current;
	    		current=current.next;
	    		temp=temp.next;
	    	}
	    	previous.next=current.next;
	    	return current.data;
	    }
	    private E removeInner(Node<E> root,Node<E> rootPrev,int index)
	    {
	    	if(root==null)
	    		return null;
	    
	    	else if(index==0){
	    		E data=root.data;
	    		rootPrev.next=root.next;
	    		return data;
	    		
	    	}
	    	else
	    		return removeInner(root.next,root,index-1);
	    		
	    }
	    
	   
	    
	  
	    public boolean offer(E item) {
	        // Add the item to the heap.
	        addInner(item);
	       
	        // child is newly inserted item.
	        int child = size() - 1;
	        int parent = (child - 1) / 2; // Find childs parent.
	        // Reheap
	        while (parent >= 0 && compare(getInner(parent),
	                                      getInner(child)) > 0) {
	          swap(parent, child);
	          child = parent;
	          parent = (child - 1) / 2;
	        }
	        return true;
	      }
	     
	      
	      public E poll() 
	      {
	        if (isEmpty()) {
	          return null;
	        }
	        // Save the top of the heap.
	        E result = getInner(0);
	        //System.out.println("res" + result);
	        // If only one item then remove it.
	        if (size() == 1) {
	          removeInner(0);
	          return result;
	        }
	        /* Remove the last item from the ArrayList and place it into
	           the first position. */
	        setInner(0, removeInner(size() - 1));
	       // System.out.println("basta " + getInner(0));
	        // The parent starts at the top.
	        int parent = 0;
	        while (true) {
	          int leftChild = 2 * parent + 1;
	          if (leftChild >= size()) {
	            break; // Out of heap.
	          }
	          int rightChild = leftChild + 1;
	          int minChild = leftChild; // Assume leftChild is smaller.
	          // See whether rightChild is smaller.
	          if (rightChild < size()
	              && compare(getInner(leftChild),
	                         getInner(rightChild)) > 0) {
	            minChild = rightChild;
	          }
	          // assert: minChild is the index of the smaller child.
	          // Move smaller child up heap if necessary.
	          if (compare(getInner(parent),
	                      getInner(minChild)) > 0) {
	            swap(parent, minChild);
	            parent = minChild;
	          }
	          else { // Heap property is restored.
	            break;
	          }
	        }
	        return result;
	      }

	    /* take the root's data without removing it */
	    @Override
	    public E peek() {
	        if( root != null )
	            return (E)root.data;
	        else
	            return null;
	    }
	    
	    
	    /* take the root's data without removing it */
	    @Override
	    public E element() {
	        if( root != null )
	            return (E)root.data;
	        else
	            throw new NoSuchElementException();
	    }
	    
	    public void swap(int parent, int child){
			E pitem = getInner(parent);
			E citem = getInner(child);
			setInner(parent, citem);
			setInner(child, pitem);
		}
	    
	    
	    private int compare( E left, E right ){
	        
	        if (comparator != null) { 
	            return comparator.compare((E)left, (E)right);
	        }else { // 
	            return ( (Comparable < E > ) left).compareTo(right);
	        }
	    }


		@Override
		public Iterator<E> iterator() {
			// TODO Auto-generated method stub
			return new PItr();
		}


		@Override
		public int size() {

			return size(root);
		}
		
		private int size(Node<E> root)
		{
			if(root==null)
				return 0;
			else
				return 1+size(root.next);
		}
		
		public boolean contains(Object arg0){
			
			
			return contains(root,arg0);
					
		}
		public boolean contains(Node<E> root, Object arg0)
		{
			
			if(root==null)
				return false;
			if(!arg0.getClass().equals(root.data.getClass()))
				throw new ClassCastException();
			if(root.data.equals(arg0))
				return true;
			
			else
				return contains(root.next,arg0);
						
		}
		
		public void clear()
		{
			this.root=null;
		}
		
		public Object[] toArray()
		{
			MyPriorityQueue<E> temp= new MyPriorityQueue<E>();
			temp=this;
			Object[] array = new Object[temp.size()];
			int i=this.size()-1;		
			while(this.size()>0)
			{
				
				array[i]=temp.poll();
				i--;
			}
			return array;
		}
		
		public <T> T[] toArray(T[] a)
		{
			if(a==null)
				throw new NullPointerException();
			
			
			MyPriorityQueue<E> temp= new MyPriorityQueue<E>();
			temp=this;
			for(int i=0;i<a.length;i++)
			{
				if(!temp.contains(a[i]));
					throw new ArrayStoreException();
			}
			T[] array = (T[]) new Object[temp.size()];
			int i=0;		
			while(i<a.length)
			{
				
				array[i]=a[i];
				i++;
			}
			return array;
			
		}
		public String toString()
	    {
			return toString(root);
	        	
	    }
		private String toString(Node<E> root)
		{
			String temp="";
			if(root==null)
			{
				return " ";
			}
			else{
				
				
				temp+=root.data.toString()+"\n";
				
				temp+=toString(root.next);
			}
			return temp;
		}
		

}
