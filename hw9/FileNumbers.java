import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FileNumbers {
    private static final String FILE_NAME1 = "numbers.txt";
    private static final String FILE_NAME2 = "odd-numbers.txt";

    public static void createNumbersFile(String fileName) throws IOException {
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName), StandardCharsets.UTF_8)) {
            for (int i = 1; i < 100; i++) {
                if (i % 10 == 0) {
                    outputStreamWriter.write(i + " \n");
                } else if (i == 99) {
                    outputStreamWriter.write(i + "");
                } else {
                    outputStreamWriter.write(i + " ");
                }
            }
        }
    }

    public static void createOddNumbersFile(String fileName1, String fileName2) throws IOException {
        Scanner scan = null;
        StringBuilder stringForOddNumbersFile = new StringBuilder();

        try {
            scan = new Scanner(new FileInputStream(fileName1), "Cp1251");

            while (scan.hasNextLine()) {
                Pattern space = Pattern.compile(" ");
                String[] strings = space.split(scan.nextLine());

                for (int i = 0; i < strings.length; i++) {
                    int num;
                    try {
                        num = Integer.parseInt(strings[i]);
                    } catch (NumberFormatException numberFormatException) {
                        num = -1;
                    }

                    if (num % 2 == 0 && num > 0) {
                        stringForOddNumbersFile.append("0 ");
                    } else {
                        stringForOddNumbersFile.append(strings[i].trim() + " ");
                    }
                }
                stringForOddNumbersFile.append("\n");

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } finally {
            scan.close();
        }
        
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileName2), StandardCharsets.UTF_8)) {
            outputStreamWriter.write(stringForOddNumbersFile.substring(0, stringForOddNumbersFile.length() - 1));
        }
    }

    public static void main(String[] args) {
        try {
            createNumbersFile(FILE_NAME1);
            createOddNumbersFile(FILE_NAME1, FILE_NAME2);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
