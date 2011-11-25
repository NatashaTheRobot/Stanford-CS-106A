import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import acm.util.*;
import java.util.*;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {
	
	/* Private instance variables */
	private Map <String, NameSurferEntry> namesdb = new HashMap <String, NameSurferEntry>(); 
	
/* Constructor: NameSurferDataBase(filename) */
/**
 * Creates a new NameSurferDataBase and initializes it using the
 * data in the specified file.  The constructor throws an error
 * exception if the requested file does not exist or if an error
 * occurs as the file is being read.
 */
	public NameSurferDataBase(String filename) {
		getNameData(filename);
	}
	
	private void getNameData(String filename) {
		try{
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while(true) {
				String line = rd.readLine();
				if(line == null) break;
				NameSurferEntry nameEntry = new NameSurferEntry(line);
				namesdb.put(nameEntry.getName(), nameEntry);
			}
			rd.close();
		} catch(IOException ex) {
				throw new ErrorException(ex);
			}
		}
	
/* Method: findEntry(name) */
/**
 * Returns the NameSurferEntry associated with this name, if one
 * exists.  If the name does not appear in the database, this
 * method returns null.
 */
	public NameSurferEntry findEntry(String name) {
		char ch = name.charAt(0);
		if(Character.isLowerCase(ch) == true) {
			ch = Character.toUpperCase(ch);
		}
		String otherLetters = name.substring(1);
		otherLetters = otherLetters.toLowerCase();
		name = ch + otherLetters;
		if(namesdb.containsKey(name)) {
			return namesdb.get(name);
		}
		else{
			return null;
		}
	}
	
}

