/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {	
	public void run() {
		putOuterCircle();
		putMiddleCircle();
		putInnerCircle();
	}
	private void putOuterCircle() {
		int radius = 72;
		int x = getWidth()/2 - radius;
		int y = getHeight()/2 - radius;
		GOval OuterCircle = new GOval (x, y, radius*2, radius*2);
		OuterCircle.setColor(Color.RED);
		OuterCircle.setFilled(true);
		OuterCircle.setFillColor(Color.RED);
		add(OuterCircle);
	}
	private void putMiddleCircle() {
		double radius = 72*64/100;
		double x = getWidth()/2 - radius;
		double y = getHeight()/2 - radius;
		GOval MiddleCircle = new GOval (x, y, radius*2, radius*2);
		MiddleCircle.setColor(Color.WHITE);
		MiddleCircle.setFilled(true);
		MiddleCircle.setFillColor(Color.WHITE);
		add(MiddleCircle);
	}
	private void putInnerCircle() {
		double radius = 72*3/10;
		double x = getWidth()/2 - radius;
		double y = getHeight()/2 - radius;
		GOval InnerCircle = new GOval (x, y, radius*2, radius*2);
		InnerCircle.setColor(Color.RED);
		InnerCircle.setFilled(true);
		InnerCircle.setFillColor(Color.RED);
		add(InnerCircle);
	}
}
