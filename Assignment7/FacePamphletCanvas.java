/*
 * File: FacePamphletCanvas.java
 * -----------------------------
 * This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 */


import acm.graphics.*;
import java.awt.*;
import java.awt.Image.*;
import java.util.*;

public class FacePamphletCanvas extends GCanvas 
					implements FacePamphletConstants {
	
	/* Private instance variables*/
	double nameHeight = 0;
	double lastX = 0;
	double lastY = 0;
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for 
	 * the display
	 */
	public FacePamphletCanvas() {
		// You fill this in
	}
	
	/** 
	 * This method displays a message string near the bottom of the 
	 * canvas.  Every time this method is called, the previously 
	 * displayed message (if any) is replaced by the new message text 
	 * passed in.
	 */
	public void showMessage(String msg) {
		GLabel message = new GLabel(msg);
		double x = getWidth()/2 - message.getWidth()*3/4;
		double y = getHeight() - BOTTOM_MESSAGE_MARGIN;
		if(getElementAt(lastX, lastY) != null) {
			remove(getElementAt(lastX, lastY));
		}
		lastX = x;
		lastY = y;
		message.setFont(MESSAGE_FONT);
		add(message, x, y);
	}
	
	
	/** 
	 * This method displays the given profile on the canvas.  The 
	 * canvas is first cleared of all existing items (including 
	 * messages displayed near the bottom of the screen) and then the 
	 * given profile is displayed.  The profile display includes the 
	 * name of the user from the profile, the corresponding image 
	 * (or an indication that an image does not exist), the status of
	 * the user, and a list of the user's friends in the social network.
	 */
	public void displayProfile(FacePamphletProfile profile) {
		removeAll();
		addName(profile.getName());
		addImage(profile.getImage());
		addStatus(profile.getStatus());
		addFriends(profile.getFriends());
	}
	
	private void addName(String name) {
		GLabel Name = new GLabel(name);
		Name.setFont(PROFILE_NAME_FONT);
		Name.setColor(Color.BLUE);
		double x = LEFT_MARGIN;
		nameHeight = Name.getHeight();
		double y = TOP_MARGIN + nameHeight;
		add(Name, x, y);
	}
	
	private void addImage(GImage image) {
		double x = LEFT_MARGIN;
		double y = TOP_MARGIN + nameHeight + IMAGE_MARGIN; 
		if(image != null) {
			image.setBounds(x, y, IMAGE_WIDTH, IMAGE_HEIGHT);
			add(image);
		}
		else {
			GRect imageRect = new GRect(x, y, IMAGE_WIDTH, IMAGE_HEIGHT);
			add(imageRect);
			GLabel noImage = new GLabel("No Image");
			noImage.setFont(PROFILE_IMAGE_FONT);
			double labelWidth = x + IMAGE_WIDTH/2 - noImage.getWidth()/2;
			double labelHeight = y + IMAGE_HEIGHT/2;
			add(noImage, labelWidth, labelHeight);
		}
	}
	
	private void addStatus(String status) {
		GLabel Status = new GLabel(status);
		Status.setFont(PROFILE_STATUS_FONT);
		double x = LEFT_MARGIN;
		double y = TOP_MARGIN + nameHeight + IMAGE_MARGIN + IMAGE_HEIGHT + STATUS_MARGIN + Status.getHeight();
		if(getElementAt(x, y) != null) {
			remove(getElementAt(x, y));
		}
		add(Status, x, y);
	}

	private void addFriends(Iterator<String>friends) {
		GLabel Friends = new GLabel("Friends:");
		Friends.setFont(PROFILE_FRIEND_LABEL_FONT);
		double x = getWidth()/2;
		double y = TOP_MARGIN + nameHeight;
		add(Friends, x, y);
		Iterator<String> it = friends;
		for(int i = 1; it.hasNext(); i++) {
			GLabel friendName = new GLabel(it.next());
			friendName.setFont(PROFILE_FRIEND_FONT);
			double height = y + Friends.getHeight() * i;
			add(friendName, x, height);
		}
	}
	
}
