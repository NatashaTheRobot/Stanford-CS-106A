/* This problem is from Stanford CS106A Section Handout 6. 
 * Write a program that asks the user for a list of names (one per line) until the user enters a 
blank line (i.e., just hits return when asked for a name).  At that point the program should 
print out how many times each name in the list was entered.  
 */


import java.util.*;
import acm.program.*;

public class CountNames extends ConsoleProgram {
	
	private Map <String, Integer> names = new HashMap <String, Integer>(); 
	
	public void run() {
		AskUserForNames();
		returnAnswer();
	}
	
	private void AskUserForNames() {
		while(true) {
			String name = readLine("Enter name: ");
			if(name.equals("")) break;
			if(names.containsKey(name) == false) {
				names.put(name, 1);
			}
			else{
				int addOne = names.get(name) + 1;
				names.put(name, addOne);
			}
		}
	}
	
	private void returnAnswer() {
		for(String name: names.keySet()) {
			println("Entry [" + name + "] has count " + names.get(name));
		}
	}
}
