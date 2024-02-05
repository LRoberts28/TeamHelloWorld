package Game020524;
import java.util.ArrayList;
public class SimpleStartupGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;
        GameHelper helper = new GameHelper();

        Startup theStartup = new Startup();
        int randomNum = (int) (Math.random() * 5);

        ArrayList<Integer> locations = new ArrayList<Integer>();
        locations.add(randomNum);
        locations.add(randomNum + 1);
        locations.add(randomNum + 2);
        theStartup.setLocationCells(locations);
        boolean isAlive = true;

        while (isAlive) {
            int guess = helper.getUserInput("enter a number");
            String result = theStartup.checkYourself(guess);
            System.out.println(result);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            } // close if
        }  // close while
    }
}
