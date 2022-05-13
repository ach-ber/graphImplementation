
package graphe;


import java.util.Arrays;

public class IncidenceArrayGraph implements Graph{
    private Vertex[] vertexArray;
    private int maxVertex;
    private static int nbVertex = 0;
    private Edge[] edgesArray;
    private static int nbEdge = 0;
    private Edge[][] incidenceArray;

    /**
     * constructor of an IncidenceArrayGraph
     * @param maxVertex
     */
    public IncidenceArrayGraph(int maxVertex) {
        this.vertexArray = new Vertex[maxVertex];
        this.maxVertex = maxVertex;
        this.edgesArray = new Edge[maxVertex * maxVertex];
        this.incidenceArray = new Edge[maxVertex][maxVertex * maxVertex];

    }


    /**
     * number of vertices of the graph
     * @return : int
     */
    @Override
    public int nbOfVertices() {
        return nbVertex;
    }

    /**
     * number of edges in the graph
     * @return : int
     */
    @Override
    public int nbOfEdges() {
        return nbEdge;
    }

    /**
     * add a vertex to the graph
     * @param vertex : graph.Vertex
     */
    @Override
    public void addVertex(Vertex vertex){
        if(nbVertex<this.maxVertex){
            this.vertexArray[nbVertex] = vertex;
            nbVertex++;
        }
        else{

        }
    }

    /**
     * add an edge to the graph
     * @param vertex1  : graph.Vertex - extremity one of the edge
     * @param vertex2  : graph.Vertex - extremity two of the edge
     * @param edgeKind : String - 'directed' or 'undirected'
     */
    @Override
    public void addEdge(Vertex vertex1, Vertex vertex2, String edgeKind) {
        if(nbEdge<this.maxVertex*this.maxVertex){
            this.edgesArray[nbEdge] = new Edge(Color.BLANC,vertex1,vertex2,1.0);
            this.incidenceArray[vertex1.getId()][nbEdge] = this.edgesArray[nbEdge];
            this.incidenceArray[vertex2.getId()][nbEdge] = this.edgesArray[nbEdge];
            nbEdge++;
        }
        else{
            System.out.println("Maximum number of edges reach");
        }
    }

    /**
     * whether there is a path between the two vertices (without accounting for the edge directions)
     * @param vertex1 : graph.Vertex
     * @param vertex2 : graph.Vertex
     * @return true whether there is a path between the two vertices (without accounting for the edge directions)
     */
    @Override
    public boolean isConnected(Vertex vertex1, Vertex vertex2) {
        for(int i=0;i<=maxVertex*maxVertex;i++){
            if(incidenceArray[vertex1.getId()][i]!=null){
                return incidenceArray[vertex2.getId()][i]!=null;
            }
        }
        return false;
    }

    /**
     * says whether all vertices are interconnected
     * @return true whether all vertices are interconnected
     */
    @Override
    public boolean isConnected() {
        //NOT IMPLEMENTED
        return false;
    }

    /**
     * give edge(s) connecting these vertices
     * @param vertex1 : graph.Vertex
     * @param vertex2 : graph.Vertex
     * @return Edge[]
     */
    @Override
    public Edge[] getEdges(Vertex vertex1, Vertex vertex2) {
        Edge[] res = new Edge[1];
        for(Edge e: this.edgesArray){
            if((e.getEnds()[0]==vertex1 && e.getEnds()[1]==vertex2) || (e.getEnds()[0]==vertex2 && e.getEnds()[1]==vertex1)){
                res[0]=e;
            }
        }
        return res;
    }

    /**
     * give all edges of the graph
     * @return Edge[]
     */
    @Override
    public Edge[] getEdges() {
        return this.edgesArray;
    }

    /**
     * give all vertices of the graph
     * @return graph.Vertex
     */
    @Override
    public Vertex[] getVertices() {
        return this.vertexArray;
    }

    /**
     * give edges connected to this vertex
     * @param vertex1 : graph.Vertex
     * @return Edge[]
     */
    @Override
    public Edge[] getNeighborEdges(Vertex vertex1) {
        int tabSize = 0;
        for(Edge e: this.edgesArray){
            if(e.getEnds()[0]==vertex1 || e.getEnds()[1]==vertex1){
                tabSize++;
            }
        }
        Edge[] resTab = new Edge[tabSize];
        int j=0;
        for(Edge e: this.edgesArray){
            if(e.getEnds()[0]==vertex1 || e.getEnds()[1]==vertex1){
                resTab[j]=e;
                j+=1;
            }
        }
        return resTab;
    }
}
