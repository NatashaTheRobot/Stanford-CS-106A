/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		putAllBricks();
	}
	private void putAllBricks()
	{
		//row - 0-based index of the row 
		//row+1 - The 1-based index of the row
		//brickNum - 0-based index of the brick
		
		//Loop through the 0-based index of the rows
		for( int row = 0; row < BRICKS_IN_BASE; row++ )
		{
			int bricksInRow = BRICKS_IN_BASE - row;
			
			//
			// Total number of bricks = row
			//
			for( int brickNum = 0; brickNum < bricksInRow; brickNum++ )
			{
				//1. Calculate the center
				//2. Calculate the starting point based on the center
				//3. Add the number of bricks * brick width to find this brick's location
				int x = ( getWidth()/2 ) - (BRICK_WIDTH * bricksInRow) / 2 + brickNum * BRICK_WIDTH;
				
				// 
				// Calculate the vertical location of the brick based on the row
				//
				int y = getHeight() - BRICK_HEIGHT * (row+1);
				
				//
				// Draw the brick
				//
				GRect brick = new GRect( x , y , BRICK_WIDTH , BRICK_HEIGHT );
				add(brick);
			}
		}
	}
}

