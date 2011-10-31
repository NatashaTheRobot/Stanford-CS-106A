import stanford.karel.*;

public class defendDemocracyKarel extends SuperKarel {

public void run() {
	while (frontIsClear()) {
		move();
		checkBallot();
		move();
	}
}
private void checkBallot() {
	turnRight();
}
	
}