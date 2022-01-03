import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class Subscriber implements Comparable<Subscriber> {
    private Calendar calendar = new GregorianCalendar();
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private String name;
    private String address;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    private ArrayList<String> phoneList;
    private String updateDate;

    Subscriber() {
    }

    Subscriber(String name, LocalDate dateOfBirth, String address, ArrayList<String> phoneList) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        updateDate = dateFormat.format(calendar.getTime());
        this.phoneList = phoneList;
    }

    void setPhoneList(ArrayList<String> phoneList) {
        this.phoneList = phoneList;
        updateDate = dateFormat.format(calendar.getTime());
    }

    public ArrayList<String> getPhoneList() {
        return phoneList;
    }

    void setAddress(String address) {
        this.address = address;
        updateDate = dateFormat.format(calendar.getTime());
    }

    public String getAddress() {
        return address;
    }

    void setName(String name) {
        this.name = name;
        updateDate = dateFormat.format(calendar.getTime());
    }

    public String getName() {
        return name;
    }

    void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        updateDate = dateFormat.format(calendar.getTime());
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getUpdateDate() {
        return updateDate;
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
                "name=" + name +
                ", address=" + address +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneList=" + phoneList +
                ", updateDate=" + updateDate +
                '}';
    }


}
