package A6_Dijkstra;

public class EntryPair implements EntryPair_Interface {
	public String value;
	public long priority;

	private boolean visited;
	
	public EntryPair(String aValue, long aPriority) {
		value = aValue;
		priority = aPriority;
		visited = false;
	}

	public String getValue() {
		return value;
	}

	public long getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "EntryPair [value=" + value + ", priority=" + priority + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		EntryPair e = (EntryPair) o;
		if (e.getValue().equals(getValue())&& getPriority()==e.getPriority()) {
			return true;
		}
		return false;
	}
	
	public void visit() {
		visited = true;
	}
	
	public boolean getVisited() {
		return visited;
	}
}
