package alpro;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
         String s = "/example_graph_2";
         GraphUtils.fromFile(s);
//        Graph graph = GraphUtils.fromFile("data/example_graph_1");
//        System.out.println(graph);
//        System.out.println();
//
//        Map<Integer, Integer> distances = graph.distancesFrom(2);
//        System.out.println("graph 1, distances from node 2: " + distances);
//        distances = graph.distancesFrom(8);
//        System.out.println("graph 1, distances from node 8: " + distances);
//
//        System.out.println("graph 1 strongly connected: " + graph.isStronglyConnected());
//
//        Graph graph2 = GraphUtils.fromFile("data/example_graph_2");
//        System.out.println("graph 2 strongly connected: " + graph2.isStronglyConnected());
//
//        Map<Integer, Integer> colorMap = graph.colorWelshPowell();
//        System.out.println("graph 1 color map: " + colorMap);
    }
}
