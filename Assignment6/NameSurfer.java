/*
 * File: NameSurfer.java
 * ---------------------
 * When it is finished, this program will implements the viewer for
 * the baby-name database described in the assignment handout.
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import acm.util.*;

public class NameSurfer extends Program implements NameSurferConstants {

	/* Private instance variables*/ 
	private JLabel label;
	private JTextField Name;
	private JButton Graph;
	private JButton Clear;
	private NameSurferDataBase namesdb;
	private NameSurferGraph graph;
	
/* Method: init() */
/**
 * This method has the responsibility for reading in the data base
 * and initializing the interactors at the bottom of the window.
 */
	public void init() {
		
		//Set up initial display with ineractors and canvas
		label = new JLabel("Name ");
		add(label, SOUTH);
		
		Name = new JTextField(20);
		add(Name, SOUTH);
		Name.addActionListener(this);
		
		Graph = new JButton("Graph");
		add(Graph, SOUTH);
		
		Clear = new JButton("Clear");
		add(Clear, SOUTH);
		
		graph = new NameSurferGraph();
		add(graph);
		
		addActionListeners();
		
		//reads the file of names and adds to the NameSurferDataBase
		namesdb = new NameSurferDataBase(NAMES_DATA_FILE);
	}
	
/* Method: actionPerformed(e) */
/**
 * This class is responsible for detecting when the buttons are
 * clicked, so you will have to define a method to respond to
 * button actions.
 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Clear")) {
			graph.clear();
			graph.update();
		}
		else {
			String enteredName = Name.getText();
			NameSurferEntry rankings = namesdb.findEntry(enteredName);
			if(rankings != null) {
				graph.addEntry(rankings);
				graph.update();
			}
		}
	}
}
