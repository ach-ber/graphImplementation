package graph;

public class MyTest {
    public static void main(String[] args) {
        Vertex NewVertex = new Vertex("NewVertex info", Color.WHITE);
        new DirectedEdge(Color.BLUE,NewVertex,NewVertex,8.6,4);
        new Edge(Color.BLUE,NewVertex,NewVertex,3.4);
    }
}