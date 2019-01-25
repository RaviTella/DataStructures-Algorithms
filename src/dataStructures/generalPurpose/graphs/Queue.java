package dataStructures.generalPurpose.graphs;

public class Queue {
	private int[] q;
	private int front;
	private int tail; 
	
	Queue(int size){
		this.q= new int[size];
		this.front=0;
		this.tail=-1;		
	}

	void enQueue(int v) {
		q[++tail]=v;
	}
	
	int deQueue() {
		int v = q[front++];
		return v;
	}
	
	int peek() {
		return q[front];
	}
	
	boolean isEmpty() {
		return (front>tail)? true: false;
	}
}
