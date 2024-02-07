package StartupGame020324;

import java.util.Scanner;

public class GameHelper {       //Used for misc fuctions for the game to run
    private Scanner scanner;
    public int getUserInput(String prompt) {       //uses scanner to get user guesses for the game 
        System.out.print(prompt + ": ");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void closeScanner()      //closes scanner, used after game is complete so there are no potential errors
    {
        System.out.print("End game");
        scanner.close();
    }
}