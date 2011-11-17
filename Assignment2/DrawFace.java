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
		double EyeY = getHeight()/2 - head_height/4 - eye_radius;
		double leftEyeX = getWidth()/2 - head_width/4 - eye_radius;
		double rightEyeX = getWidth()/2 + head_width/4 - eye_radius;
		buildEye(leftEyeX, EyeY);
		buildEye(rightEyeX, EyeY);
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
	
	private void buildEye(double x, double y) {
		GOval Eye = new GOval (x, y, eye_radius*2, eye_radius*2);
		Eye.setColor(Color.YELLOW);
		Eye.setFilled(true);
		Eye.setFillColor(Color.YELLOW);
		add(Eye);
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

