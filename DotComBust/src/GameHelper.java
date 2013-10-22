import java.io.*;
import java.util.ArrayList;

public class GameHelper {
	//private	String userInput;
	private int gridLength = 7;
	private int gridSize = gridLength * gridLength;
	private int comCount = 0;
	private int [] grid = new int[gridSize];
	private static final String alphabet = "abcdefg";
	
	public ArrayList<String> placeDotCom (int comSize) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		String [] alphacoords = new String [comSize];
		String temp = null;
		int [] coords = new int[comSize];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		
		comCount++;
		int incr = 1;
		if((comSize % 2) == 1) {
			incr = gridLength;
		}
		
		while (!success & attempts++ < 200) {
			location = (int) (Math.random() * gridSize);
			
			int x = 0;
			success = true;
			while (success && x < comSize) {
				if (grid[location] == 0) {
					coords[x++] = location;
					location += incr;
					if ( location >= gridSize) {
						success = false;
					}
					if (x > 0 && (location % gridSize) == 0) {
						success = false;
					}
				} else {
					success = false;
				} // end if
			} // end while
		} // end while
		
		int x = 0;
		int row = 0;
		int colum = 0;
		
		while (x < comSize) {
			grid[coords[x]] = 1;
			row = (int) (coords[x] / gridLength);
			colum = coords[x] % gridLength;
			temp = String.valueOf(alphabet.charAt(colum));
			
			alphaCells.add(temp.concat(Integer.toString(row)));
			x++;
		}
		
		return alphaCells;
	}
	
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.println(prompt + "  ");
		
		try{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) 
				return null;
		} catch (IOException e) {
			System.out.println("IOException: " + e);
		} // end try
		
		return inputLine;
	}
}