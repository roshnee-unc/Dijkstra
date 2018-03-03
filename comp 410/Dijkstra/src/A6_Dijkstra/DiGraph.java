package A6_Dijkstra;

import java.util.*;

public class DiGraph implements DiGraph_Interface {

	private HashSet<Node> nodes;
	private HashMap<String, Node> nodeMap;
	private HashSet<Long> nodeids;

	private HashSet<Edge> edges;
	private HashSet<Long> edgeids;

	public DiGraph() {
		nodes = new HashSet<>();
		nodeMap = new HashMap<>();
		nodeids = new HashSet<>();

		edges = new HashSet<>();
		edgeids = new HashSet<>();
	}

	@Override
	public boolean addNode(long idNum, String label) {
		if (idNum < 0 || label == null)
			return false;

		Node n = new Node(idNum, label);
		
		Node t = nodeMap.get(label);
		
		if (nodeids.contains(idNum) || t != null) {
			return false;
		}

		/*for (Node node : nodes) {
			if (node.getId() == idNum || node.getName().equals(label))
				return false;
		}*/
		
		

		if (nodeMap.containsKey(label)) {
			return false;
		}

		nodes.add(n);
		nodeMap.put(label, n);
		nodeids.add(idNum);
		
		return true;

	}

	@Override
	public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
		if (idNum < 0) {
			return false;
		}

		if (sLabel.equals(dLabel)) {
			return false;
		}
		
		Node from = null;
		if (!nodeMap.containsKey(sLabel))
			return false;
		from = nodeMap.get(sLabel);
		
		
		Node to = null;
		if (!nodeMap.containsKey(dLabel))
			return false;
		to = nodeMap.get(dLabel);
		


		Edge e = new Edge(idNum, from, to, weight);
		
		for (Edge t : edges) {
			if (t.equals(e)) {
				return false;
			}
		}
		if (edgeids.contains(idNum))
			return false;
		

		/*for (Edge t : edges) {
			if (t.equals(e)) {
				return false;
			}
		}*/
		
		

		/*Iterator<Edge> itr = edges.iterator();
		while (itr.hasNext()) {
			Edge edge = itr.next();
			if (edge.getId() == idNum)
				return false;
		}*/

		edges.add(e);
		from.addEdge(e);
		to.addEdge(e);
		edgeids.add(idNum);
		

