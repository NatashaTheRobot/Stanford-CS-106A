/*Write a program  WordCount that reads a file and reports 
 * how many lines, words, and characters appear in it. */

import acm.program.*;
import java.io.*;
import java.util.*;

import acm.util.*;

public class WordCount extends ConsoleProgram {
	
	public void run() {
		writeFile();
	}
	
	private ArrayList <String> lines = new ArrayList <String> ();
	
	private void writeFile() {
		
		try {
			PrintWriter wr = new PrintWriter(new FileWriter("lear.txt"));
			println("Poor naked wretches, whereso'er you are,");
			println("That bide the pelting of this pitiless storm,");
			println("How shall your houseless heads and unfed sides,");
			println("Your loop'd and window'd raggedness, defend you");
			println("From seasons such as these? O, I have ta'en");
			println("Too little care of this!");
			wr.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	private void readFile() {
		BufferedReader rd = new BufferedReader(new FileReader("lear.txt"));
		
	}
}
