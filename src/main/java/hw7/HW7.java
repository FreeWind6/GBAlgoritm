package hw7;

/**
 * @author Dmitry Kubyshkin
 * @dateOfCreation 15.07.2020
 */
public class HW7 {
    public static void main(String[] args) {
        Graph graph = initGraph();
        graph.displayShortestPath("Москва", "Воронеж");
        graph.displayShortestPath("Курск", "Тамбов");
        graph.displayShortestPath("Рязань", "Калуга");
    }

    private static Graph initGraph() {
        Graph graph = new Graph(10);

        graph.addVertex("Воронеж");
        graph.addVertex("Калуга");
        graph.addVertex("Курск");
        graph.addVertex("Липецк");
        graph.addVertex("Москва");
        graph.addVertex("Орел");
        graph.addVertex("Рязань");
        graph.addVertex("Саратов");
        graph.addVertex("Тамбов");
        graph.addVertex("Тула");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdges("Тула", "Москва", "Липецк");
        graph.addEdges("Рязань", "Москва", "Тамбов");
        graph.addEdges("Калуга", "Москва", "Орел");
        graph.addEdges("Липецк", "Тула", "Воронеж");
        graph.addEdges("Тамбов", "Рязань", "Саратов");
        graph.addEdges("Орел", "Калуга", "Курск");
        graph.addEdges("Саратов", "Тамбов", "Воронеж");
        graph.addEdges("Курск", "Орел", "Воронеж");
        graph.addEdges("Воронеж", "Липецк", "Саратов", "Курск");

        return graph;
    }
}
