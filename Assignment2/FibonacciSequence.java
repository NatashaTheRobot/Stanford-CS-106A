/* 
 * This is the solution to the Section Handout #2 from the  
 * Stanford CS106A online class
 */

import acm.program.*;

public class FibonacciSequence extends ConsoleProgram {
	
	private static final int MAX_TERM_VALUE = 10000;
	
	public void run() {
		println( "This program lists the Fibonacci sequence" );
		int term = 0;
		int i = 0;
		while (term < MAX_TERM_VALUE) {
			term = fib(i);
			if (term < MAX_TERM_VALUE) {
				println(term);
			}
			i++;
		}
	}
	private int fib(int n) {
		//Fib(0) = 0
		//Fib(1) = 1
		//Fib(2) = 1 (0 + 1) = fib(0) + fib(1)
		//Fib(3) = 2 (1 + 1) = fib(1) + fib(2)
		//Fib(4) = 3 (1 + 2) = fib(2) + fib(3) 
		//Fib(5) = 5 (2 + 3) = fib(3) + fib(4)
		if (n==0) {
			return 0;
		}
		if (n==1) {
			return 1;
		}
		if (n>1) {
			return fib(n-1) + fib(n-2);
		}
		return 0; //need to include this in case someone enters in a negative #
	}
}
