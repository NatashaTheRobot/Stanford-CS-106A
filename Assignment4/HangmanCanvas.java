/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */


import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		drawScaffold();
	}
	
	private void drawScaffold() {
		double scaffoldTopX = getWidth()/2 - UPPER_ARM_LENGTH;
		double scaffoldTopY = getHeight()/2 - BODY_LENGTH - HEAD_RADIUS*2 - ROPE_LENGTH;
		double scaffoldBottomY = scaffoldTopY + SCAFFOLD_HEIGHT;
		GLine scaffold= new GLine (scaffoldTopX, scaffoldTopY, scaffoldTopX, scaffoldBottomY);
		add(scaffold);
		double beamRightX = scaffoldTopX + BEAM_LENGTH;
		GLine beam = new GLine(scaffoldTopX, scaffoldTopY, beamRightX, scaffoldTopY);
		add(beam);
		double ropeBottomY = scaffoldTopY + ROPE_LENGTH;
		GLine rope = new GLine (beamRightX, scaffoldTopY, beamRightX, ropeBottomY);
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		//adds the label with the correctly guessed letters
		double x = getWidth()/4;
		double y = getHeight() - HEAD_RADIUS*2;
		GLabel unGuessedWord = new GLabel(word, x, y);
		unGuessedWord.setFont("Halvetica-24");
		//removes the latest hidden word and replaces it 
		//with the newest one with the new updated guessed letter
		if (getElementAt(x,y) != null){
			remove(getElementAt(x,y));
		}
		add(unGuessedWord);
		
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String incorrectGuesses) {
		//adds the label with the incorrect letters
		double x = getWidth()/4;
		double y = getHeight() - HEAD_RADIUS;
		GLabel incorrectLetters = new GLabel(incorrectGuesses, x, y);
		//checks to see if there is already a list of incorrect letters in place, 
		//and removes them before adding the new string, with the latest letter
		if(getElementAt(x,y) != null) {
			remove(getElementAt(x,y));
		}
		add(incorrectLetters);
		//checks how many incorrect guessed letters there are 
		//and draws the next appropriate body part of the hangman
		if(incorrectGuesses.length() == 1) {
			drawHead();
		}
		if(incorrectGuesses.length() == 2) {
			drawBody();
		}
		if(incorrectGuesses.length() == 3) {
			drawLeftArm();
		}
		if(incorrectGuesses.length() == 4) {
			drawRightArm();
		}
		if(incorrectGuesses.length() == 5) {
			drawLeftLeg();
		}
		if(incorrectGuesses.length() == 6) {
			drawRightLeg();
		}
		if(incorrectGuesses.length() == 7) {
			drawLeftFoot();
		}
		if(incorrectGuesses.length() == 8) {
			drawRightFoot();
		}
	}
	
	private void drawHead() {
		double x = getWidth()/2 - UPPER_ARM_LENGTH + BEAM_LENGTH - HEAD_RADIUS;
		double y = getHeight()/2 - BODY_LENGTH - HEAD_RADIUS*2;
		GOval head = new GOval (x, y, HEAD_RADIUS*2, HEAD_RADIUS*2);
		add(head);
	}
	
	private void drawBody() {
		double x = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double topY = getHeight()/2 - BODY_LENGTH;
		double bottomY = topY + BODY_LENGTH;
		GLine body = new GLine (x, topY, x, bottomY);
		add(body);
	}
	
	private void drawLeftArm() {
		double armStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double armEndX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS - UPPER_ARM_LENGTH;
		double upperArmHeightY = getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		GLine upperLeftArm = new GLine (armStartX, upperArmHeightY, armEndX, upperArmHeightY);
		add(upperLeftArm);
		double lowerArmEndY = upperArmHeightY + LOWER_ARM_LENGTH;
		GLine lowerLeftArm = new GLine (armEndX, upperArmHeightY, armEndX, lowerArmEndY);
		add(lowerLeftArm);
	}
	
	private void drawRightArm() {
		double armStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double armEndX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS + UPPER_ARM_LENGTH;
		double upperArmHeightY = getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		GLine upperRightArm = new GLine (armStartX, upperArmHeightY, armEndX, upperArmHeightY);
		add(upperRightArm);
		double lowerArmEndY = upperArmHeightY + LOWER_ARM_LENGTH;
		GLine lowerRightArm = new GLine (armEndX, upperArmHeightY, armEndX, lowerArmEndY);
		add(lowerRightArm);
	}
	
	private void drawLeftLeg() {
		double hipStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double hipEndX = hipStartX - HIP_WIDTH;
		double hipHeightY = getHeight()/2;
		GLine leftHip = new GLine(hipStartX, hipHeightY, hipEndX, hipHeightY);
		add(leftHip);
		double leftLegY = hipHeightY + LEG_LENGTH;
		GLine leftLeg = new GLine(hipEndX, hipHeightY, hipEndX, leftLegY);
		add(leftLeg);
		
	}
	
	private void drawRightLeg() {
		double hipStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS;
		double hipEndX = hipStartX + HIP_WIDTH;
		double hipHeightY = getHeight()/2;
		GLine leftHip = new GLine(hipStartX, hipHeightY, hipEndX, hipHeightY);
		add(leftHip);
		double leftLegEndY = hipHeightY + LEG_LENGTH;
		GLine leftLeg = new GLine(hipEndX, hipHeightY, hipEndX, leftLegEndY);
		add(leftLeg);
	}
	
	private void drawLeftFoot() {
		double footStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS - HIP_WIDTH;
		double footEndX = footStartX - FOOT_LENGTH;
		double footHeightY = getHeight()/2 + LEG_LENGTH;
		GLine leftFoot = new GLine(footStartX, footHeightY, footEndX, footHeightY);
		add(leftFoot);
	}
	
	private void drawRightFoot() {
		double footStartX = getWidth()/2 + UPPER_ARM_LENGTH/2 + HEAD_RADIUS + HIP_WIDTH;
		double footEndX = footStartX + FOOT_LENGTH;
		double footHeightY = getHeight()/2 + LEG_LENGTH;
		GLine rightFoot = new GLine(footStartX, footHeightY, footEndX, footHeightY);
		add(rightFoot);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
