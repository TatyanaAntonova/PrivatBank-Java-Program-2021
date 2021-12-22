import java.util.Comparator;

public class AddressComparator implements Comparator<PhoneBook.Subscriber> {
    @Override
    public int compare(PhoneBook.Subscriber o1, PhoneBook.Subscriber o2) {
        return o1.address.compareTo(o2.address);
    }
}
