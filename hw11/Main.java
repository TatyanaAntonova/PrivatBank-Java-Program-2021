import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        String menu = "What would you like to do? Choose number!\n" +
                "1. Add new subscriber.\n" +
                "2. Delete subscriber.\n" +
                "3. Find subscriber.\n" +
                "4. Print phonebook with sort.\n" +
                "5. Edit subscriber.\n" +
                "6. Write phonebook to file.\n" +
                "7. Download from file.\n" +
                "8. Exit.";
        System.out.println(menu);

        while (true) {
            switch (scanner.nextLine()) {
                case "1":
                    phoneBook.addSubscriber();
                    System.out.println("What would you like to do next? Choose number.");
                    break;
                case "2":
                    System.out.println("Write field to delete subscriber: name, date of birth, address, phone number.");
                    String field = scanner.nextLine();
                    System.out.println("Write field value to delete.");
                    phoneBook.deleteSubscriberByField(field, scanner.nextLine());
                    System.out.println("What would you like to do next? Choose number.");
                    break;
                case "3":
                    System.out.println("Write field to find subscriber: name, date of birth, address, phone number.");
                    field = scanner.nextLine();
                    System.out.println("Write field value to delete.");
                    System.out.println(phoneBook.findSubscriberByField(field, scanner.nextLine()));
                    System.out.println("What would you like to do next? Choose number.");
                    break;
                case "4":
                    System.out.println("Write field to sort phone book: name, date of birth, address");
                    System.out.println(phoneBook.printWithSort(scanner.nextLine()));
                    System.out.println("What would you like to do next? Choose number.");
                    break;
                case "5":
                    System.out.println("Write field to find subscriber: name, date of birth, address, phone number.");
                    field = scanner.nextLine();
                    System.out.println("Write field value to delete.");
                    String value = scanner.nextLine();
                    System.out.println("Write field that you want to change.");
                    String fieldToChange = scanner.nextLine();
                    System.out.println("Write new value.");
                    phoneBook.editSubscriber(field, value, fieldToChange, scanner.nextLine());
                    System.out.println("What would you like to do next? Choose number.");
                    break;
                case "6":
                    phoneBook.writeToFile();
                    System.out.println("What would you like to do next? Choose number.");
                    break;
                case "7":
                    phoneBook.downloadFromFile();
                    System.out.println("What would you like to do next? Choose number.");
                    break;
                case "8":
                    System.out.println("Good bye!");
                    return;
                default:
                    System.out.println("Choose number from the list above.");
                    break;
            }
        }
    }
}
