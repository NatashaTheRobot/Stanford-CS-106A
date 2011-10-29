/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {
	public void run() {
		putBeeper();
		checkWall();
		while (frontIsClear()) {
			beepersEast();
			beepersWest();
		}
	}
	private void beepersEast() {
		while (facingEast()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
			upEast();
		}
	}
	private void upEast() {
		if (frontIsBlocked()) {
			if (noBeepersPresent()) {
				turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
					putBeeper();
				}
			}
			else {
				turnLeft();
				if (frontIsClear()) {
					move();
					turnLeft();
					move();
					putBeeper();
				}
			}
		}
	}
	private void beepersWest() {
		while (facingWest()) {
			move();
			if (frontIsClear()) {
				move();
				putBeeper();
			}
			upWest();
		}
	}
	private void upWest() {
		if (frontIsBlocked()) {
			if (noBeepersPresent()) {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
					putBeeper();
				}
			}
			else {
				turnRight();
				if (frontIsClear()) {
					move();
					turnRight();
					move();
					putBeeper();
				}
			}
		}
	}
	private void checkWall() {
		if (frontIsBlocked()) {
			turnLeft();
			while (frontIsClear()) {
				move();
				if (frontIsClear()) {
					move();
					putBeeper();
				}
			}
		}
	}
}