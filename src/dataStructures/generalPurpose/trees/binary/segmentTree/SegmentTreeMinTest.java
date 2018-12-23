package dataStructures.generalPurpose.trees.binary.segmentTree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SegmentTreeMinTest {
	int[] iA;

	@Before
	public void setUp() throws Exception {
		iA = new int[] { 4, 2, 3, 1 };
	}

	@Test
	public void getRangeMinTest() {
		SegmentTreeMin s = new SegmentTreeMin(iA);
		int result = s.getRangeMin(0, 3);
		assertEquals(1, result);
		assertEquals(2, s.getRangeMin(0, 1));

	}

	 @Test
	public void updateTest() {
		SegmentTreeMin s = new SegmentTreeMin(iA);
		s.update(1, 0);
		int result = s.getRangeMin(0, 2);
		assertEquals(0, result);
		s.update(1, 100);
		assertEquals(3, s.getRangeMin(0, 2));
		assertEquals(1, s.getRangeMin(0, 3));
	}

}
