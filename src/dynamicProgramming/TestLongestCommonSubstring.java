package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLongestCommonSubstring {

	@Test
	public void testSubStringIterativeDP() {
		int result = LongestCommon.subStringIterativeDP("hello", "ello");
		assertEquals(4, result);
		assertEquals(1, LongestCommon.subStringIterativeDP("abcplka", "axyz"));
		assertEquals(6, LongestCommon.subStringIterativeDP("ababcplka", "axyzababkpababcp"));

	}
	
	
	@Test
	public void testSubSequenceIterativeDP() {
		assertEquals(4,LongestCommon.subSequenceIterativeDP("hello", "ello"));
		assertEquals(4,LongestCommon.subSequenceIterativeDP("GXTXAYB", "GTAB"));
	}

}
