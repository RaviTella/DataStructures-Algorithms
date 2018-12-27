package algorithms.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

	@Test
	public void testMergeSort() {
		int[] a = { 33, 7, 4, 10, 8, 22, 1, 5, 7 };
		Sort s = new Sort(a);
		s.mergeSortRecursive();
		assertEquals(33, a[8]);
		assertEquals(22, a[7]);
	}

	@Test
	public void testSelectionSortIterative() {
		int[] a = { 2, 33, 4, 10, 8, 22, 1, 5, 7 };
		Sort s = new Sort(a);
		s.selectionSortIterative();
		assertEquals(33, a[8]);
		assertEquals(22, a[7]);
	}

	@Test
	public void testSelectionSortRecursive() {
		int[] a = { 2, 33, 4, 10, 8, 22, 1, 5, 7 };
		Sort s = new Sort(a);
		s.selectionSortRecursive();
		assertEquals(33, a[8]);
		assertEquals(22, a[7]);
		s.display();
	}
}
