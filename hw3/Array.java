import java.util.Scanner;

public class Array {

    private static boolean isDigit(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException uncheckedException) {
        }
        System.out.println("Your input doesn't meet the conditions! Please, try again!");
        return false;
    }

    private static String arrayToString(int[] array) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i : array) {
            stringBuilder.append(i + ", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        int sum = 0;
        int numberOfPositiveNumbers = 0;

        System.out.println("Enter 10 integer numbers!");

        for (int i = 0; i < array.length; i++) {
            String input = scanner.nextLine();
            if(isDigit(input)){
                array[i] = Integer.parseInt(input);
                sum += array[i];
                if (array[i] > 0) numberOfPositiveNumbers++;
            } else {
                i--;
            }
        }

        System.out.println("Your array is: " + arrayToString(array));
        System.out.println("Sum is: " + sum);
        System.out.println("Number of positive numbers is: " + numberOfPositiveNumbers);

        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Your sorted array is: " + arrayToString(array));
    }
}
