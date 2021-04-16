package programs;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This class will create number fields based off given minefields.
 * 
 * @author Eugene Oh
 * @version Winter 2020
 */

public class MinesweeperMain {
    
    /**
     * Retrieves the file and sets up scanners to retrieve the minefield from the file 
     * and runs the overall program.
     * 
     * @throws FileNotFoundException Will be thrown if the compiler cannot find the file.
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Retrieves input from the file.
        Scanner lineScan = new Scanner(System.in);
        Scanner numberScan = new Scanner(lineScan.nextLine());
        int height = numberScan.nextInt();
        int length = numberScan.nextInt();
        int fieldNumber = 1;
        while (length != 0 || height != 0) {
            // Creates a bigger, blank minefield.
            final String[][] blankMinefield = new String[height + 2][length + 2];
            for (String[] row : blankMinefield) {
                Arrays.fill(row, ".");
            }
            // Places the minefield from the file into the blank minefield.
            final String[][] originalMinefield = createMinefield(blankMinefield, lineScan, 
                                                                 height, length);
            String[][] numberField = createNumberField(originalMinefield, height, length); 
            // Prints the number field.
            print(numberField, height, length, fieldNumber);
            // Gets numbers from next field in the file.
            if (lineScan.hasNextLine()) {
                numberScan = new Scanner(lineScan.nextLine());
                height = numberScan.nextInt();
                length = numberScan.nextInt();
                fieldNumber++;
            } else {
                height = 0;
                length = 0;
            }
        }
    }   
    
    /**
     * Places the minefield into the larger blank minefield.
     * 
     * @param theBlankMinefield The larger field that the mines will go into.
     * @param theLineScanner Scans the text file in order to place the mines into the larger field.
     * @param theHeight The height of the minefield.
     * @param theLength The length of the minefield.
     * @return The larger minefield with the original minefield in place.
     */
    public static String[][] createMinefield (final String[][] theBlankMinefield, 
                                              final Scanner theLineScanner,
                                              final int theHeight, final int theLength) {
        String[][] minefield = theBlankMinefield;
        for (int i = 1; i < theHeight + 1; i++) {
            String line = theLineScanner.nextLine();
            for (int j = 1; j < theBlankMinefield[i].length - 1; j++) {
                theBlankMinefield[i][j] = line.substring(j - 1, j);   
            }
        }
        return minefield;
    }
    
    /**
     * Creates the number field based on a given minefield.
     * 
     * @param theOriginalMinefield The field to use to calculate the number field.
     * @param theHeight Height of the minefield.
     * @param theLength Length of the minefield.
     * @return The number field.
     */
    public static String[][] createNumberField(final String[][] theMinefield, 
                                               final int theHeight, final int theLength) {
        String[][] numberField = new String[theHeight][theLength];
        for (int i = 0; i < theHeight; i++) {    
            for (int j = 0; j < theMinefield[i].length - 2; j++) {
                int mineCounter = 0;
                // Checks if the current entry is a mine.
                if (theMinefield[i + 1][j + 1].equals("*")) {
                    numberField[i][j] = "*";
                // If not, we check for surrounding mines.
                } else {
                    for (int checkY = i; checkY <= i + 2; checkY++) {
                        for (int checkX = j; checkX <= j + 2; checkX++) {
                            if (theMinefield[checkY][checkX].equals("*")) {
                                mineCounter++;
                            }
                        }
                    }
                    // The entry of the number field becomes the number of mines surrounding it.
                    numberField[i][j] = String.valueOf(mineCounter);
                }
            }
        }
        return numberField;
    }
    
    /**
     * Prints the given field to the console and to a text file.
     * 
     * @param theOriginalMinefield The 2-D array representation of the field.
     * @param theHeight Height of the field.
     * @param theLength Length of the field.
     * @param theFieldNumber Represents which field is being printed out.
     */
    public static void print(final String[][] theField, final int theHeight,
                             final int theLength, final int theFieldNumber) {
        System.out.println("Field #" + theFieldNumber + ": ");
        for (int i = 0; i < theHeight; i++) {    
            for (int j = 0; j < theField[i].length; j++) {
                System.out.print(theField[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
