package hw2;

import java.util.Scanner;

public class Interval {
    private static String getInterval(int input){
        if(input >= 0 && input <= 14){
            return "[0 - 14]";
        }
        if(input >= 15 && input <= 35){
            return "[15 - 35]";
        }
        if(input >= 36 && input <= 50){
            return "[36 - 50]";
        }
        if(input >= 51 && input <= 100){
            return "[51 - 100]";
        }
        return "The interval wasn't found!";
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer!");
        int input = scanner.nextInt();
        System.out.println(getInterval(input));
    }
}
