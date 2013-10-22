import java.util.ArrayList;

public class SimpleDotComTestDriver {
	
	public static void main (String [] args) {
		
		SimpleDotCom dot = new SimpleDotCom();
		
		ArrayList<String> locations = new ArrayList<String>();
		locations.add("2");
		locations.add("3");
		locations.add("4");
		dot.setLocationCells(locations);
		
		String userGuess = "3";
		String result = dot.checkYourself(userGuess);
		userGuess = "4";
		result = dot.checkYourself(userGuess);
		userGuess = "2";
		result = dot.checkYourself(userGuess);
		String testResult = "failed";
		
		if (result.equals("kill")) {
			testResult = "passed";
		}
		
		System.out.println(testResult);
		
	}
}