package dataStructures.generalPurpose.graphs;

public class Queue {
	private int[] q;
	private int front;
	private int end;

	Queue(int size) {
		this.q = new int[size];
		this.front = 0;
		this.end = -1;
	}

	void enQueue(int v) {
		q[++end] = v;
	}

	int deQueue() {
		int v = q[front++];
		return v;
	}

	int peekFront() {
		return q[front];
	}

	boolean isEmpty() {
		return (front > end) ? true : false;
	}
}
