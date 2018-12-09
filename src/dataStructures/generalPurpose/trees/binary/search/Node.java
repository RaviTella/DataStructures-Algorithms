package dataStructures.generalPurpose.trees.binary.search;

public class Node {
	int key;
	String value;
	Node leftChild;
	Node rightChild;	
	
    public Node(int key,String value,Node leftChild,Node rightChild){
    	this.key=key;
    	this.value=value;
    	this.leftChild=leftChild;
    	this.rightChild=rightChild;
    }

}
