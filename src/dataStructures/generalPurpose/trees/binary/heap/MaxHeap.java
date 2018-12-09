package dataStructures.generalPurpose.trees.binary.heap;



/*
 * @author Ravi Tella
 * Maximum Heap with Array
 */
public class MaxHeap {
  private Node[] a;
  private int nElements;

  public MaxHeap(int size) {
    a = new Node[size];
    nElements = 0;
  }

  
  public boolean insert(int key, String value) {
    // insert new node at the end(first empty cell)
    a[nElements] = new Node(key, value);
    bubbleUp(nElements);
    nElements++;
    return true;
  }


  public Node remove() {
    Node rNode = a[0]; // saving the root node that will be removed
    a[0] = a[--nElements]; // moves the last node to the root node position and decrements the
                           // number of elements in the array
    trickleDown(0);
    return rNode; // return the saved root node
  }


  public boolean change(int index, int nKey) {
    int cKey = a[index].key;
    //update the key of the node at index to new key
    a[index].key= nKey;
    
    if (cKey < nKey) {//bubble up if current key is less than new key 
      bubbleUp(index);      
    } else {
      trickleDown(index);     
    }
    return true;
  }


  public Node getRoot() {
    return a[0];
  }

  private int parentIndex(int i) {
    return (i - 1) / 2;
  }

  private int leftChildIndex(int i) {
    return 2 * i + 1;
  }

  private int rightChildIndex(int i) {
    return 2 * i + 2;
  }


  private void bubbleUp(int cIndex) {
    int pIndex = parentIndex(cIndex);
    while (cIndex >= 0 && a[cIndex].key > a[pIndex].key) {
      Node temp = a[pIndex];
      a[pIndex] = a[cIndex];
      a[cIndex] = temp;
      cIndex = pIndex;
      pIndex = parentIndex(cIndex);
    }
  }

  private void trickleDown(int cIndex) {
    while (cIndex < nElements / 2) { // While loop continues till the current node has at least one
                                     // child
      int rightCIndex = rightChildIndex(cIndex);
      int leftCIndex = leftChildIndex(cIndex);
      int largeCIndex = leftCIndex; // Setting large child index to Left child
      // "rightCIndex < nElements" checks if the last child has right node
      if (rightCIndex < nElements && a[rightCIndex].key > a[leftCIndex].key) {
        largeCIndex = rightCIndex; // Large child index set to right child only if right child
                                   // exists and is grater than left child
      }
      if (a[cIndex].key >= a[largeCIndex].key) { // return if node is grater than or equal to large
                                                 // child
        return;
      } else { // if node is less than large node then swap. Swap is always done with the largest.
        Node temp = a[largeCIndex];
        a[largeCIndex] = a[cIndex];
        a[cIndex] = temp;
        cIndex = largeCIndex; // set the loop control variable to large index
      }
    }
  }

  public int getSize() {
    return nElements;
  }

}
