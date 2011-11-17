/* This is the answer to Question 1 on the Stanford CS106A Practice Midterm.
 * We want to write a Karel program which will create an inside border around the world. Each 
location that is part of the border should have  one (and only one) beeper on it and the border 
should be inset by one square from the outer walls of the world
 * You may assume that the world is at least 3x3 squares. The correct solution for a 3x3 
square world is to place a single beeper in the center square.  
 - Karel starts off facing  East at the corner of 1st Street and 1st Avenue with an infinite 
number beepers in its beeper bag.
- We do not care about Karel’s final location or heading.
- You do not need to worry about efficiency.
- You are limited to the instructions in the Karel booklet—the only variables allowed are 
loop control variables used within the control section of the for loop.
 */


import stanford.karel.*;

public class KarelDrawsBorder extends SuperKarel {
	public void run() {
		getInStartingPosition();
		for (int i = 0; i < 4; i++) {
			putBeepers();
			startNextRow();
		}
		backToStart();
	}
	
	private void getInStartingPosition() {
		turnLeft();
		move();
		turnRight();
	}
	
	private void putBeepers() {
		while (frontIsClear()) {
			move();
			if(noBeepersPresent()) {
				putBeeper();
			}
		}
	}	
		
	private void startNextRow() {	
		pickBeeper();
		turnAround();
		move();
		turnRight();
	}
	
	private void backToStart() {
		turnAround();
		move();
		turnAround();
	}
}