		return true;
	}

	@Override
	public boolean delNode(String label) {

		long idNum = -1;
		Node n = null;

		if (!nodeMap.containsKey(label)) {
			return false;
		} else {
			n = nodeMap.get(label);
		}

		nodes.remove(n);
		nodeMap.remove(label);
		nodeids.remove(n.getId());

		Edge [] s = n.getoutedges().keySet().toArray(new Edge[n.getOutgoingEdgeCount()]);
		for (int i = 0; i < s.length; i++) {
			Edge edge = s[i];
			n.remove(edge);
			Node to = edge.getTo();
			to.remove(edge);
			edgeids.remove(edge.getId());
			edges.remove(edge);
		}
		Edge [] is = n.getinedges().keySet().toArray(new Edge[n.getIncomingEdgeCount()]);
		for (int i = 0; i < is.length; i++) {
			Edge edge = is[i];
			n.remove(edge);
			Node pred = edge.getFrom();
			pred.remove(edge);
		}

		return true;
	}
	
	@Override
	public boolean delEdge(String sLabel, String dLabel) {

		
		Node from = null;
		from = nodeMap.get(sLabel);
		
		
		Node to = null;
		to = nodeMap.get(dLabel);
		
		if (from == null || to==null)
			return false;
		

		Edge e = from.findEdge(to);
		if (e == null) {
			return false;
		} else {
			from.remove(e);
			to.remove(e);
			edges.remove(e);
			edgeids.remove(e.getId());
			return true;
		}
		
	}

	@Override
	public long numNodes() {
		return nodes.size();
	}

	@Override
	public long numEdges() {
		return edges.size();
	}

	@Override
	public String[] topoSort() {
		String [] toposort = new String[nodes.size()];
		int index = 0;
		int nodesAdded = 0;

		Queue <Node> q = new LinkedList<>();

		for (Node n : nodes) {
			if (n.getInDegree() == 0) {
				q.add(n);
				nodesAdded++;
			}
		}

		while (!q.isEmpty()) {
			Node m = q.poll();
			HashMap <Edge, Node> outedges = m.getoutedges();
			Node[] outedgevalues = outedges.values().toArray(new Node [outedges.size()]);
			toposort[index] = m.getName();
			index++;
			
			for (int i = 0; i < outedgevalues.length; i++) {
				Node c = outedgevalues[i];
				delNode(m.getName());
				if (c.getInDegree() == 0) {
					q.add(c);
					nodesAdded++;
				}
			}

		}
		
		if (nodesAdded < toposort.length) {
			return null;
		} else {
			return toposort;
		}
	}
	
	public boolean topoHelper() {
		
		return true;
	}

	@Override
	public ShortestPathInfo[] shortestPath(String label) {
		ShortestPathInfo[] paths = new ShortestPathInfo[nodes.size()];
		int index = 0;
		for (Node n : nodes) {
			long d = dijkstra(nodeMap.get(label), n);
			paths[index] = new ShortestPathInfo(n.getName(), d);
			index++;
		}
		return paths;
	}
	
	public long dijkstra(Node source, Node end) {
		HashMap  <String, Long> dist = new HashMap<>();
		
		//EntryPair[] entriepairs = new EntryPair[nodes.size()];	
		List <EntryPair> alep = new ArrayList<EntryPair>();
		
		int index = 0;
		
		long big = 10000000;
		
		
		for (Node n : nodes) {
			dist.put(n.getName(), big);
			alep.add(new EntryPair(n.getName(), big));
			//entriepairs[index] = new EntryPair(n.getName(), Long.MAX_VALUE);
			//index++;
		}
		
		dist.put(source.getName(), (long) 0);
		
		int k = alep.indexOf(new EntryPair(source.getName(), big));
		alep.set(k, new EntryPair(source.getName(), big));
		
		Node [] outgoingnodes = source.getoutnodes();
		
		
		for (int i = 0; i < outgoingnodes.length; i++) {
			long weight = source.findEdge(outgoingnodes[i]).getCost();
			dist.put(outgoingnodes[i].getName(), weight);
			int j = alep.indexOf(new EntryPair(outgoingnodes[i].getName(), big));
			EntryPair e = new EntryPair(outgoingnodes[i].getName(), weight);
			alep.set(j, e);
			//entriepairs[j] = e; 
		}
		
		
		EntryPair [] entriepairs = new EntryPair[nodes.size()];
		alep.toArray(entriepairs);
		MinBinHeap q = new MinBinHeap();
		//q.insert(new EntryPair (source.getName(), 0));
		
		q.build(entriepairs);
		
		while (q.size() > 0) {
			EntryPair e = q.getMin();
			if (e.getVisited() == false) {
			Node u = nodeMap.get(e.getValue());
			q.delMin();
			
			Node [] adjacencyList = u.getoutnodes();
			
			for (int i = 0; i < adjacencyList.length; i++) {
				Node v = nodeMap.get(adjacencyList[i].getName());
				//q.insert(new EntryPair (v.getName(), u.findEdge(v).getCost()));
				long alt = dist.get(u.getName()) + u.findEdge(v).getCost();
				if (alt < dist.get(v.getName())) {
					q.insert(new EntryPair (v.getName(), u.findEdge(v).getCost()));
					dist.put(v.getName(), alt);
				}
			}
			}
			
		}
		if (dist.get(end.getName()) == big) {
			return -1;
		}
		return dist.get(end.getName());

	}
	
	
}

	

	