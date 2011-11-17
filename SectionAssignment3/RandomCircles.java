/* This program draws a set of ten circles with different sizes, positions, 
* and colors.  Each circle should have a randomly chosen color, a randomly chosen radius 
* between 5 and 50 pixels, and a randomly chosen position on the canvas, subject to the 
* condition that the entire circle must fit inside the canvas without extending past the edge.  
*/


import acm.graphics.*;
import acm.program.*;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int numberOfCircles = 10;
	private static final int minRadius = 5;
	private static final int maxRadius = 50;
	
	public void run() {
		for(int i=0; i<numberOfCircles; i++ ) {
			drawCircle();
		}
	}
	
	private void drawCircle() {
		double radius = rgen.nextDouble(minRadius, maxRadius);
		double x = rgen.nextDouble(0, getWidth() - radius*2);
		double y = rgen.nextDouble(0, getHeight() - radius*2);
		GOval circle = new GOval(x, y, radius*2, radius*2);
		circle.setFilled(true);
		circle.setColor(rgen.nextColor());
		add(circle);
	}
	
}
