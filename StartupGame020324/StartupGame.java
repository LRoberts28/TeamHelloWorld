package StartupGame020324;

import java.util.ArrayList;

public class StartupGame {
    public static void main(String[] args) { // main method for the startup game
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

        while (isAlive) { // runs what actually is shown to the player. It has the asthetic stuff and the
                          // ending statement.
            int guess = helper.getUserInput("enter a number");
            String result = theStartup.checkYourself(guess);
            System.out.println(result);
            numOfGuesses++;
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numOfGuesses + " guesses");
            } // close if
        } // close while
        helper.closeScanner();
    }
}
