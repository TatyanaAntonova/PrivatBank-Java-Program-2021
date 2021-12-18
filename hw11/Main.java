import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws JsonProcessingException, FileNotFoundException {
        ArrayList<String> phoneList = new ArrayList<>();
        phoneList.add("555");
        phoneList.add("222");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addSubscriber(new Subscriber("Anna","Lviv", LocalDate.of(2000,01,25), phoneList));
        phoneBook.addSubscriber(new Subscriber("Felix","Odessa", LocalDate.of(1994,01,25), phoneList));

        phoneBook.createJson();
        phoneBook.parseJson("phoneBook.json");

        phoneBook.deleteSubscriberByField("address","Lviv");
        System.out.println(phoneBook);

        phoneBook.addSubscriber(new Subscriber("Roman","Dnepr", LocalDate.of(1989,01,01), phoneList));
        System.out.println(phoneBook.findSubscriberByField("name","Roman"));
    }
}
