package dynamicProgramming;

public class LongestCommon {

	public static int subStringIterativeDP(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int c1Len = c1.length;
		int c2Len = c2.length;
		int longest = 0;
		int[][] z = new int[c1Len + 1][c2Len + 1];

		for (int i = 0; i < c1Len; i++) {
			for (int j = 0; j < c2Len; j++) {
				if (c1[i] == c2[j]) {
					z[i + 1][j + 1] = z[i][j] + 1;
				}
				longest = (longest > z[i + 1][j + 1]) ? longest : z[i + 1][j + 1];
			}
		}
		return longest;
	}

	public static int subSequenceIterativeDP(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int c1Len = c1.length;
		int c2Len = c2.length;
		int[][] z = new int[c1Len + 1][c2Len + 1];

		for (int i = 0; i < c1Len; i++) {
			for (int j = 0; j < c2Len; j++) {
				if (c1[i] == c2[j]) {
					z[i + 1][j + 1] = 1 + z[i][j];
				} else {
					z[i + 1][j + 1] = (z[i + 1][j] > z[i][j + 1]) ? z[i + 1][j] : z[i][j + 1];
				}
			}
		}
		return z[c1Len][c2Len];

	}

	public static int subStringIterative(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int c1Len = c1.length;
		int c2Len = c2.length;
		int longest = 0;

		for (int i = 0; i < c1Len; i++) {
			for (int j = 0; j < c2Len; j++) {
				if (c1[i] == c2[j]) {
					int substring = 1;
					for (int k = i+1, l = j+1; k < c1Len && l < c2Len; k++, l++) {
						if (c1[k] == c2[l]) {
							substring++;
						} else {
							break;
						}
					}
					longest = (substring > longest) ? substring : longest;
				}
			}
		}
		return longest;
	}

}
