package dataStructures.generalPurpose.graphs;

public class Graph {
	private Vertex[] vArray;
	private int numVertices;
	private int[][] adjMatrix;
	private Stack pathStack;
	private Queue pathQueue;

	public Graph(int maxVertices) {
		this.vArray = new Vertex[maxVertices];
		this.numVertices = 0;
		this.adjMatrix = new int[maxVertices][maxVertices];
		this.pathStack = new Stack(maxVertices);
		this.pathQueue = new Queue(maxVertices);
	}

	public void addVertex(Vertex v) {
		vArray[this.numVertices++] = v;
	}

	public void addEdge(int v1, int v2) {
		adjMatrix[v1][v2] = 1;
		adjMatrix[v2][v1] = 1;
	}

	private int getAdjUnVistitedVertexIndex(int vIndex) {
		for (int j = 0; j < numVertices; j++) {
			if (adjMatrix[vIndex][j] == 1 && !vArray[j].isVisited) {
				return j;
			}
		}
		return -1;
	}

	public void depthFirstSearch() {
		Vertex first = vArray[0];
		printVertex(0);
		pathStack.push(0);
		first.isVisited = true;

		while (!pathStack.isEmpty()) {
			int vIndex = getAdjUnVistitedVertexIndex(pathStack.peekTail());
			if (vIndex != -1) {
				printVertex(vIndex);
				vArray[vIndex].isVisited = true;
				pathStack.push(vIndex);
			} else {
				pathStack.pop();
			}
		}

	}

	public void breadthFirstSearch() {
		Vertex first = vArray[0];
		printVertex(0);
		pathQueue.enQueue(0);
		first.isVisited = true;
		while (!pathQueue.isEmpty()) {
			int vIndex = getAdjUnVistitedVertexIndex(pathQueue.peekFront());
			if (vIndex != -1) {
				printVertex(vIndex);
				vArray[vIndex].isVisited = true;
				pathQueue.enQueue(vIndex);
			} else {
				pathQueue.deQueue();
			}
		}

	}

	public void minimumSpanningTreeDF() {
		Vertex first = vArray[0];
		pathStack.push(0);
		first.isVisited = true;
		int vIndex = 0;
		while (!pathStack.isEmpty()) {
			int prevVIndex = pathStack.peekTail();
			vIndex = getAdjUnVistitedVertexIndex(pathStack.peekTail());
			if (vIndex != -1) {
				System.out.println(vArray[prevVIndex].name + " - " + vArray[vIndex].name);
				vArray[vIndex].isVisited = true;
				pathStack.push(vIndex);
			} else {
				pathStack.pop();
			}

		}
	}

	private void printVertex(int vIndex) {
		System.out.println(vArray[vIndex].name);
	}

}