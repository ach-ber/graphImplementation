package graph;



public class DirectedEdge extends Edge{

    private int id;
    private int source; //0 or 1

    /**
     *
     * @param color : Color
     * @param extremityOne : Vertex
     * @param extremityTwo : Vertex
     * @param value : double
     * @param source : int
     */
    public DirectedEdge(Color color, Vertex extremityOne, Vertex extremityTwo, double value, int source) {
        super(color, extremityOne, extremityTwo, value);
        this.source = source;
    }

    public DirectedEdge(Vertex extremityOne, Vertex extremityTwo,int source){
        super(extremityOne,extremityTwo);
        this.source = source;

    }

    public Vertex getSource(){
        return super.getEnds()[this.source];
    }


    public Vertex getSink(){
        return super.getEnds()[1-this.source];
    }

    public String toString() {
        return  super.toString() + "\n   - start : " + this.getSource() + "\n   - end : " + this.getSink();
    }
}
