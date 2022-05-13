package graph;

import java.util.Arrays;

public class IncidenceArrayGraph implements Graph{
    private Vertex[] vertexArray;
    private int maxVertex;
    private static int nbVertex = 0;
    private Edge[] edgesArray;
    private static int nbEdge = 0;
    private Edge[][] incidenceArray;

    /**
     *
     * @param maxVertex : int
     */

    public IncidenceArrayGraph(int maxVertex) {
        this.vertexArray = new Vertex[maxVertex];
        this.maxVertex = maxVertex;
        this.edgesArray = new Edge[maxVertex * maxVertex];
        this.incidenceArray = new Edge[maxVertex][maxVertex * maxVertex];

    }


    @Override
    public int nbOfVertices() {
        return nbVertex;
    }

    @Override
    public int nbOfEdges() {
        return nbEdge;
    }

    @Override
    public void addVertex(Vertex vertex1) {
        if(nbVertex<this.maxVertex){
            this.vertexArray[nbVertex] = vertex1;
            nbVertex++;
        }
        else{
            System.out.println("Maximum number of vertices reach");
        }
    }

    @Override
    public void addEdge(Vertex vertex1, Vertex vertex2, EdgeKind edgeKind) {
        if(nbEdge<this.maxVertex*this.maxVertex){
            this.edgesArray[nbEdge] = new Edge(vertex1,vertex2);
            this.incidenceArray[vertex1.getId()][nbEdge] = this.edgesArray[nbEdge];
            this.incidenceArray[vertex2.getId()][nbEdge] = this.edgesArray[nbEdge];
            nbEdge++;
        }
        else{
            System.out.println("Maximum number of edges reach");
        }
    }

    @Override
    public boolean isConnected(Vertex vertex1, Vertex vertex2) {
        for(int i=0;i<=maxVertex*maxVertex;i++){
            if(incidenceArray[vertex1.getId()][i]!=null){
                return incidenceArray[vertex2.getId()][i]!=null;
            }
        }
        return false;
    }

    @Override
    public boolean isConnected() {
        return false;
    }


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


    @Override
    public Edge[] getEdges() {
        return this.edgesArray;
    }


    @Override
    public Vertex[] getVertices() {
        return this.vertexArray;
    }


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

    public String toString() {
        return "- array : " + this.getVertices().toString()  ;
    }
}
