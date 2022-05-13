package graph;

public class Vertex {

    private int id;
    private static int currentId = 0;
    private Object info;
    private Color color;

    /**
     *
     * @param info : Object
     * @param color : Color
     */

    public Vertex(Object info, Color color) {
        this.id = currentId++;
        this.info = info;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Object getInfo() {
        return info;
    }


    public void setInfo(Object info) {
        this.info = info;
    }

    public Color getColor() {
        return color;
    }


    public void setColor(Color color) {
        this.color = color;
    }


    public String toString() {
        return "graph.graph.Vertex : \n   - id : " + this.id + "\n   - color : " + this.color;
    }
}
