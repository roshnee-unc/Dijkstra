package A6_Dijkstra;

import java.util.*;

public class Node {

	private long id;
	private String name;
	
	private int inDegree;
	
	private HashMap <Edge, Node> outedges;
	private HashSet <Long> outedgeids;
	
	private HashMap <Edge, Node> inedges;
	private HashSet <Long> inedgeids;
	
	private boolean visited;
		
	public Node(long id, String name) {
		this.id = id;
		this.name = name;
		
		outedges = new HashMap<>();
		outedgeids = new HashSet<>();
		
		inedges = new HashMap<>();
		inedgeids = new HashSet<>();
		
		inDegree = 0;
		
		visited = false;

		
	}
	
	public Node(String name) {
		this.id = -1;
		this.name = name;
		
		outedges = new HashMap<>();
		outedgeids = new HashSet<>();
		
		inedges = new HashMap<>();
		inedgeids = new HashSet<>();
		

	}
	
	//this will be a pointer from this node to the node n it is connected to
	public void addOutEdge(Node n, long weight, long id, String name) {
		Edge e = new Edge (id, this, n, weight);
		outedges.put(e, n);
		outedgeids.add(e.getId());
	}
	
	public void addInEdge(Node n, long weight, long id, String name) {
		Edge e = new Edge (id, n, this, weight);
		inedges.put(e, n);
		inDegree++;
		inedgeids.add(e.getId());
	}
	
	public boolean addEdge(Edge e) {
		if (e.getFrom().equals(this)) {
			outedges.put(e, e.getTo());
			outedgeids.add(e.getId());

		} else if (e.getTo().equals(this)) {
			inedges.put(e, e.getFrom());
			inedgeids.add(e.getId());
			inDegree++;
		} else
			return false;
		return true;
	}
	
	public boolean remove(Edge e) {
		if (e.getFrom().equals(this)) {
			outedges.remove(e);
			outedgeids.remove(e.getId());
		}
		else if (e.getTo().equals(this)) {
			inedges.remove(e);
			inedgeids.remove(e.getId());
			inDegree--;
		}
		else
			return false;
		return true;
	}
	
	public Edge findEdge(Node dest) {
		
		if (outedges.containsValue(dest)) {
			for (Edge e : outedges.keySet()) {
				Node n = outedges.get(e);
				if (n.equals(dest)) {
					return e;
				}
			}
		}
		
		return null;
	}
	
	public int getIncomingEdgeCount() {
		return inedges.size();
	}

	

	public int getOutgoingEdgeCount() {
		return outedges.size();
	}

	public void decreaseInDegree() {
		inDegree--;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name: " + name + " id: " + id;
	}
	
	public HashMap<Edge, Node> getoutedges() {
		return outedges;
	}
	
	public HashMap<Edge, Node> getinedges() {
		return inedges;
	}
	
	@Override
	public boolean equals(Object o) {
		Node n = (Node) o;
		if (n.getName() == null && name == null && id == n.getId()) {
			return true;
		}
		if (id==n.getId() && name.equals(n.getName())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.name.hashCode());
		hash += id;
		return hash;
	}
	
	public int getInDegree() {
		return inDegree;
	}
	
	public Node[] getoutnodes() {
		Collection<Node> nodes = outedges.values();
		return nodes.toArray(new Node[outedges.size()]);
	}
	
	public void visit() {
		visited = true;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	

}
