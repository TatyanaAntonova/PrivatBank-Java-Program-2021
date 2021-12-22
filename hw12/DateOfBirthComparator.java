import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<PhoneBook.Subscriber> {
    @Override
    public int compare(PhoneBook.Subscriber o1, PhoneBook.Subscriber o2) {
        return o1.dateOfBirth.compareTo(o2.dateOfBirth);
    }
}
