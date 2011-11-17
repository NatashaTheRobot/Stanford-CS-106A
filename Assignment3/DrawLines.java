/* This program allows the user to draw lines on the canvas. Pressing the 
mouse button sets the starting point for the line.  Dragging the mouse moves the other 
endpoint around as the drag proceeds. Releasing the mouse fixes the line in its current 
position and gets ready to start a new line.  
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.event.*;

public class DrawLines extends GraphicsProgram {
	public void run() {
		readInstructions();
		addMouseListeners();
	}
	
	private void readInstructions() {
		GLabel instructions = new GLabel("Click the mouse to draw a line", 20, 20);
		add (instructions);
	}
	
	private GLine line;
	
	public void mousePressed(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		line = new GLine (x, y, x, y);
		add(line);
	}

	
	public void mouseDragged(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		line.setEndPoint(x, y);
	}
}
