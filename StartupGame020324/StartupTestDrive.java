package StartupGame020324;
import java.util.ArrayList;


public class StartupTestDrive {       //Tester method for startup game
    public static void main(String[] args) {
        Startup dot = new Startup();
        
        ArrayList<Integer> locations = new ArrayList<Integer>();
        locations.add(2);
        locations.add(4);
        locations.add(9);

        dot.setLocationCells(locations);
        int userGuess = 2;
        String result = dot.checkYourself(userGuess);
        String testResult = "failed";
        if (result.equals("hit")) {
            testResult = "passed";
        }
        System.out.println(testResult);
    }
}
