package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import programs.MinesweeperMain;

/**
 * This class will test the results of the minesweeper program.
 * 
 * @author Eugene Oh
 * @version Winter 2020
 */

public class MinesweeperMainTest {
    
    final String[][] MINEFIELD_ARRAY_1X1_EXTENDED = stringToField ("..." 
            + "..." 
            + "...",
            1, 1, true);
      
    final String[][] NUMBER_FIELD_ARRAY_1X1 = new String[][] {{"0"}};      
    
    final String[][] MINEFIELD_ARRAY_4X4_EXTENDED = stringToField("......"
                                                                + ".*...."
                                                                + "......"
                                                                + "..*..."
                                                                + "......"
                                                                + "......", 
                                                                4, 4, true);
    
    final String[][] NUMBER_FIELD_ARRAY_4X4 = stringToField("*100"
                                                          + "2210"
                                                          + "1*10"
                                                          + "1110",
                                                          4, 4, false);
                                               
    final String[][] MINEFIELD_ARRAY_10X10_EXTENDED = stringToField ("............"
                                                                   + "..***.*..*.."
                                                                   + "...*..*.*..."
                                                                   + ".*....**...."
                                                                   + "...*........"
                                                                   + "......*.**.."
                                                                   + ".....*......"
                                                                   + "...**..*..*."
                                                                   + "....*....*.."
                                                                   + "..**.....**."
                                                                   + ".*...*......"
                                                                   + "............",
                                                                   10, 10, true);
                               
                                                        
    final String[][] NUMBER_FIELD_ARRAY_10X10 = stringToField ("1***3*32*1"
                                                             + "24*34*5*21"
                                                             + "*3222**210"
                                                             + "12*1234321"
                                                             + "01122*2**1"
                                                             + "0123*33332"
                                                             + "01**32*22*"
                                                             + "135*2113*4"
                                                             + "2**32102**"
                                                             + "*322*10122",
                                                             10, 10, false);                                    
    
    /**
     * Test method for a 1x1 minefield.
     */
    @Test
    public void createNumberFieldTest1x1() {
        String[][] numberField1x1Test = MinesweeperMain.createNumberField(MINEFIELD_ARRAY_1X1_EXTENDED, 1, 1);
        assertEquals(NUMBER_FIELD_ARRAY_1X1[0][0], numberField1x1Test[0][0]);
    }

    /**
     * Test method for a 4x4 minefield.
     */
    @Test
    public void createNumberFieldTest4x4() {
        String[][] numberField4x4Test = MinesweeperMain.createNumberField(MINEFIELD_ARRAY_4X4_EXTENDED, 4, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                assertEquals(NUMBER_FIELD_ARRAY_4X4[i][j], numberField4x4Test[i][j]);
            }
        }
    }
    
    /**
     * Test method for a 10x10 minefield.
     */
    @Test
    public void createNumberFieldTest10x10() {
        String[][] numberField4x4Test = MinesweeperMain.createNumberField(MINEFIELD_ARRAY_10X10_EXTENDED, 10, 10);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertEquals(NUMBER_FIELD_ARRAY_10X10[i][j], numberField4x4Test[i][j]);
            }
        }
    }

    /**
     * Converts the given string to a 2-D array representation for making it easier to create
     * inputs to compare against.
     * 
     * @param theField The given string representation of the field.
     * @param theHeight The height of the field.
     * @param theLength The length of the field.
     * @param extendedOrNot Creates a larger array of the given field if selected true. Otherwise
     * will create a normal array representation.
     * @return The 2-D array representation of the field.
     */
    private String[][] stringToField(String theField, int theHeight, int theLength, boolean extendedOrNot) {
        if (extendedOrNot == true) {
            theHeight = theHeight + 2;
            theLength = theLength + 2;
        }  
        String[][] field = new String[theHeight][theLength];
        int wordCounter = 0;
        for (int i = 0; i < theHeight; i++) {    
            for (int j = 0; j < theLength; j++) {
                field[i][j] = theField.substring(wordCounter, wordCounter + 1);
                wordCounter++;
            }
        }
        return field;
    }
}
