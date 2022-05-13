package graph;

import java.util.Arrays;

public class TestGraphImpl {
    public static void main(String[] args) throws IllegalArgumentException{
        try {
            Vertex Vertex1 = new Vertex("Vertex1 info", Color.WHITE);
            Vertex Vertex2 = new Vertex("Vertex2 info", Color.RED);
            Vertex Vertex3 = new Vertex("Vertex3 info", Color.BLUE);
        }

        catch ( IllegalArgumentException ) {
            System.out.println("Arguments incorrects !");
        }

        IncidenceArrayGraph Graph = new IncidenceArrayGraph(3);

        Graph.addVertex(Vertex1);
        Graph.addVertex(Vertex2);
        Graph.addVertex(Vertex3);

        Graph.addEdge(Vertex1,Vertex2,EdgeKind.UNDIRECTED);
        Graph.addEdge(Vertex2,Vertex3,EdgeKind.UNDIRECTED);

        System.out.println(Arrays.toString(Graph.getVertices()));
        System.out.println(Graph.isConnected(Vertex1,Vertex2));
        System.out.println(Graph.isConnected(Vertex1,Vertex3));

    }
}