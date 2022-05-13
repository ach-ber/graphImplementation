package graph;

public class Edge {

    private int id;
    private static int currentId = 0;
    private Color color;
    private Vertex[] ends = new Vertex[2];
    private double value;

    /**
     *
     * @param color : Color
     * @param extremityOne : Vertex
     * @param extremityTwo : Vertex
     * @param value : double
     */
    public Edge(Color color, Vertex extremityOne, Vertex extremityTwo, double value) {
        this.id = currentId++;
        this.color = color;
        this.ends[0] = extremityOne;
        this.ends[1] = extremityTwo;
        this.value = value;
    }


    public Edge(Vertex extremityOne, Vertex extremityTwo) {
        this.id = currentId++;
        this.ends[0] = extremityOne;
        this.ends[1] = extremityTwo;
    }

    //getters and setters


    public int getId() {
        return this.id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Color getColor() {
        return this.color;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public Vertex[] getEnds() {
        return this.ends;
    }

    public void setEnds(Vertex[] ends) {
        this.ends = ends;
    }

    public double getValue() {
        return value;
    }


    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "graph.Edge :\n   - id : " + this.id + "\n   - extremityOne : " + this.ends[0] + "\n   - extremityTwo : " + this.ends[1] + "\n   - color : " + this.color + "\n   - label : " + this.ends;
    }
}