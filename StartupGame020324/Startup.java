package StartupGame020324;

import java.util.ArrayList;

public class Startup {		
    private ArrayList<Integer> locationCells;

	public void setLocationCells(ArrayList<Integer> locs) {
		locationCells = locs;
	}
	public String checkYourself (int userInput) {		//method checks if the guess was a hit or a miss
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) {		//if it is a hit, is every startup dead?
				result = "kill";
				} else {
				result = "hit";
			}
		}
		return result;
	}
}
