package A6_Dijkstra;

import java.util.*;

import gradingTools.comp410.sharedClasses.MyRandom;

public class DiGraphPlayground {

	public static void main(String[] args) {

		// thorough testing is your responsibility
		//
		// you may wish to create methods like
		// -- print
		// -- sort
		// -- random fill
		// -- etc.
		// in order to convince yourself your code is producing
		// the correct behavior
		exTest();
	}

	public static void exTest() {
		/*DiGraph d = new DiGraph();

		// numEdges test 0
		System.out.println("Num Edges Test 0. The number of edges should be 5.");
		System.out.println(d.addNode(1, "f"));
		System.out.println(d.addNode(3, "s"));
		System.out.println(d.addNode(7, "t"));
		System.out.println(d.addNode(0, "fo"));
		System.out.println(d.addNode(4, "fi"));
		System.out.println(d.addNode(6, "si"));
		System.out.println(d.addEdge(0, "f", "s", 0, null));
		System.out.println(d.addEdge(1, "f", "si", 0, null));
		System.out.println(d.addEdge(2, "s", "t", 0, null));
		System.out.println(d.addEdge(3, "fo", "fi", 0, null));
		System.out.println(d.addEdge(4, "fi", "si", 0, null));
		System.out.println("The number of edges is: " + d.numEdges());
		System.out.println("The number of nodes is: " + d.numNodes());

		System.out.println("\nNumNodes Test 1. The number of nodes should be 3");
		DiGraph e = new DiGraph();
		System.out.println(e.addNode(1, "f"));
		System.out.println(e.addNode(3, "s"));
		System.out.println(e.addNode(7, "t"));
		System.out.println(e.addNode(0, "fo"));
		System.out.println(e.delNode("f"));
		System.out.println("The number of nodes is: " + e.numNodes());

		System.out
				.println("\nAddEdges Test 4. All calls should be true. NumEdges should be 2." + "NumNodes should be 4");
		DiGraph f = new DiGraph();
		System.out.println(f.addNode(1, "f"));
		System.out.println(f.addNode(3, "s"));
		System.out.println(f.addNode(7, "t"));
		System.out.println(f.addNode(6, "si"));
		System.out.println(f.addEdge(0, "f", "s", 0, null));
		System.out.println(f.addEdge(1, "f", "si", 0, null));
		System.out.println("The number of nodes is: " + f.numNodes());
		System.out.println("The number of edges is: " + f.numEdges());

		System.out.println("\nDel Edge Test 0. All should return true. NumNodes = 2, NumEdges 0");
		DiGraph g = new DiGraph();
		System.out.println(g.addNode(1, "f"));
		System.out.println(g.addNode(3, "s"));
		System.out.println(g.addEdge(0, "f", "s", 0, null));
		System.out.println(g.delEdge("f", "s"));
		System.out.println("The number of nodes is: " + g.numNodes());
		System.out.println("The number of edges is: " + g.numEdges());*/

		/*System.out.println("\nDel Edge Test 2. False, True, True, True, True, False, True, True");
		DiGraph h = new DiGraph();
		System.out.println(h.delEdge("f", "s"));
		System.out.println(h.addNode(1, "f"));
		System.out.println(h.addNode(3, "s"));
		System.out.println(h.addEdge(0, "f", "s", 0, null));
		System.out.println(h.delEdge("f", "s"));
		/*THIS EDGE DOESNT EXIST!System.out.println(h.delEdge("f", "s"));
		System.out.println(h.addEdge(0, "f", "s", 0, null));
		System.out.println(h.delEdge("f", "s"));*/
		
		/*System.out.println("\nAddEdge Test 1. True.");
		DiGraph a = new DiGraph();
		System.out.println(a.addNode(1, "f"));
		System.out.println(a.addNode(3, "s"));
		System.out.println(a.addNode(7, "t"));
		System.out.println(a.addEdge(0, "f", "s", 0, null));
		System.out.println(a.addEdge(1, "f", "s", 0, null));
		System.out.println(a.delEdge("f", "s"));*/
		
		/*DiGraph d = new DiGraph();
		System.out.println(d.addNode(0, "a"));
		System.out.println(d.addNode(1, "b"));
		System.out.println(d.addNode(2, "c"));
		System.out.println(d.addNode(3, "d"));
		System.out.println(d.addEdge(0, "a", "b", 0, null));
		System.out.println(d.addEdge(1, "b", "c", 0, null));
		System.out.println(d.addEdge(2, "c", "d", 0, null));
		
		d.topoSort();*/
		
		//printTOPO(d.topoSort());
		
		//extraTest();
		
		DiGraph m = new DiGraph();
		m.addNode(0, "0");
		m.addNode(1, "1");
		m.addNode(2, "2");
		m.addNode(3, "3");
		m.addNode(4, "4");
		m.addNode(5, "5");
		m.addNode(6, "6");
		m.addEdge(0, "4", "5", 2, null);
		m.addEdge(1, "0", "5", 3, null);
		m.addEdge(2, "3", "2", 6, null);
		m.addEdge(3, "6", "1", 4, null);
		m.addEdge(4, "4", "0", 1, null);
		ShortestPathInfo [] s = m.shortestPath("0");
		
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i].toString() + " ");
		}
		System.out.println();


	}

	public static void printTOPO(String[] toPrint) {
		System.out.print("TOPO Sort: ");   
		for (String string : toPrint) {
			System.out.print(string + " ");
		}
		System.out.println();
	}

	public static void extraTest() {
		long start, end, goodTime;
		int goodNodesMade = 0, goodEdgesMade = 0, badNodesMade = 0, badEdgesMade = 0;
		DiGraph goodDiGraph = new DiGraph(); // first make good one
		MyRandom R = new MyRandom(true);// make consistently seeded random for
										// reproducable
		start = System.nanoTime();
		ArrayList<String> nodes = new ArrayList<String>();
		for (int i = 0; i < 1000; i++) { // 1 million tries to add Nodes
			String toAdd = R.nextString(1, 7);
			if (goodDiGraph.addNode(R.rand(0, 1000), toAdd)) {
				nodes.add(toAdd);
				goodNodesMade++;
			}
			if (goodNodesMade == 100)
				break;
		}
		for (int i = 0; i < 100; i++) {// try to make 1 million edges
			if (nodes.isEmpty())
				break;
			int src_index = R.rand(0, nodes.size() - 1);
			int dest_index = R.rand(0, nodes.size() - 1);
			if (src_index == dest_index)
				continue;
			String src = nodes.get(src_index);
			String dest = nodes.get(dest_index);
			if (goodDiGraph.addEdge(R.rand(0, 1000), src, dest, R.rand(0, 1000), R.nextString(1, 100))) {
				goodEdgesMade++;
				nodes.remove(dest_index);
			}
		}
		goodDiGraph.topoSort();
		end = System.nanoTime();
		goodTime = end - start;
		System.out.println(goodTime);

	}

}
