import java.util.*;

public class DotCom {
	private	String name;
	private ArrayList<String> locationCells;
	
	public void setName (String nameOfDotCom) {
			name = nameOfDotCom;
		}
	
	public void setLocationCells (ArrayList<String> locations) {
			locationCells = locations;
		}
		
	public String checkYourself (String userInput) {
			String result = "miss";
			int index = locationCells.indexOf(userInput);
			
			if (index >= 0) {
				locationCells.remove(index);
				
				if (locationCells.isEmpty()) {
					result = "kill";
					System.out.println("Ouch! You sunk " + name + "   :(  ");
				} else {
					result = "hit";
				} // end if
			} // end if
			
			return result;
	} // end checkYourself()
} // end class