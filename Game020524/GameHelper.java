package Game020524;

import java.util.Scanner;

public class GameHelper {
    private Scanner scanner;
    public int getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    public void closeScanner()
    {
        System.out.print("End game");
        scanner.close();
    }
}