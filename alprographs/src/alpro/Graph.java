package alpro;

import java.util.ArrayList;
import java.util.List;

public class Graph {


    List<Node> liste;

    public Graph(int anzahlKnoten){
        liste = new ArrayList<>(anzahlKnoten);
    }
    public Node getNode(int index)
    {
        return liste.get(index);
        liste.
    }

    public class Node {

        private List<Integer> neighbours;

        public Node(){

            neighbours = new ArrayList<>();
        }

        void addEdge(int neighbour){
            neighbours.add(neighbour);
        }

        public List<Integer> getNEdges(){
            return neighbours;
        }

    }

}
