package programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

/**
 * This class will create a minesweeper field based on user inputs.
 * 
 * @author Eugene Oh
 * @version Winter 2020
 */

public class MinesweeperInputGenerator {
    
    /**
     * Asks for the height and length for the minefield and runs the overall program.
     * 
     * @throws FileNotFoundException Will be thrown if the compiler cannot find the file.
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner console = new Scanner(System.in);
        
        // Asks for input
        System.out.print("Please enter the height for the minefield (1 - 100): ");
        final int height = console.nextInt();
        System.out.print("Please enter the length for the minefield (1 - 100): ");
        final int length = console.nextInt();
        System.out.print("What probability do you want each element to be a mine? (0 - 100): ");
        final int percentOfMines = console.nextInt();
        System.out.print("What do you want the name of the output text file to be?: ");
        final String fileName = console.next();
        
        // Creates the minefield and prints it.
        final String[][] minefield = createMinefield(height, length, percentOfMines);
        print(minefield, height, length, fileName);
        console.close();
    }
    
    /**
     * Creates the minefield.
     * 
     * @param theHeight Height of the minefield
     * @param theLength Length of the minefield
     * @param percentOfMines The percentage of mines in the minefield.
     * @return A completed 2-D array representing the minefield.
     */
    public static String[][] createMinefield (final int theHeight, final int theLength, 
                                              final int percentOfMines) {
        String[][] minefield = new String[theHeight][theLength];
        for (int i = 0; i < theHeight; i++) {    
            for (int j = 0; j < minefield[i].length; j++) {
                final Random rand = new Random();
                if (rand.nextInt(100) + 1 <= percentOfMines) {
                    minefield[i][j] = "*";  
                } else {
                    minefield[i][j] = "."; 
                }                
            }
        }
        return minefield;
    }
    
    /**
     * Prints the minefield to a text file.
     * 
     * @throws FileNotFoundException Will be thrown if the compiler cannot find the file.
     * @param theMinefield The 2-D array representation of the minefield.
     * @param theHeight Height of the minefield
     * @param theLength Length of the minefield
     * @param theFileName The name of the output file.
     */
    public static void print(final String[][] theMinefield, final int theHeight, final 
                             int theLength, final String theFilename) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File(theFilename));
        out.println(theHeight + " " + theLength);
        for (int i = 0; i < theHeight; i++) {    
            for (int j = 0; j < theMinefield[i].length; j++) {
                out.print(theMinefield[i][j]);
            }
            out.println();
        }
        System.out.println("");
        System.out.println("The minefield has been created and placed in a txt file!");
    }
}
