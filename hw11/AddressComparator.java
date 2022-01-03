import java.util.Comparator;

public class AddressComparator implements Comparator<Subscriber> {
    @Override
    public int compare(Subscriber o1, Subscriber o2) {
        return o1.getAddress().compareTo(o2.getAddress());
    }
}
