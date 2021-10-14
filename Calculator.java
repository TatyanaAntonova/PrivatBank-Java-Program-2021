package hw2;

import java.util.Scanner;

public class Calculator {

    private static String arithmeticResult(int operand1, int operand2, String sigh) {
        switch (sigh) {
            case "+":
                return "Result: " + (operand1 + operand2);
            case "-":
                return "Result: " + (operand1 - operand2);
            case "*":
                return "Result: " + operand1 * operand2;
            case "/":
                if (operand2 == 0) return "Arithmetic exception! Division by zero!";
                return "Result: " + operand1 / operand2;
            default:
                return "Something goes wrong!";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write operand1, please!");
        int operand1 = scanner.nextInt();

        System.out.println("Write sigh, please!");
        String sigh = scanner.next();

        System.out.println("Write operand2, please!");
        int operand2 = scanner.nextInt();

        System.out.println(arithmeticResult(operand1, operand2, sigh));
    }
}
