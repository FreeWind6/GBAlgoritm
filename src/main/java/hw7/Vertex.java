package hw7;

import java.util.Objects;

/**
 * @author Dmitry Kubyshkin
 * @dateOfCreation 15.07.2020
 */
public class Vertex {

    private final String label;
    private boolean visited;
    private Vertex previous;

    Vertex(String label) {
        this.label = label;
    }

    String getLabel() {
        return label;
    }

    void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    Vertex getPrevious() {
        return previous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(label, vertex.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }

    boolean isVisited() {
        return visited;
    }

    void setVisited(boolean visited) {
        this.visited = visited;
    }
}
