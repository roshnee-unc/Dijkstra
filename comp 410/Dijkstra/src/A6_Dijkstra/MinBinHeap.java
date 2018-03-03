package A6_Dijkstra;

public class MinBinHeap implements Heap_Interface {
	private EntryPair[] array; // load this array
	private int size;
	private static final int arraySize = 10000; // Everything in the array will
	// initially
	// be null. This is ok! Just
	// build out
	// from array[1]

	public MinBinHeap() {
		this.array = new EntryPair[arraySize];
		array[0] = new EntryPair(null, -100000); // 0th will be unused for
		// simplicity
		// of child/parent
		// computations...
		// the book/animation page
		// both do this.
		size = 0;
	}

	// Please do not remove or modify this method! Used to test your entire
	// Heap.
	@Override
	public EntryPair[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(EntryPair entry) {
		array[size + 1] = entry;
		int index = size + 1;
		while (index > 1) {
			if (array[(index / 2)].getPriority() > entry.getPriority()) {
				EntryPair temp = array[index / 2];
				array[index / 2] = entry;
				array[index] = temp;
				index = index / 2;
			} else {
				break;
			}
		}
		size++;
	}

	@Override
	public void delMin() {

		if (size == 0) {
			return;
		}

		array[1] = array[size];
		array[size] = null;
		size--;
		int index = 1;
		heapify(index);
	}

	@Override
	public EntryPair getMin() {
		return array[1];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void build(EntryPair[] entries) {
		for (int i = 0; i < entries.length; i++) {
			array[i + 1] = entries[i];
		}

		size = entries.length;
		int n = entries.length;
		int index = n / 2;

		while (index >= 1) {
			heapify(index);
			index--;
		}

	}

	private void heapify(int index) {

		int left = index * 2;
		int right = index * 2 + 1;
		int min;
		EntryPair tmp;

		if (left <= size && array[left].getPriority() < array[index].getPriority()) {
			min = left;
		} else {
			min = index;
		}

		if (right <= size && array[right].getPriority() < array[min].getPriority()) {
			min = right;
		}

		if (min != index) {
			tmp = array[index];
			array[index] = array[min];
			array[min] = tmp;
			heapify(min);
		}

	}
	
	public void update(EntryPair entry) {
		
		
	}

}