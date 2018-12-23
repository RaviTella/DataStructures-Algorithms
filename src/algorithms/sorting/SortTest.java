package algorithms.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortTest {

	@Test
	public void testMergeSort() {
		int [] a = {33,7,4,10,8,22,1,5,7};
		Sort s= new Sort(a);
		s.mergeSort();
		s.display();
	}

}
