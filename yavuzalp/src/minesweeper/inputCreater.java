package minesweeper;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 
 * @author Yavuzalp Turkoglu
 * @version Spring 2021
 */
public class inputCreater {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		StringBuilder InputToWrite = new StringBuilder();
		//I created all random 12 minefields.
		//I didnt cover the edge cases since we went with Eugene's work to submit.
		for (int i = 0; i < 12; i++) {// row
			String input = randomInputCreater();
			InputToWrite.append(input + "\n");
		}
		writeToFile(InputToWrite.toString(), "input.txt");

	}

	/**
	 * This method creates 2D String array with "*", and "." and creates String with required version
	 * @return String that is ready to write to
	 */
	public static String randomInputCreater() {
		// TODO Auto-generated constructor stub
		Random random = new Random();
		int x = random.nextInt(100);
		int y = random.nextInt(100);
		String[][] newArray = new String[x][y];
		StringBuilder InputToWrite = new StringBuilder();
		InputToWrite.append("" + x + " " + y + "\n");
		for (int i = 0; i < x; i++) {// row
			for (int j = 0; j < y; j++) {// column
				String data = random.nextInt(100) % 7 == 0 ? "*" : ".";
				newArray[i][j] = data;
				InputToWrite.append(data);
			}
			InputToWrite.append("\n");
		}
		return InputToWrite.toString();
	}

	/**
	 * This method writes the String to Output.txt
	 * @param theInput String input to write
	 * @param fileName String the file name to write to
	 * @throws FileNotFoundException in case file is not found
	 */
	public static void writeToFile(String theInput, String fileName) throws FileNotFoundException {
		PrintWriter out = new PrintWriter(fileName);
		out.print(theInput);
		out.close();
	}

}
