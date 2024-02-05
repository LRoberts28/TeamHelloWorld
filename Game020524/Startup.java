package Game020524;

import java.util.ArrayList;

public class Startup {
    private ArrayList<Integer> locationCells;
	public void setLocationCells(ArrayList<Integer> locs) {
		locationCells = locs;
	}
	public String checkYourself (int userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);
		if (index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) {
				result = "kill";
				} else {
				result = "hit";
			}
		}
		return result;
	}
}
