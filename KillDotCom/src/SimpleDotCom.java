import java.util.ArrayList;
import java.lang.String;

public class SimpleDotCom {
	
	private
		
		ArrayList<String> locationCells;
		//int [] locationCells;
		//int numOfHits = 0;
		
	public
		
		void setLocationCells( ArrayList<String> locations){		
			locationCells = locations;			
		}
	
		String checkYourself(String userInput){	
			
			String result = "miss";	
			
			int index = locationCells.indexOf(userInput);
			
			if (index >= 0) {
				locationCells.remove(index);
				
				if(locationCells.isEmpty()) {
					result = "kill";
				} else {
					result = "hit";
				}
			}
			/*
			 * for ( cell:locationCells) {

				if (guess == cell) {
					result = "hit";
					numOfHits++;
					break;					
				} // end if
			} // end for
					
			if (numOfHits == locationCells.length()) {
				result = "kill";				
			} // end if
			*/
			System.out.println(result);
			
			return result;
		} // end checkYourself
}

