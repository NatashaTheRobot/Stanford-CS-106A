/* This program adds commas to long numbers
 */

import acm.program.*;

public class AddCommas extends ConsoleProgram {
	public void run() {
		while(true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}
	
	private String addCommasToNumericString(String digits) {
		String result = "";
		int length = digits.length();
		int nDigits = 0;
		for (int i = length -1; i>=0; i--) {
			result = digits.charAt(i) + result;
			nDigits++;
			if (((nDigits % 3) == 0) && (i>0)) {
				result = "," + result;
			}
		}
		return result;
	}
}
