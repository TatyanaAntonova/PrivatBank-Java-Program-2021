import java.util.Comparator;

public class DateOfBirthComparator implements Comparator<Subscriber> {
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
