import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class PhoneBook {
    private List<Subscriber> phoneBook = new ArrayList<>();
    final String fileName = "phoneBook.txt";

    protected class Subscriber implements Comparable<Subscriber> {
        Calendar calendar = new GregorianCalendar();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String name;
        String address;
        LocalDate dateOfBirth;
        ArrayList<String> phoneList;
        String updateDate;

        Subscriber(String name, String address, LocalDate dateOfBirth, ArrayList<String> phoneList) {
            this.name = name;
            this.address = address;
            this.dateOfBirth = dateOfBirth;
            this.phoneList = phoneList;
            updateDate = dateFormat.format(calendar.getTime());
        }

        Subscriber(String name, String address, LocalDate dateOfBirth) {
            this.name = name;
            this.address = address;
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public int compareTo(Subscriber o) {
            if (o == null) throw new NullPointerException();

            if (o.name.equals(this.name) && o.address.equals(this.address) && o.dateOfBirth.compareTo(this.dateOfBirth) == 0) {
                return 0;
            }

            return -1;
        }

        @Override
        public String toString() {
            return "Subscriber{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", updateDate='" + updateDate + '\'' +
                    ", phoneList='" + phoneList + '\'' +
                    '}';
        }
    }

    public List<Subscriber> getPhoneBook() {
        return phoneBook;
    }

    public List<Subscriber> getSortedPhoneBook(String field) {
        Comparator<Subscriber> comparator = null;
        if (field.equals("name")) {
            comparator = new NameComparator();
        } else if (field.equals("address")) {
            comparator = new AddressComparator();
        } else if (field.equals("dateOfBirth")) {
            comparator = new DateOfBirthComparator();
        } else {
            comparator = new NameComparator().thenComparing(new DateOfBirthComparator());
        }

        phoneBook.sort(comparator);
        return phoneBook;
    }

    public synchronized void addSubscriber(String name, String address, LocalDate dateOfBirth, ArrayList<String> phoneList) {
        for (Subscriber s : phoneBook) {
            if (s.compareTo(new Subscriber(name, address, dateOfBirth)) == 0) return;
        }

        phoneBook.add(new Subscriber(name, address, dateOfBirth, phoneList));
    }

    public synchronized void deleteSubscriberByName(String name) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (name.equals(phoneBook.get(i).name)) {
                phoneBook.remove(i);
            }
        }
    }

    public synchronized void deleteSubscriber(String name, String address, LocalDate dateOfBirth) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).compareTo(new Subscriber(name, address, dateOfBirth)) == 0) {
                phoneBook.remove(i);
            }
        }
    }

    public Subscriber findSubscriber(String name, String address, LocalDate dateOfBirth) {
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).compareTo(new Subscriber(name, address, dateOfBirth)) == 0) {
                return phoneBook.get(i);
            }
        }

        return null;
    }

    public synchronized void editSubscriberByNameAddress(String name, String address, LocalDate dateOfBirth, String field, String value) {
        if (field.equals("name")) {
            findSubscriber(name, address, dateOfBirth).name = value;
        } else if (field.equals("address")) {
            findSubscriber(name, address, dateOfBirth).address = value;
        }
    }

    public void editSubscriberDateOfBirth(String name, String address, LocalDate dateOfBirth, LocalDate newDateOfBirth) {
        findSubscriber(name, address, dateOfBirth).dateOfBirth = dateOfBirth;
    }

    public synchronized void writeToFile() {
        File file = new File(fileName);
        FileWriter writer = null;

        try {
            file.createNewFile();
            writer = new FileWriter(file);
            writer.write(phoneBook.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile() {
        FileReader fileReaderRun = null;

        try {
            fileReaderRun = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        final BufferedReader bufferedReaderRun = new BufferedReader(fileReaderRun);

        final StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        long currentTime;

        {
            try {
                line = bufferedReaderRun.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return line;
    }
}

