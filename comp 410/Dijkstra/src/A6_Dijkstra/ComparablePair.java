package A6_Dijkstra;

import java.util.Comparator;

public class ComparablePair implements Comparator<ComparablePair> {
	Node node;
    int weight;
    
    public ComparablePair(Node node, int dist){
        this.node = node;
        this.weight = dist;
    }


    @Override
    public int compare(ComparablePair n1, ComparablePair n2) {
        if (n1.weight < n2.weight) {
        	return -1;
        } else if (n1.weight == n2.weight) {
        	return 0;
    	} else {
        	return 1;
        }
    }
}
