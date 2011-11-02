/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	
	private static final int sentinal = 0;
	
	public void run() {
		displayWelcomeMessage();
		findRange();
	}
	private void displayWelcomeMessage() {
		println("This program finds the largest and smallest numbers");
	}
	private void findRange() {
		int firstNumber = readInt("?"); //asking user for the first number
		if (firstNumber == sentinal) { 
			println("this is not a valid first value");
		} //if the first number is the sentinal, displays message
		int smallestNumber = firstNumber; //the first number is currently the smallest number
		int largestNumber = firstNumber; //the first number is also the largest number
		
		/*Pre-condition: the first number does not equal to the sentinal.
		 * compares each new number the user enters to the existing smallest and largest numbers, 
		 * and stores them as the smallest or largest if they are smallest or largest
		 */
		
		while ( firstNumber != sentinal) { 
			int secondNumber = readInt ("?"); //requests user to input the next number
			if (secondNumber < smallestNumber) { //compares the new number to the smallest number
				if (secondNumber != sentinal) {
					smallestNumber = secondNumber;
				} 
			// if the new number is the smaller than the smallest number, 
				//it is now stored as the smallest number
			}
			if (secondNumber > largestNumber) { //compares the new number to the largest number
				if (secondNumber != sentinal) {
					largestNumber = secondNumber;
				}
			//if the new number is larger than the largets number, 
				//it is now stored as the largest number
			}
			if(secondNumber == sentinal) { //if the new number is equal to the sentinal
				println ("smallest: " + smallestNumber); //prints out smallest number
				println ("largest: " + largestNumber); //pringt out largest number
				firstNumber = sentinal; //assigns "sentinal" to the first number to stop the while loop
			}
			
		}
	}
}

