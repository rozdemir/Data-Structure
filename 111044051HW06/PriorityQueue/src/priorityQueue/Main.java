package priorityQueue;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPriorityQueue<Integer> test= new MyPriorityQueue<Integer>();
		
		for(int i=0;i<50;i++)
		{
			Integer temp= new Integer(i-23);
			test.offer(temp);
			System.out.println(test.size());
			
		   // System.out.println("en sondaki  = " + test.peek());
		}
		
		System.out.println(test.toString());
		for(int i=0;i<50;i++)
		{
			System.out.println("en sondaki cikartiliyor" + test.poll());
		}
		
		System.out.println("size" + test.size());
		
		
		

	}

}
