import java.util.Random;
import java.util.Scanner;

public class Bingo {

    private static boolean quitTheGame(String input) {
        if (input.equals("Q")) {
            System.out.println("Game over!");
            return true;
        }
        return false;
    }

    private static boolean inputMeetsTheConditions(String input) {
        try {
            if (Integer.parseInt(input) >= 0 && Integer.parseInt(input) <= 100) return true;
        } catch (NumberFormatException uncheckedException) {
        }
        System.out.println("Your input doesn't meet the conditions! Please, try again!");
        return false;
    }

    private static boolean inputEqualsRandom(int randomNumber, int input) {
        if (randomNumber == input) {
            System.out.println("You guessed the number " + randomNumber + "!\nCongrats!");
            return true;
        }

        if (randomNumber > input) {
            System.out.println("Your number is less then randomNumber");
        } else {
            System.out.println("Your number is bigger then randomNumber");
        }
        return false;
    }
    
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(101);

        System.out.println("Guess number from 0 till 100!\nIf you want to quit enter \"Q\"!");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int countAttempts = 1;

        while (!quitTheGame(input)){
            if(inputMeetsTheConditions(input)){
                if (inputEqualsRandom(randomNumber, Integer.parseInt(input))) {
                    System.out.println("You had " + countAttempts + " attempts!");
                    break;
                }
            }
            input = scanner.nextLine();
            countAttempts++;
        }
    }
}
