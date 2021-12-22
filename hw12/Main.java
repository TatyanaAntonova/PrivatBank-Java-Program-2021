import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static PhoneBook phoneBook = new PhoneBook();
    private static List<Runnable> threadList = new ArrayList<>();
    private static ArrayList<String> phoneList = new ArrayList<>();

    public static void main(String[] args) {
        phoneList.add("555");
        phoneList.add("444");

        //addSubscriber check
        phoneBook.addSubscriber("Helga", "Odessa", LocalDate.of(2000, 02, 12), phoneList);
        phoneBook.addSubscriber("Alex", "Odessa", LocalDate.of(1994, 05, 01), phoneList);
        phoneBook.addSubscriber("Feliks", "Lvov", LocalDate.of(1998, 12, 24), phoneList);
        phoneBook.addSubscriber("Kristina", "Odessa", LocalDate.of(1994, 01, 01), phoneList);

        //editSubscriber
        phoneBook.editSubscriberByNameAddress("Feliks", "Lvov", LocalDate.of(1998, 12, 24), "name", "Felix");

        //deleteSubscriber check
        phoneBook.deleteSubscriberByName("Helga");
        phoneBook.deleteSubscriber("Kristina", "Odessa", LocalDate.of(1994, 01, 01));

        //findSubscriber check
        System.out.println(phoneBook.findSubscriber("Felix", "Lvov", LocalDate.of(1998, 12, 24)));

        //Threads
        createThreads();
        System.out.println("Main thread started...");
        for (int i = 0; i < threadList.size(); i++) {
            threadList.get(i).run();
        }
        System.out.println("Main thread finished...");

        //phoneBook.compare();
        System.out.println(phoneBook.getSortedPhoneBook("name"));
        System.out.println(phoneBook.getSortedPhoneBook(""));

        phoneBook.writeToFile();
        System.out.println(phoneBook.readFile());

    }

    private static void createThreads() {
        String[] namesArray = new String[5];
        String[] addressArray = new String[5];
        namesArray[0] = "Victoria";
        addressArray[0] = "Odessa";
        namesArray[1] = "Victor";
        addressArray[1] = "Odessa";
        namesArray[2] = "Max";
        addressArray[2] = "Kharkiv";
        namesArray[3] = "Yevhen";
        addressArray[3] = "Kharkiv";
        namesArray[4] = "Alex";
        addressArray[4] = "Kyiv";

        for (int i = 0; i < 5; i++) {
            int finalI = i;

            Runnable runnable = () -> {
                //System.out.println(finalI + " thread started");
                phoneBook.addSubscriber(namesArray[finalI], addressArray[finalI], LocalDate.of(1950, 05, 05), phoneList);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };

            threadList.add(runnable);
        }
    }
}
