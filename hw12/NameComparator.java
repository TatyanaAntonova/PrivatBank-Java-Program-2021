import java.util.Comparator;

public class NameComparator implements Comparator <PhoneBook.Subscriber>{

    @Override
    public int compare(PhoneBook.Subscriber o1, PhoneBook.Subscriber o2) {
        return o1.name.compareTo(o2.name);
    }
}
