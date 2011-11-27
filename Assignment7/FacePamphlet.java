/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import javax.swing.*;

public class FacePamphlet extends Program 
					implements FacePamphletConstants {

	/* Private instance variables*/
	//text fields
	private JTextField name;
	private JTextField status;
	private JTextField picture;
	private JTextField friend;
	
	//creates a new database and a new canvas
	private FacePamphletDatabase profileInfo = new FacePamphletDatabase();
	private FacePamphletCanvas canvas = new FacePamphletCanvas();
	
	//keeps track of the current profile
	private FacePamphletProfile currentProfile = null;
	
	
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	public void init() {
		
		//fields on the North Side of the screen
		add(new JLabel("Name "), NORTH); 
		
		name = new JTextField(TEXT_FIELD_SIZE);
		add(name, NORTH);
		
		add(new JButton("Add"), NORTH);
		
		add(new JButton("Delete"), NORTH);
		
		add(new JButton("Lookup"), NORTH);
		
		//fields on the West Side of the screen
		status = new JTextField(TEXT_FIELD_SIZE);
		add(status, WEST);
		
		add(new JButton("Change Status"), WEST);
		
		add(new JLabel(EMPTY_LABEL_TEXT), WEST); //space holder
		
		picture = new JTextField(TEXT_FIELD_SIZE);
		add(picture, WEST);
		
		add(new JButton("Change Picture"), WEST);
		
		add(new JLabel(EMPTY_LABEL_TEXT), WEST); //space holder
		
		friend = new JTextField(TEXT_FIELD_SIZE);
		add(friend, WEST);
		
		add(new JButton("Add Friend"), WEST);
		
		//Action listeners
		addActionListeners();
		status.addActionListener(this);
		picture.addActionListener(this);
		friend.addActionListener(this);
		
		add(canvas);
    }
  
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
	
    public void actionPerformed(ActionEvent e) {
    	
    	String enteredName = name.getText();
    	
    	//Add button is clicked
    	if(e.getActionCommand().equals("Add") && !name.getText().equals("")) {
    		//if the entered name does not exist in the database, a profile is created
    		if(profileInfo.containsProfile(enteredName) == false) {
    			FacePamphletProfile profile = new FacePamphletProfile(enteredName);
    			profileInfo.addProfile(profile);
    			canvas.displayProfile(profile);
    			canvas.showMessage("New profile created");
    			currentProfile = profile;
    		}
    		//if the entered name is already an existing profile, displays the profile
    		//and tells the user that the profile already exists
    		else{
    			FacePamphletProfile profile = profileInfo.getProfile(enteredName);
    			canvas.displayProfile(profile);
    			canvas.showMessage("A profile with name " + enteredName + " already exists.");
    			currentProfile = profile;
    		}
    	}
    	
    	//Delete button is clicked
    	else if (e.getActionCommand().equals("Delete") && !name.getText().equals("")){
    		//clears the canvas and sets the current profile to null
    		canvas.removeAll();
    		currentProfile = null;
    		//if the entered name exists as a profile, the profile is deleted
    		if(profileInfo.containsProfile(enteredName) == true) {
    			profileInfo.deleteProfile(enteredName);
    			canvas.showMessage("Profile of " + enteredName + " deleted");
    		}
    		//if the entered name is not an actual profile, tells the user 
    		//that the profile does not exist
    		else{
    			canvas.showMessage("A profile with name " + enteredName + " does not exist.");
    		}
    	}
    	
    	//Lookup button is clicked
    	else if (e.getActionCommand().equals("Lookup") && !name.getText().equals("")){
    		canvas.removeAll(); //clears everything off the canvas
    		//if the entered name exists in the database, displays the profile
    		if(profileInfo.containsProfile(enteredName) == true) {
    			FacePamphletProfile profile = profileInfo.getProfile(enteredName);
    			canvas.displayProfile(profile);
    			canvas.showMessage("Displaying " + enteredName);
    			currentProfile = profile;
    		}
    		//if the entered name does not exists, tells the user it doesn't exist
    		//and sets current profile to null
    		else{
    			canvas.showMessage("A profile with name " + enteredName + " does not exist.");
    			currentProfile = null;
    		}
    	}
    	
    	//Change Status is clicked or user clicked enter after entering a status in the text field
    	else if (e.getActionCommand().equals("Change Status") || e.getSource() == status && !status.getText().equals("")){
    		String statusMessage = status.getText();
    		if(currentProfile != null) {
    			FacePamphletProfile profile = profileInfo.getProfile(currentProfile.getName());
    			profile.setStatus(profile.getName() + " is " + statusMessage);
    			canvas.displayProfile(profile);
    			canvas.showMessage("Status updated to " + statusMessage);
    		}
    		else{
    			canvas.showMessage("Please select a profile to change status");
    		}
    	}
    	
    	//Change Picture is clicked or user clicked enter after entering picture name into the text field
    	else if (e.getActionCommand().equals("Change Picture") || e.getSource() == picture && !picture.getText().equals("")){
    		String filename = picture.getText();
    		if(currentProfile != null) {
    			FacePamphletProfile profile = profileInfo.getProfile(currentProfile.getName());
    			GImage image = null;
    			try {
    				image = new GImage(filename);
    				profile.setImage(image);
    			} catch (ErrorException ex) {
    				image = null;
    			}
    			canvas.displayProfile(profile);
    			if(image == null) {
    				canvas.showMessage("Unable to open image file: " + filename);
    			}
    			else{
    				canvas.showMessage("Picture updated");
    			}
    		}
    		else{
    			println("Please select a profile to change picture");
    		}
    	}
    	
    	//Add Friend is clicked or user clicked enter after entering a friends name into the text field
    	else if (e.getActionCommand().equals("Add Friend") || e.getSource() == friend && !friend.getText().equals("")){
    		String friendName = friend.getText();
    		//checks to see if there is a current profile
    		if(currentProfile != null) {
    			FacePamphletProfile profile = profileInfo.getProfile(currentProfile.getName());
    			//checks to see if the name entered is the users name. The user can't friend him/herself. 
    			if(profile.getName().equals(friendName)) {
    				canvas.showMessage("You cannot friend yourself");
    			}
    			//checks to see if the friend exists in the database
    			else if(profileInfo.containsProfile(friendName)) {
    				FacePamphletProfile friendProfile = profileInfo.getProfile(friendName);
    				//checks to see if the user is already friends with the friend name entered
    				
    				//if the user and the friend entered are not friends, makes them friends
    				if(profile.addFriend(friendName) == true) {
    					profile.addFriend(friendName);
    					friendProfile.addFriend(enteredName);
    					canvas.displayProfile(profile);
    					canvas.showMessage(friendName + " added as a friend.");
    				}
    				//if the user is already friends with the friend name entered, displays this message
    				else {
    					canvas.showMessage(profile.getName() + " already has " + friendName + " as a friend.");
    				}
    			}
    			//if the friend does not exist in the database, displays this message
    			else{
    				canvas.showMessage(friendName + " does not exist.");
    			}
    		}	
    		//if there is not current profile, asks user to select a profile
    		else{
    			canvas.showMessage("Please select a profile to add friend");
    		}	
    	}		
    }
}
