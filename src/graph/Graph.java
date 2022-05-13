package graph;

public interface Graph {

    int nbOfVertices();

    int nbOfEdges();

    void addVertex(Vertex vertex1);

    void addEdge(Vertex vertex1,Vertex vertex2,EdgeKind edgeKind);

    boolean isConnected(Vertex vertex1,Vertex vertex2);

    boolean isConnected();

    Edge[] getEdges(Vertex vertex1, Vertex vertex2);

    Edge[] getEdges();

    Vertex[] getVertices();

    Edge[] getNeighborEdges(Vertex vertex1); //

    String toString();
}