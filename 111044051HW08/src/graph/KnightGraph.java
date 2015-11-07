package graph;

import java.util.*;
import java.io.*;

/** A ListGraph is an extension of the AbstractGraph abstract class
*   that uses an array of lists to represent the edges.
*   @author Koffman and Wolfgang
*/

public class KnightGraph
    extends AbstractGraph {

  /** An array of Lists to contain the edges that
      originate with each vertex. */
    private List < Edge > [] edges;
    private String[] stat;
    static int edgeNum = 0;
    private int numVer;
    KnightChess ches;
  
  /** Construct a graph with the specified number of
      vertices and directionality.
      @param numV The number of vertices
      @param directed The directionality flag
   */
    
  public KnightGraph(int numV, boolean directed) {
    super(numV, directed);
    edges = new List[numV];
    ches= new KnightChess();
    for (int i = 0; i < numV; i++) {
      edges[i] = new LinkedList < Edge > ();
    }
    
    directed = false;
    stat = new String[numV];
    numVer = numV;
    
    
    
    
  }

  public KnightChess getChes() {
	return ches;
}

public void setChes(KnightChess ches) {
	this.ches = ches;
}

/** Determine whether an edge exists.
      @param source The source vertex
      @param dest The destination vertex
      @return true if there is an edge from source to dest
   */
  public boolean isEdge(int source, int dest, String status ) {
    return edges[source].contains(new Edge(source, dest, status ));
  }

  /** Insert a new edge into the graph.
      @param edge The new edge
   */
  public void insert(Edge edge) {
      
    edges[edge.getSource()].add(edge);
    if (!isDirected()) {
        
      edges[edge.getDest()].add(new Edge(edge.getDest(),
                                         edge.getSource(), edge.state ));
    }
  }

  public Iterator < Edge > edgeIterator(int source) {
    return edges[source].iterator();
  }

  /** Get the edge between two vertices. If an
      edge does not exist, an Edge with a weight
      of Double.POSITIVE_INFINITY is returned.
      @param source The source
      @param dest The destination
      @return the edge between these two vertices
   */
  public Edge getEdge(int source, int dest, String Status ) {
    Edge target =
        new Edge(source, dest, Status );
    for (Edge edge : edges[source]) {
      if (edge.equals(target))
        return edge; // Desired edge found, return it.
    }
    // Assert: All edges for source checked.
    return target; // Desired edge not found.
  }


    public void createGrapStates() {
        
        char temp1;
        char temp2;
       
        ches= new KnightChess();
       
       
            int x=1;
            
    		String copyString = new String("12-1-1-1-1-134");
        	for(int h=1;h<=4;h++)
            {
            	for(int l=1;l<=2;l++)
            	{
            		/*System.out.println("\nxxxxxxxxx\n");
            		ches.printChess();
            		System.out.println("\nxxxxxxxxx\n");*/
            		if(h==1){
            			ches.moveKnight(1,ches.getKnight1(), l);
            			
            		}
            		else if(h==2){
            			ches.moveKnight(3,ches.getKnight2(), l);
            			
            		}
            		else if(h==3)
            		{
            			ches.moveKnight(6,ches.getKnight3(), l);
            		}
            		else
            		{
            			ches.moveKnight(9,ches.getKnight4(), l);
            		}
            		
            		 
                    
                    copyString=ches.returnTable();
                    Edge edge = new Edge( edgeNum+h , edgeNum+l, copyString );
                    insert(edge);
                    stat[edgeNum] = new String(copyString);
            		
            	}
            }
            
                
        
        edgeNum+=8;
        
        
        
        if(edgeNum==16){
        	
        	ches.move();
        	return;
        }
        
        if( !ches.isOver() ) 
            createGrapStates();
        
        
    }
    


    
    @Override
    public boolean isEdge(int source, int dest) {
        return true;
    }

    
    @Override
    public Edge getEdge(int source, int dest) {
        return null;
    }
    
 

}

