package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLongestCommon {

	@Test
	public void testSubStringIterativeDP() {
		int result = LongestCommon.subStringIterativeDP("hello", "ello");
		assertEquals(4, result);
		assertEquals(1, LongestCommon.subStringIterativeDP("abcplka", "axyz"));
		assertEquals(6, LongestCommon.subStringIterativeDP("ababcplka", "axyzababkpababcp"));

	}
	
	@Test
	public void testSubStringIterative() {
		int result = LongestCommon.subStringIterative("hello", "ello");
		assertEquals(4, result);
		assertEquals(1, LongestCommon.subStringIterative("abcplka", "axyz"));
		assertEquals(6, LongestCommon.subStringIterative("ababcplka", "axyzababkpababcp"));
		assertEquals(5, LongestCommon.subStringIterative("GeeksforGeeks", "GeeksQuiz"));
		assertEquals(8, LongestCommon.subStringIterative("tutorialhorizon", "dynamictutorialProgramming"));
		assertEquals(6, LongestCommon.subStringIterative("hksgtsncpdjkhwprnfkabcdefioedqwervbfdnpkpnvwfjkl", "okhdwuernaqpgfbabcdewpntryuekbndperabcdef"));

	}
	
	
	
	@Test
	public void testSubSequenceIterativeDP() {
		assertEquals(4,LongestCommon.subSequenceIterativeDP("hello", "ello"));
		assertEquals(4,LongestCommon.subSequenceIterativeDP("GXTXAYB", "GTAB"));
	}

}
