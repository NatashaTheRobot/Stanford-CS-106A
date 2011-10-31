/* Karel is cleaning up the voting ballot. 
 * The vote only counts if the middle rectangle is punched,
 * which means there are no beepers present. 
 */

import stanford.karel.SuperKarel;

public class defendDemocracyKarel extends SuperKarel {

public void run() {
	while (frontIsClear()) {
		move();
		checkMiddleBeeper();
		cleanExtraBeepers();
		move();
	}
}
private void checkMiddleBeeper() {
	if (beepersPresent()) {
		move();
		move();
	}
}
private void cleanExtraBeepers() {
	if (noBeepersPresent()) {
		cleanBeepersSouth();
		cleanBeepersNorth();
	}
}
/* Karel moves South, checks for beepers, and picks them up
 * if there are any there. 
 * Pre-condition: Karel is in the middle of a rectangle with no 
 * middle beeper
 * Post-condition: Karel returns to middle facing North
 */
private void cleanBeepersSouth() {
	turnRight();
	move();
	while (beepersPresent()) {
		pickBeeper(); 
	}
	turnAround();
	move();
}
/* Karel moves North, checks for beepers, and picks them up
 * if there are any there. 
 * Pre-condition: Karel is in the middle of a rectangle with no 
 * middle beeper
 * Post-condition: Karel returns to middle facing East
 */
private void cleanBeepersNorth() {
	move();
	if (frontIsClear()) {
		move();
	}
	while (beepersPresent()) {
		pickBeeper();
	}
	turnAround();
	move();
	turnLeft();
	}
}