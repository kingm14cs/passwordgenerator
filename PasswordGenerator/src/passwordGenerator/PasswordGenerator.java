package passwordGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class PasswordGenerator {
 
	// SecureRandom() constructs a secure random number generator (RNG) implementing the default random number algorithm.
	private SecureRandom randomNum = new SecureRandom();
 
	private ArrayList<Object> passwordArray;
 
	public static void main(String[] args) {
		PasswordGenerator passwordGenerator = new PasswordGenerator();
		
		

		StringBuilder password = new StringBuilder();
		Scanner s = new Scanner(System.in);
		System.out.println("How many passwords would you like to create?");
		int numberOfPasswords = s.nextInt();
		
		File file = new File("C:/Users/kingm14/eclipse-workspace/TestingGround/documents/passwords.txt");

		//log("Password Generator: \n");
		try {
			//file.createNewFile();

			PrintWriter p = new PrintWriter(new FileOutputStream(file, true));
			for (int loop = 1; loop <= numberOfPasswords; loop++) {
				// Password length should be 20 characters
				for (int length = 0; length < 20; length++) {
					password.append(passwordGenerator.getRandom());
				}
				p.println(password.toString());
				//log(loop, password.toString());
				password.setLength(0);
			
			}
			p.flush();
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		s.close();
		
	}
 
	// Just initialize ArrayList passwordArray and add ASCII Decimal Values
	public PasswordGenerator() {
 
		passwordArray = new ArrayList<>();
 
		// Adding ASCII Decimal value between 33 and 53
		for (int i = 33; i < 53; i++) {
			passwordArray.add((char) i);
		}
 
		// Adding ASCII Decimal value between 54 and 85
		for (int i = 54; i < 85; i++) {
			passwordArray.add((char) i);
		}
 
		// Adding ASCII Decimal value between 86 and 128
		for (int i = 86; i < 127; i++) {
			passwordArray.add((char) i);
		}
		passwordArray.add((char) 64);
 
		// rotate() rotates the elements in the specified list by the specified distance. This will create strong password
		Collections.rotate(passwordArray, 5);
	}
 
	// Get Char value from above added Decimal values
	// Enable Logging below if you want to debug
	public char getRandom() {
		char charValue = (char) this.passwordArray.get(randomNum.nextInt(this.passwordArray.size()));
 
		// log(String.valueOf(charValue));
		return charValue;
	}
 
	// Simple log util
	//private static void log(String string) {
	//	System.out.println(string);
 
	//}
 
	// Simple log util
	//private static void log(int count, String password) {
	//	System.out.println("Password sample " + count + ": " + password);
 
	//}
}



