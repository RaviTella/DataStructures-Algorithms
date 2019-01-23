package dataStructures.generalPurpose.graphs;

public class Stack {
	private int[] a;
	private int tailIndex;

	Stack(int size) {
		this.a = new int[size];
		this.tailIndex = -1;
	}

	void push(int v) {
		if (tailIndex >= a.length) {
			throw new IndexOutOfBoundsException(tailIndex);
		} else {
			a[++tailIndex] = v;
		}
	}

	int pop() {
		if (tailIndex < 0) {
			throw new IndexOutOfBoundsException(tailIndex);
		} else {
			return a[tailIndex--];
		}
	}

	int peek() {
		if (tailIndex < 0) {
			throw new IndexOutOfBoundsException(tailIndex);
		} else {
			return a[tailIndex];
		}
	}

	boolean isEmpty() {
		return (tailIndex == -1) ? true : false;
	}

}
