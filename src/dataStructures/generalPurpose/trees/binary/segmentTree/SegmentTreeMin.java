package dataStructures.generalPurpose.trees.binary.segmentTree;

public class SegmentTreeMin {
	private int[] iA;
	private int[] sA;

	public SegmentTreeMin(int[] iA) {
		this.iA = iA;
		this.sA = new int[3 * iA.length];
		recursiveBuild(0, iA.length - 1, 0);
	}

	private void recursiveBuild(int iAS, int iAE, int sANode) {
		// base case
		if (iAS == iAE) {
			sA[sANode] = iA[iAS];
			return;
		}
		// divide
		int mid = (iAS + iAE) / 2;
		int sALCI = getLeftChildIndex(sANode);
		int sARCI = getRightChildIndex(sANode);
		recursiveBuild(iAS, mid, sALCI);
		recursiveBuild(mid + 1, iAE, sARCI);

		// action
		sA[sANode] = getMin(sA[sALCI], sA[sARCI]);
	}

	private int getMin(int i, int j) {
		return (i <= j) ? i : j;
	}

	public int getRangeMin(int qS, int qE) {
		if (qS < 0 || qE > iA.length - 1) {
			return -100;
		}

		return recursiveGetRangeMin(qS, qE, 0, 0, iA.length-1);
	}

	private int recursiveGetRangeMin(int qS, int qE, int sANode, int iAS, int iAE) {
		//Base case
		// Node's segment matches the query range or node's segment is within the query range
		if (qS <= iAS && qE >= iAE) {
			return sA[sANode];
		}
        //Base Case
		// Node's segment is outside the query range (no intersection)
		if (qS > iAE || qE < iAS) {
            return Integer.MAX_VALUE;
		}
		// Node's segment intersect with the query range 
		//Divide
		int mid= (iAS+iAE)/2;
		int m1= recursiveGetRangeMin(qS, qE, getLeftChildIndex(sANode), iAS, mid);
		int m2=recursiveGetRangeMin(qS, qE, getRightChildIndex(sANode), mid+1, iAE);
		//Action
		return getMin(m1,m2);
	}
	
	public void update(int qI, int val) {
		if(qI >= 0 || qI < iA.length){
			recursiveUpdate(qI, val, 0,0,iA.length-1);
			}
		}
	
	private void recursiveUpdate(int qI, int val,int sANode,int iAS, int iAE){
		//Base case
		//Nodes's segment is same as the query range. looking for a leaf node.
		if(qI==iAS && qI==iAE){
			sA[sANode]=val;
			return;
		}
		//Base case
		//Node's segment is outside the query range
		if(qI > iAE || qI <iAS){
			return;
		}
		//Node's segment intersects query range. Since query range start and end are the same, range will always be within the Node segmnet 
		//Divide
		int mid=(iAS+iAE)/2;
		int sALCI = getLeftChildIndex(sANode);
		int sARCI = getRightChildIndex(sANode);		
		recursiveUpdate(qI, val, sALCI, iAS, mid);
		recursiveUpdate(qI, val, sARCI, mid+1, iAE);
		sA[sANode]=getMin(sA[sALCI],sA[sARCI]);
		
		
	}
	
	
	private int getLeftChildIndex(int node) {
		return 2 * node + 1;
	}

	private int getRightChildIndex(int node) {
		return 2 * node + 2;

	}
	
}
