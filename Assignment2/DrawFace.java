import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class DrawFace extends GraphicsProgram {
	
	private static final int head_width = 100;
	
	private static final int head_height = 200;
	
	private static final int eye_radius = 20; 
	
	private static final int mouth_width = 50;
	
	private static final int mouth_height = 20;
	
	public void run() {
		buildHead();
		buildLeftEye();
		buildRightEye();
		buildMouth();
	}
	private void buildHead() {
		double startingWidth = ((getWidth()/2) - (head_width/2));
		double startingHeight = ((getHeight()/2) - (head_height/2));
		GRect face = new GRect (startingWidth, startingHeight, head_width, head_height);
		add(face);
		face.setFilled(true);
		face.setFillColor(Color.GRAY);
	}
	private void buildLeftEye() {
		double startingWidth = getWidth()/2 - head_width/4 - eye_radius/2;
		double startingHeight = getHeight()/2 - head_height/4 - eye_radius/2;
		GOval leftEye = new GOval (startingWidth, startingHeight, eye_radius, eye_radius);
		add(leftEye);
		leftEye.setColor(Color.YELLOW);
		leftEye.setFilled(true);
		leftEye.setFillColor(Color.YELLOW);
	}
	private void buildRightEye() {
		double startingWidth = getWidth()/2 + head_width/4 - eye_radius/2;
		double startingHeight = getHeight()/2 - head_height/4 - eye_radius/2;
		GOval rightEye = new GOval (startingWidth, startingHeight, eye_radius, eye_radius);
		add(rightEye);
		rightEye.setColor(Color.YELLOW);
		rightEye.setFilled(true);
		rightEye.setFillColor(Color.YELLOW);
	}
	private void buildMouth() {
		double startingWidth = getWidth()/2 - mouth_width/2;
		double startingHeight = getHeight()/2 + head_height/4 - mouth_height/2;
		GRect mouth = new GRect (startingWidth, startingHeight, mouth_width, mouth_height);
		add(mouth);
		mouth.setColor(Color.WHITE);
		mouth.setFilled(true);
		mouth.setFillColor(Color.WHITE);
	}
}

