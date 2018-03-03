package A6_Dijkstra;

import java.util.Comparator;

public class LongComparator implements Comparator<LongComparator> {
	
	long l;
	
	public LongComparator() {
		
	}
	
	public LongComparator(long l) {
		this.l = l;
	}

	@Override
	public int compare(LongComparator o1, LongComparator o2) {
		if (o1.l < o2.l) {
        	return -1;
        } else if (o1.l == o2.l) {
        	return 0;
    	} else {
        	return 1;
        }
	}

}
