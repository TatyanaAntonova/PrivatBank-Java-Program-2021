import java.util.Comparator;

public class NameComparator implements Comparator <Subscriber>{

    @Override
    public int compare(Subscriber o1, Subscriber o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
