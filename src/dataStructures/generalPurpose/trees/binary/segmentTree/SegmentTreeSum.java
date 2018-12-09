package dataStructures.generalPurpose.trees.binary.segmentTree;


/**
 * @author Ravi Tella
 * SegmentTree for range Sum
 */
public class SegmentTreeSum {
  private int[] iArray;
  private int[] stArray;

  SegmentTreeSum(int[] iArray) {
    this.iArray = iArray;
    this.stArray = new int[3 * iArray.length];
    recursiveBuild(0, iArray.length - 1, 0);
  }

  /**
   * Computes the sum of a sub array 
   * @param sSIndex start index of the sub array
   * @param sEIndex end index of the sub array 
   * @return sum of the sub array
   */
  public int sum(int sSIndex, int sEIndex) {
    if (sSIndex < 0 || sEIndex > iArray.length - 1) {
      return -100;
    }
    return recursiveSum(sSIndex, sEIndex, 0, iArray.length - 1, 0);
  }
  

  /**
   * @param sS start index of the sub array
   * @param sE end index of the sub array 
   * @param iS start of the segment of a input array
   * @param iE end of the segment of a input array
   * @param sNode sNode index of the segment tree 
   *        iE
   * @return
   */
  private int recursiveSum(int sS, int sE, int iS, int iE, int sNode) {
    // if sub array is out of current range
    if (iE < sS || iS > sE || sS > sE) {
      return 0;
    }
    // if the sub array is same or overlaps the current range (current range is same or within the
    // sub array)
    if (iS >= sS && iE <= sE) {
      return stArray[sNode];
    }
    // current range and query range intersect
    int mIndex = (iS + iE) / 2;
    int leftChildIndex = leftChildIndex(sNode);
    int rightChildIndex = rightChildIndex(sNode);
    // left
    return recursiveSum(sS, sE, iS, mIndex, leftChildIndex) +
    // right
        recursiveSum(sS, sE, mIndex + 1, iE, rightChildIndex);


  }

  private void recursiveBuild(int iS, int iE, int sNode) {
    if (iS == iE) {
      stArray[sNode] = iArray[iS];
      return;
    }
    int mIndex = (iS + iE) / 2;
    int leftChildIndex = leftChildIndex(sNode);
    int rightChildIndex = rightChildIndex(sNode);
    // left
    recursiveBuild(iS, mIndex, leftChildIndex);
    // right
    recursiveBuild(mIndex + 1, iE, rightChildIndex);
    // sum up children for parent
    stArray[sNode] = stArray[leftChildIndex] + stArray[rightChildIndex];
  }

  /**
   * @param iU index of the cell in the input array to be updated
   * @param v new value
   */
  public void update(int iU, int v) {
    recursiveUpdate(iU, v, 0, iArray.length - 1, 0);
    iArray[iU] = v;

  }

  /**
   * @param iU index of the cell in the input array to be updated
   * @param v new value
   * @param iS start of the segment of a input array
   * @param iE end of the segment of a input array
   * @param sNode index of the segment tree 
   *        
   */
  private void recursiveUpdate(int iU, int v, int iS, int iE, int sNode) {
    // found the segment tree leaf node where the new value must be inserted
    if (iS == iE && iS == iU) {
      stArray[sNode] = v;
      return;
    }
    // segment tree section does not contain the leaf node that needs to be updated with the new
    // value
    if (iU < iS || iU > iE) {
      return;
    }
    int m = (iS + iE) / 2;
    int leftChildIndex = leftChildIndex(sNode);
    int rightChildIndex = rightChildIndex(sNode);

    // left
    recursiveUpdate(iU, v, iS, m, leftChildIndex);
    // right
    recursiveUpdate(iU, v, m + 1, iE, rightChildIndex);
    stArray[sNode] = stArray[leftChildIndex] + stArray[rightChildIndex];

  }

  void display() {
    for (int item : stArray) {
      System.out.println(item);
    }
  }

  private int leftChildIndex(int pIndex) {
    return 2 * pIndex + 1;
  }

  private int rightChildIndex(int pIndex) {
    return 2 * pIndex + 2;
  }

}
