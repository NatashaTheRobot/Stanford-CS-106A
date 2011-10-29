/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run () {
		putEndBeepers();
		while (frontIsClear()) {
			takeLastBeeperWest();
			takeLastBeeperEast();
		}
	}
	private void putEndBeepers() {
		move();
		putBeeper();
		while (frontIsClear()) {
			move();
		}
		turnAround();
		move();
		putBeeper();
	}
	private void takeLastBeeperWest() {
		if (facingWest()) {
			move();
			if (noBeepersPresent()) {
				putBeeper();
			}
			turnAround();
			move();
			pickBeeper();
			turnAround();
			move();
			move();
		}
			detectBeeper();
			turnAround();
		}
	private void takeLastBeeperEast() {
		if (facingEast()) {
			pickBeeper();
			move();
			if(noBeepersPresent()) {
				putBeeper();
			}
			move();
			detectBeeper();
			turnAround();
		}
	}
	private void detectBeeper() {
		while (noBeepersPresent()) {
			if(frontIsClear()) {
					move();
				}
			if(frontIsBlocked()) {
				turnAround();
				while(frontIsClear()) {
					if(noBeepersPresent()) {
						move();
					}
				}
			}
		}
	}
}
	