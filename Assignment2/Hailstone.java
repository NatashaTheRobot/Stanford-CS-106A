/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int n = readInt("?"); //ask user for initial number input
		int steps = 0; //store the number of steps it takes to get to 1
		while ( n != 1 ) {
			if ( n%2 == 0) { //if the remainder of n/2 is 0, then the number is even
				println (n + " is even, so I take half: " + n/2);
				n = (n/2);
				steps = steps + 1;
			}
			else {
				println (n + " is odd, so I make 3n+1: " + (3*n+1));
				n = (3*n +1);
				steps = steps + 1;
			}
		}
		println ("The process took " + steps + " to reach 1");
	}	
}
	

