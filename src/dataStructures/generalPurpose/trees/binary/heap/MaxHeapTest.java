package dataStructures.generalPurpose.trees.binary.heap;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {
	MaxHeap maxHeap;

	@Before
	public void setUp() throws Exception {
		maxHeap = new MaxHeap(7);
		maxHeap.insert(90, "Ravi");
		maxHeap.insert(80, "ranjit");
		maxHeap.insert(100, "raj");
		maxHeap.insert(70, "amar");
		maxHeap.insert(30, "topi");
		maxHeap.insert(60, "leo");
		maxHeap.insert(200, "arya");
	}

	@Test
	public void testGetRoot() {
		assertEquals("arya", maxHeap.getRoot().value);
	}

	@Test
	public void testMaximumHeap() {
	}

	@Test
	public void testInsert() {
		MaxHeap mh = new MaxHeap(9);
		mh.insert(90, "ninety");
		mh.insert(80, "eighty");
		mh.insert(100, "hundred");
		mh.insert(70, "seventy");
		mh.insert(30, "thirty");
		mh.insert(60, "sixty");
		mh.insert(50, "fifty");
		mh.insert(10, "ten");
		mh.insert(200, "two hundred");
		assertEquals(200, mh.remove().key);
		assertEquals(100, mh.remove().key);
	}

	@Test
	public void testRemove() {
		int nElements = maxHeap.getSize();
		while (nElements-- > 0) {
			System.out.println(maxHeap.remove().key);
		}

	}

	@Test
	public void testChange() {
		maxHeap.change(5, 500);
		assertEquals("leo", maxHeap.remove().value);
		maxHeap.change(2, 1);
		int nElements = maxHeap.getSize();
		String value = null;
		while (nElements-- > 0) {
			value = maxHeap.remove().value;
		}
		assertEquals("raj", value);

	}

}
