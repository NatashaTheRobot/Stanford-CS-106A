/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	
	//width of each box in the picture
	private static final int Width = 150;
	
	// height of each box in the picture
	private static final int Height = 60;
	
	public void run() {
		drawProgramBox();
		drawConsoleLine();
		drawConsoleBox();
		drawGraphicsLine();
		drawGraphicsBox();
		drawDialogLine();
		drawDialogBox();
	}
	
	private void drawProgramBox() {
		int x = getWidth()/2 - Width/2; //finds center width and moves to starting point
		int y = getHeight()/2 - Height; //finds center height and moves to starting point
		GRect drawBox = new GRect (x, y, Width, Height);  
		add(drawBox); //adds the Program box
		GLabel program = new GLabel("Program", x, y);
		add(program); //adds the "Program" words, but in the wrong location
		double boxCenterX = Width/2;
		double boxCenterY = Height/2;
		double halfProgramWidth = program.getWidth()/2; //finds the center of the width for "program"
		double halfProgramHeight = program.getAscent()/2; //finds the center of the height for "program"
		program.move( (boxCenterX - halfProgramWidth) , (boxCenterY + halfProgramHeight) ); 
	}
	private void drawConsoleLine() {
		int x1 = getWidth()/2; //finds center width 
		int y1 = getHeight()/2; //finds center height 
		int x2 = getWidth()/2;  //width value remains the same
		int y2 = getHeight()/2 + Height; //finds end point for height
		GLine drawLine = new GLine (x1, y1, x2, y2);
		add(drawLine);
	}
	private void drawConsoleBox() {
		int x = getWidth()/2 - Width/2; //Width remains same as Program Box Width
		int y = getHeight()/2 + Height; //Height changes 
		GRect drawBox = new GRect (x, y, Width, Height); 		
		add(drawBox); //adds the Console box
		GLabel console = new GLabel ("ConsoleProgram", x, y); 
		add(console); //adds the "Console" words, but in the wrong location		
		double boxCenterX = Width / 2;
		double boxCenterY = Height / 2;
		double halfConsoleWidth = console.getWidth()/2; 
		double halfConsoleHeight = console.getAscent()/2; 
		console.move( (boxCenterX - halfConsoleWidth) , (boxCenterY + halfConsoleHeight) );
	}
	private void drawGraphicsLine() {
		int x1 = getWidth()/2;
		int y1 = getHeight()/2;
		int x2 = getWidth()/2 - 3 * (Width/2);
		int y2 = getHeight()/2 + Height;
		GLine drawLine = new GLine (x1, y1, x2, y2);
		add(drawLine);
	}
	private void drawGraphicsBox() {
		int x = getWidth()/2 - 2*Width;
		int y = getHeight()/2 + Height;
		GRect drawBox = new GRect (x, y, Width, Height); 
		add(drawBox); 
		GLabel graphics = new GLabel ("GraphicsProgram", x, y); 
		add(graphics); 
		double boxCenterX = Width / 2;
		double boxCenterY = Height / 2;
		double halfGraphicsWidth = graphics.getWidth()/2; 
		double halfGraphicsHeight = graphics.getAscent()/2; 
		graphics.move( (boxCenterX - halfGraphicsWidth) , (boxCenterY + halfGraphicsHeight) );
	}
	private void drawDialogLine() {
		int x1 = getWidth()/2;
		int y1 = getHeight()/2;
		int x2 = getWidth()/2 + 3 * (Width/2);
		int y2 = getHeight()/2 + Height;
		GLine drawLine = new GLine (x1, y1, x2, y2);
		add(drawLine);
	}
	private void drawDialogBox() {
		int x = getWidth()/2 + Width;
		int y = getHeight()/2 + Height;
		GRect drawBox = new GRect (x, y, Width, Height); 
		add(drawBox); 
		GLabel dialog = new GLabel ("DialogProgram", x, y); 
		add(dialog); 
		double boxCenterX = Width / 2;
		double boxCenterY = Height / 2;
		double halfDialogWidth = dialog.getWidth()/2; 
		double halfDialogHeight = dialog.getAscent()/2; 
		dialog.move( (boxCenterX - halfDialogWidth) , (boxCenterY + halfDialogHeight) );
	}
}

