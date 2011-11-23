/*Write a program that asks the user for a list of names (one per line) until the user enters a 
blank line (i.e., just hits return when asked for a name).  At that point the program should 
print out the list of names entered, where each name is listed only once (i.e., uniquely) no 
matter how many times the user entered the name in the program. */


import java.util.*;
import acm.program.*;


public class UniqueNames extends ConsoleProgram {
	
	//an instance array that contains the list of entered names
	private ArrayList <String> names = new ArrayList <String> ();
	
	public void run() {
		askForNames();
		writeUniqueNames();
	}
	
	//ask for names until a blank name is entered, 
	//and if the name does not match an existing name in the array, 
	//adds it to the array
	private void askForNames() {
		while(true) {
			String name = readLine("Enter name: "); 
			if(name.equals("")) break;
			if(names.contains(name) == false) {
				names.add(name);
			}
		}
	}
	
	//prints all the names in the array
	private void writeUniqueNames() {
		println("Unique name list contains:");
		for(int i = 0; i < names.size(); i++) {
			println(names.get(i));
		}
	}

}
