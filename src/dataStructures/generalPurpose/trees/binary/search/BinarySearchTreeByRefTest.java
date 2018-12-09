package dataStructures.generalPurpose.trees.binary.search;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeByRefTest {
	BinarySearchTreeByRef b;
	BinarySearchTreeByRef b1;

	@Before
	public void setUp() throws Exception {
		b=new BinarySearchTreeByRef();
		b.insert(10, "Ten");
		b.insert(20, "Twenty");		
		b.insert(9, "Nine");
		b.insert(15, "Fifteen");
		b.insert(70, "Seventy");
		b.insert(21, "Twenty One");
		b.insert(1, "One");
		b.insert(2, "Two");
		b.insert(30, "Thirty");
		
		b1= new BinarySearchTreeByRef();
		b1.insert(50, "fifty");
		b1.insert(20, "twenty");
		b1.insert(60, "sixty");
		b1.insert(15, "fifteen");
		b1.insert(55, "fiftyfive");
		b1.insert(30, "thirty");
		b1.insert(70, "seventy");
		
		
		
	}

	@Test
	public void nodeForGiveKeyShouldBeFound() {
		assertTrue((b.find(2).value).equals("Two"));			
	}
	
	@Test
	public void nodeForGiveKeyShouldNotBeFound() {
		assertNull(b.find(100));				
	}
	
	@Test
	public void nodeWithMaxKeyShouldBeReturned(){
		assertTrue((b.maximum().value).equals("Seventy"));
	}
	
	@Test
	public void nodeWithMinKeyShouldBeReturned(){
		assertTrue((b.minimum().value).equals("One"));
	}
	
	@Test
	public void inOrderTraversalTest(){
		b.inOrderTraversal("dscend");
	}

}
