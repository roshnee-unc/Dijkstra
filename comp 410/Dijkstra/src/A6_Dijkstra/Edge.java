package A6_Dijkstra;

public class Edge {

	private long idNum;
	private Node start;
	private Node end;
	private long weight;

	boolean mark;

	public Edge(long idNum, Node start, Node end, long weight) {
		this.idNum = idNum;
		this.start = start;
		this.end = end;
		this.weight = weight;

		mark = false;
	}
	
	public long getId() {
		return idNum;
	}
	

	public Node getTo() {
		return end;
	}

	public Node getFrom() {
		return start;
	}

	public long getCost() {
		return weight;
	}

	public void mark() {
		mark = true;
	}

	public void clearMark() {
		mark = false;
	}

	public boolean isMarked() {
		return mark;
	}

	public String toString() {
		return " id: " + idNum + 
				" from: " + start.toString() + " end: " + end.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		Edge e = (Edge) o;
		if (idNum == e.getId()) {
			return true;
		} if (e.getFrom().equals(this.getFrom()) && e.getTo().equals(this.getTo())) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 3;
		hash = (int) (53*idNum);
		return hash;
	}

}
