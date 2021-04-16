package minesweeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class test {


	public static void main(String[] args) throws IOException {
		if (args.length != 0) {
			// Ready to write to a file
		} else {
			// Ready to write to a file
		}
		minesweeper mine = new minesweeper();
		//System.out.println(mine.readFromFile("input.txt").toString());
		//System.out.println(Arrays.deepToString(mine.readFromFile("input.txt")));
		mine.execute("input.txt");
	}

}
