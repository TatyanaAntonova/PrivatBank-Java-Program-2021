package hw4;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CapitalLetter {
    private static String toUpperCase(String input) {
        StringBuilder output = new StringBuilder();

        Pattern patternForLines = Pattern.compile("\n");
        String[] lineList = patternForLines.split(input);

        Pattern patternForWord = Pattern.compile(" ");

        for(int i = 0; i < lineList.length; i++){
            String[] wordList = patternForWord.split(lineList[i]);

            for (int j = 0; j < wordList.length; j++){
                output.append(wordList[j].substring(0,1).toUpperCase() + wordList[j].substring(1) + " ");
            }
            output.append("\n");
        }

        return output.substring(0, output.length() - 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String, please!");
        System.out.println(toUpperCase(scanner.nextLine()));
    }
}
