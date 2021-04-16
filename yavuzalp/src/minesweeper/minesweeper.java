package minesweeper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class creates minesweeper with number from the input with "." and "*" and prints the  minefield with numbers.
 * 
 * @author Yavuzalp Turkoglu
 * @version Spring 2021
 */
public class minesweeper {

	public static void main(String[] args) throws IOException {
		execute("input.txt");
	}

	/**
	 * This is the main method that does everything.
	 * 
	 * @param fileName it takes input file name for test purposes
	 * @throws FileNotFoundException in case file is not found
	 */
	public static void execute(String fileName) throws FileNotFoundException {
		StringBuilder OutputToWrite = new StringBuilder();
		int count = 1;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			OutputToWrite.append(String.format("\nField #%s:\n", count++));
			String[][] newArray = readOneTable(sc);
			OutputToWrite.append(calculate(newArray) + "\n");
		}
		sc.close();
		System.out.println(OutputToWrite.toString());
		PrintWriter out = new PrintWriter("output.txt");
		out.print(OutputToWrite.toString());
		out.close();
	}

	/**
	 * This method finds the file with input name. This method is for test purposes.
	 * 
	 * @param fileName Name of the file to look for
	 * @return File that input is in
	 */
	public static File getFile(String fileName) {
		File file;
		if (new File(fileName).exists()) {
			file = new File(fileName);
		} else if (new File(".././" + fileName).exists()) {
			file = new File(".././" + fileName);
		} else if (new File("../" + fileName).exists()) {
			file = new File("../" + fileName);
		} else if (new File("./" + fileName).exists()) {
			file = new File("./" + fileName);
		} else {
			file = new File("./src/input.txt");
		}

		return file;
	}

	/**
	 * Reads one minefield from scanner to an 2D array.
	 * 
	 * @param sc takes scanner as input
	 * @return 2D array with "." and "*".
	 */
	public static String[][] readOneTable(Scanner sc) {
		while (!sc.hasNextInt() && sc.hasNextLine()) {
			sc.next();
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		String[][] newArray = new String[x + 2][y + 2];
		for (int j = 0; j < y + 2; j++) {// column
			newArray[0][j] = ".";
			newArray[x + 1][j] = ".";
		}
		sc.nextLine();
		for (int i = 1; i < x + 1; i++) {// row
			newArray[i][0] = ".";
			String line = sc.next();
			for (int j = 0; j < y; j++) {// column
				newArray[i][j + 1] = "" + line.charAt(j);
			}
			newArray[i][y + 1] = ".";
			sc.nextLine();
		}

		return newArray;
	}

	/**
	 * This method makes the calculations to find the numbers for numberfield.
	 * 
	 * @param arr 2D array of minefield
	 * @return String ready to print and write to a file
	 */
	public static String calculate(String[][] arr) {
		StringBuilder result = new StringBuilder();
		int lengthOne = arr.length;
		int lengthTwo = arr[0].length;
		for (int i = 1; i < lengthOne - 1; i++) {
			for (int j = 1; j < lengthTwo - 2; j++) {// column//row
				int count = 0;
				if (arr[i][j].compareTo(".") == 0) {
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							if (arr[i - 1 + k][j - 1 + l].compareTo("*") == 0) {
								count++;
							}
						}
					}
					result.append(count);
				} else {
					result.append("*");
				}
			}
			result.append("\n");
		}
		return result.toString();
	}

}
