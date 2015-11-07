
package graph;

import java.util.Scanner;


public class Main {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String initState;
        int searchType;
        int stepNum = 0;
        
   
        KnightGraph chess = new KnightGraph(1000, false);
        Scanner input=new Scanner(System.in);
        System.out.println("Please enter the initial node in row-wise (use – for space)");
        initState = input.nextLine();
        int loc1=0;
        int loc2=0;
        while(initState.length()!=9)
        {
        	System.out.println("Hatali giriþ tekrar deneyin");
        	initState = input.nextLine();
        	//return;
        }
        for(int i=0;i<9;i++)
        {
        	if(initState.charAt(i)=='K' && loc1==0){
        		chess.getChes().setKnight1(i);
        		loc1++;
        	}
        	else if(initState.charAt(i)=='K' && loc1==1)
        		chess.getChes().setKnight2(i);
        	else if(initState.charAt(i)=='k' && loc2==0){
        		chess.getChes().setKnight3(i);
        		loc2++;
        	}
        	else if(initState.charAt(i)=='k' && loc2==1)
        		chess.getChes().setKnight4(i);
        }
       
       
        BreadthFirstSearch search1;
        
        
        search1 = new BreadthFirstSearch();
        search1.breadthFirstSearch(chess, 0);
        chess.createGrapStates();
        stepNum = KnightGraph.edgeNum;
        
        
        if( KnightGraph.edgeNum != -1 ){
            
        	chess.getChes().printChess();
            System.out.printf("Your solutions takes %d step\n", stepNum );
            
        }
        else
            System.out.println("The result was not found!!!");
        
        
    }
    
    
    
    
}
