package algorithms.sorting;

public class Factorial {

	public static void main(String[] args) {
		System.out.println(recursiveFactorial(3));

	}

	private static int recursiveFactorial(int n) {
		// BASE CASE
		if (n == 1) {
			return 1;
		}
		//ACTION
		return n * recursiveFactorial(n - 1);

	}

}
