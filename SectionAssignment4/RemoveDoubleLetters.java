/* This is the solution to Midterm Problem 5. 
 * Write a method removeDoubledLetters that takes a string as its argument 
and returns a new string with all doubled letters in the string replaced by a single letter.  For example, if you call
removeDoubledLetters("tresidder") your method should return the string "tresider".  Similarly, if you call
removeDoubledLetters("bookkeeper") your method should return "bokeper"
 * In writing your solution, you should keep in mind the following:
	* You do not need to write a complete program.  All you need is the definition of the method 
removeDoubledLetters that returns the desired result.
	* You may assume that all letters in the string are lower case so that you don’t have to worry 
about changes in capitalization.
	* You may assume that no letter appears more than twice in a row.  (It is likely that your 
program will work even if this restriction were not included; we’ve included it explicitly only 
so that you don’t even have to think about this case.)
 */

import acm.program.*;

public class RemoveDoubleLetters extends ConsoleProgram {
	
	
	public void run() {
		String newWord = readLine("Enter a word with double letters: ");
		println("the new spelling of your word is " + readDoubleLetters(newWord));
	}
	
	private String readDoubleLetters(String word) {
		String result = "";
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(i == 0 || ch != word.charAt(i-1)) {
				result = result + ch;
			}
		}
		return result;
	}
}


