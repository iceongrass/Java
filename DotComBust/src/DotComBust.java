import java.util.*;

public class DotComBust {
	public static void main(String [] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	} // end main()

	private	GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
	private int numberOfGuesses = 0;
		
	// Create and initialize DotComs
	private void setUpGame() {
		// Create three DotComs
		DotCom one = new DotCom();
		DotCom two = new DotCom();
		DotCom three = new DotCom();
		// Set name to DotComs
		one.setName("github.com");
		two.setName("sina.com");
		three.setName("weibo.com");
		// Add into dotComList
		dotComList.add(one);
		dotComList.add(two);
		dotComList.add(three);
		
		// Set location for each DotCom
		for (DotCom tmp: dotComList) {
			tmp.setLocationCells(helper.placeDotCom(3));
		} // end for
	} // end setUpGame()
	
	// Start playing game and ask user to input the number
	private void startPlaying() {
		while(!dotComList.isEmpty()) {
			String userInput = helper.getUserInput("Enter a guess:");
			
			checkUserGuess(userInput);
		} // end while
		
		finishGame();
	} // end startPlaying()
	
	// Check the result of user guess
	private void checkUserGuess (String userInput) {
		numberOfGuesses++;
		String result = "miss";
		
		for (DotCom temp: dotComList) {
			result = temp.checkYourself(userInput);
			
			if (result.equals("hit")) {
				break;
			} // end if
			
			if (result.equals("kill")) {
				dotComList.remove(temp);
				break;
			} // end if
		} // end for
		
		System.out.println(result);
	} // end checkUserGuess()
	
	// Send a message to print the user's performance, based on how many 
	// guesses it took to sink all of the DotComs
	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless");
		if (numberOfGuesses < 15) {
			System.out.println("Congratulations! \nYou win the game by only" 
					+ numberOfGuesses + " steps!");
		} else {
			System.out.println("Game over! \nYou took too many (" 
					+ numberOfGuesses + ") to kill the DotComs...");
		} // end if
	} // end finishGame()
} //end class