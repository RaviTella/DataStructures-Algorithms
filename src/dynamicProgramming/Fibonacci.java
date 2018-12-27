package dynamicProgramming;

public class Fibonacci {

  public int generateRecursive(int n) {

    // base cases for first two numbers in the sequence 0 & 1
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int sum = generateRecursive(n - 1) + generateRecursive(n - 2);

    return sum;
  }

  public int generateIterative(int n) {
    // base cases for first two numbers in the sequence 0 & 1
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int first = 0;
    int second = 1;
    int sum = 0;
    for (int i = 2; i <= n; i++) {
      sum = first + second;
      first = second;
      second = sum;
    }
    return sum;
  }

  public int generateMemoization(int n) {
    int[] cache = new int[n + 1];
    return generateMemoization(n, cache);
  }

  public int generateMemoization(int n, int[] cache) {
  	//return sum from the cache
  	if(cache[n]!=0){
  		return cache[n];
	}
    // base cases for first two numbers in the sequence 0 & 1
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    int sum = generateMemoization(n - 1,cache) + generateMemoization(n - 2,cache);
    //cache sum
    cache[n]=sum;
    return sum;
  }
}
