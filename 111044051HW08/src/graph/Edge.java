
package graph;
public class Edge {
    
   private int dest;
   private int source;
   protected String state;
   
 
   public Edge( int dest, int source, String stat ){
       this.dest = dest;
       this.source = source;
       this.state = new String(stat);
   }

    /**
     * @return the dest
     */
    public int getDest() {
        return this.dest;
    }

    /**
     * @param dest the dest to set
     */
    public void setDest(int dest) {
        this.dest = dest;
    }

    /**
     * @return the source
     */
    public int getSource() {
        return this.source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(int source) {
        this.source = source;
    }

   
   
    
    
}

