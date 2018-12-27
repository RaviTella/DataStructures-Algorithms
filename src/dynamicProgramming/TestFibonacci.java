package dynamicProgramming;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFibonacci {

	@Test
	public void testGenerateRecursive() {
		Fibonacci f= new Fibonacci();
		assertEquals(2,f.generateRecursive(3));
		assertEquals(34,f.generateRecursive(9));
	}
	
	@Test
	public void testGenerateIterative() {
		Fibonacci f= new Fibonacci();
		assertEquals(2,f.generateRecursive(3));
		assertEquals(34,f.generateRecursive(9));
	}

	@Test
	public void testGenerateDynamicProgramming(){
		Fibonacci f= new Fibonacci();
		assertEquals(2,f.generateRecursive(3));
		assertEquals(34,f.generateRecursive(9));
	}
	

}
