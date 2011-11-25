/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	/* Private instance variables */
	private ArrayList <NameSurferEntry> entriesDisplayed;
	
	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		entriesDisplayed = new ArrayList<NameSurferEntry>();
	}
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		entriesDisplayed.clear();
	}
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		entriesDisplayed.add(entry);
	}
	
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		drawGraph();
		if(entriesDisplayed.size() >= 0) {
			for(int i = 0; i < entriesDisplayed.size(); i++) {
				NameSurferEntry entries = entriesDisplayed.get(i); 
				drawEntry(entries, i);
			}
		}
	}
	
	private void drawGraph() {
		drawVerticalLines();
		drawHorizontalLines();
		drawDecades(); 
	}
	
	//draws the vertical lines in the graph
	private void drawVerticalLines() {
		for(int i = 0; i<NDECADES; i++) {
			double y1 = 0;
			double y2 = getHeight();
			double x = i * (getWidth()/NDECADES);
			GLine line = new GLine(x, y1, x, y2);
			add(line);
		}
	}
	
	//draws the horizontal lines in the graph
	private void drawHorizontalLines() {
		double x1 = 0;
		double x2 = getWidth();
		double yLine1 = getHeight() - GRAPH_MARGIN_SIZE;
		GLine line1 = new GLine(x1, yLine1, x2, yLine1);
		add(line1);
		double yLine2 = GRAPH_MARGIN_SIZE;
		GLine line2 = new GLine(x1, yLine2, x2, yLine2);
		add(line2);
	}
	
	//draws the decade markers
	private void drawDecades() {
		for(int i = 0; i<NDECADES; i++) {
			int decade = START_DECADE;
			decade += 10*i;
			String label = Integer.toString(decade);
			double y = getHeight() - GRAPH_MARGIN_SIZE/4;
			double x = 2 + i * (getWidth()/NDECADES);
			GLabel displayedDecade = new GLabel(label, x, y);
			add(displayedDecade);
		}
	}
	
	//draws the graph line with the name and rank # labels
	private void drawEntry(NameSurferEntry entry, int entryNumber) {
		//draws the graph line
		for(int i = 0; i < NDECADES - 1; i++) {
			int ranking1 = entry.getRank(i);
			int ranking2 = entry.getRank(i+1);
			double x1 = i * (getWidth()/NDECADES);
			double x2 = (i+1) * (getWidth()/NDECADES);
			double y1 = 0;
			double y2 = 0;
			if(ranking1 != 0 && ranking2 != 0) {
				y1 = GRAPH_MARGIN_SIZE + (getHeight() - GRAPH_MARGIN_SIZE*2) * ranking1/MAX_RANK;
				y2 = GRAPH_MARGIN_SIZE + (getHeight() - GRAPH_MARGIN_SIZE*2) * ranking2/MAX_RANK;
			}
			else if(ranking1 == 0 && ranking2 == 0) {
				y1 = getHeight() - GRAPH_MARGIN_SIZE;
				y2 = getHeight() - GRAPH_MARGIN_SIZE;
			}
			else if (ranking1 == 0){
				y1 = getHeight() - GRAPH_MARGIN_SIZE;
				y2 = GRAPH_MARGIN_SIZE + (getHeight() - GRAPH_MARGIN_SIZE*2) * ranking2/MAX_RANK;
			}
			else if(ranking2 == 0) {
				y1 = GRAPH_MARGIN_SIZE + (getHeight() - GRAPH_MARGIN_SIZE*2) * ranking1/MAX_RANK;
				y2 = getHeight() - GRAPH_MARGIN_SIZE;
			}
			GLine line = new GLine(x1, y1, x2, y2);
			if(entryNumber%4 == 1) {
				line.setColor(Color.RED);
			}
			else if(entryNumber%4 == 2) {
				line.setColor(Color.BLUE);
			}
			else if(entryNumber%4 == 3) {
				line.setColor(Color.MAGENTA);
			}
			add(line);
		}
		//adds in the label with the Name and Rank number
		for(int i = 0; i<NDECADES; i++) {
			String name = entry.getName();
			int rank = entry.getRank(i);
			String rankString = Integer.toString(rank);
			String label = name + " " + rankString;
			double x = i * (getWidth()/NDECADES) + 5;
			double y = 0;
			if(rank != 0) {
				y = GRAPH_MARGIN_SIZE + (getHeight() - GRAPH_MARGIN_SIZE*2) * rank/MAX_RANK - 5;
			}
			else{
				label = name + " *";
				y = getHeight() - GRAPH_MARGIN_SIZE - 5;
			}
			GLabel nameLabel = new GLabel(label, x, y);
			if(entryNumber%4 == 1) {
				nameLabel.setColor(Color.RED);
			}
			else if(entryNumber%4 == 2) {
				nameLabel.setColor(Color.BLUE);
			}
			else if(entryNumber%4 == 3) {
				nameLabel.setColor(Color.MAGENTA);
			}
			add(nameLabel);
		}
	}
}
