import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {
    private List<Subscriber> phoneBook = new ArrayList<>();
    private static final String FILE_NAME = "phoneBook.json";
    private Scanner scanner = new Scanner(System.in);


    public void addSubscriber() {
        String name;
        System.out.println("Write subscriber's name.");
        while (true) {
            name = scanner.nextLine();
            if (name.length() == 0) {
                System.out.println("Subscriber's name can't be null. Please, try again.");
            } else {
                break;
            }
        }

        System.out.println("Write subscriber's date of birth in format 1994-01-22.");
        int year = 0;
        int month = 0;
        int day = 0;
        while (true) {
            String dateOfBirth = scanner.nextLine();

            try {
                year = Integer.parseInt(dateOfBirth.substring(0, 4));
                month = Integer.parseInt(dateOfBirth.substring(5, 7));
                day = Integer.parseInt(dateOfBirth.substring(8, 10));
                break;
            } catch (Exception exception) {
                System.out.println("Your input has incorrect format. Please, try again.");
            }
        }

        String address;
        System.out.println("Write subscriber's address.");
        while (true) {
            address = scanner.nextLine();
            if (address.length() == 0) {
                System.out.println("Subscriber's address can't be null. Please, try again.");
            } else {
                break;
            }
        }

        System.out.println("Write subscriber's phone number.");
        ArrayList<String> phoneList = new ArrayList<>();
        String phoneNumber;
        while (true) {
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() > 0) {
                phoneList.add(phoneNumber);
                while (true) {
                    System.out.println("Do you need to add one more phone number? Write Yes or No.");
                    if (scanner.nextLine().equals("Yes")) {
                        System.out.println("Write subscriber's phone number.");
                        phoneList.add(scanner.nextLine());
                    } else {
                        break;
                    }
                }
                break;
            } else {
                System.out.println("Subscriber's phone number can't be null. Please, try again.");
            }
        }

        phoneBook.add(new Subscriber(name, LocalDate.of(year, month, day), address, phoneList));
        System.out.println("You add new subscriber successfully.");
    }

    public void deleteSubscriberByField(String field, String value) {
        for (int i = 0; i < phoneBook.size(); i++) {
            switch (field) {
                case "name":
                    if (phoneBook.get(i).getName().equals(value)) {
                        System.out.println(phoneBook.get(i));
                        phoneBook.remove(i);
                        System.out.println("Subscriber was deleted successfully.");
                    }
                    break;
                case "date of birth":
                    if (phoneBook.get(i).getDateOfBirth().equals(value)) {
                        System.out.println(phoneBook.get(i));
                        phoneBook.remove(i);
                        System.out.println("Subscriber was deleted successfully.");
                    }
                    break;
                case "address":
                    if (phoneBook.get(i).getAddress().equals(value)) {
                        System.out.println(phoneBook.get(i));
                        phoneBook.remove(i);
                        System.out.println("Subscriber was deleted successfully.");
                    }
                    break;
                case "phone number":
                    ArrayList<String> phoneList = phoneBook.get(i).getPhoneList();
                    for (int j = 0; j < phoneList.size(); j++) {
                        if (phoneList.get(j).equals(value)) {
                            System.out.println(phoneBook.get(i));
                            phoneBook.remove(i);
                            System.out.println("Subscriber was deleted successfully.");
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("There is no field " + field + ".");
                    break;
            }
        }
    }

    public Subscriber findSubscriberByField(String field, String value) {
        for (int i = 0; i < phoneBook.size(); i++) {
            switch (field) {
                case "name":
                    if (phoneBook.get(i).getName().equals(value)) {
                        return phoneBook.get(i);
                    }
                    break;
                case "date of birth":
                    if (phoneBook.get(i).getDateOfBirth().equals(value)) {
                        return phoneBook.get(i);
                    }
                    break;
                case "address":
                    if (phoneBook.get(i).getAddress().equals(value)) {
                        return phoneBook.get(i);
                    }
                    break;
                case "phone number":
                    ArrayList<String> phoneList = phoneBook.get(i).getPhoneList();
                    for (int j = 0; j < phoneList.size(); j++) {
                        if (phoneList.get(j).equals(value)) {
                            return phoneBook.get(i);
                        }
                    }
                    break;
                default:
                    System.out.println("There is no field " + field + ".");
                    break;
            }
        }
        System.out.println("Subscriber with " + field + " " + value + " wasn't found.");
        return null;
    }

    public String printWithSort(String field) {
        Comparator<Subscriber> comparator = null;

        switch (field) {
            case "name":
                comparator = new NameComparator();
                break;
            case "date of birth":
                comparator = new DateOfBirthComparator();
                break;
            case "address":
                comparator = new AddressComparator();
                break;
            default:
                return "There is no field " + field + ".";
        }

        phoneBook.sort(comparator);
        return phoneBook.toString();
    }

    public void editSubscriber(String field, String value, String fieldToChange, String newValue) {
        if (newValue.isEmpty()) {
            System.out.println("New field value is empty. Please, try again.");
            return;
        }

        Subscriber subscriber = findSubscriberByField(field, value);
        switch (fieldToChange) {
            case "name":
                subscriber.setName(newValue);
                break;
            case "date of birth":
                try {
                    int year = Integer.parseInt(newValue.substring(0, 4));
                    int month = Integer.parseInt(newValue.substring(5, 7));
                    int day = Integer.parseInt(newValue.substring(8, 10));
                    subscriber.setDateOfBirth(LocalDate.of(year, month, day));
                } catch (Exception exception) {
                    System.out.println("Your input has incorrect format. Please, try again.");
                }
                break;
            case "address":
                subscriber.setAddress(newValue);
                break;
            case "phone number":
                ArrayList<String> phoneList = new ArrayList<String>();
                phoneList.add(newValue);
                subscriber.setPhoneList(phoneList);
                break;
            default:
                System.out.println("There is no field " + field + ".");
                break;
        }
        System.out.println("Subscriber was edited successfully.");
    }

    public void writeToFile() throws JsonProcessingException {
        if (phoneBook.isEmpty()) {
            System.out.println("Phone book is empty");
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        String json = mapper.writeValueAsString(phoneBook);
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(FILE_NAME))) {
            outputStreamWriter.write(json);
            System.out.println("Phonebook was written to file successfully.");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void downloadFromFile() throws IOException {
        StringBuilder parseJson = new StringBuilder();
        Scanner scan = new Scanner(new FileInputStream(FILE_NAME));
        while (scan.hasNext()) {
            parseJson.append(scan.nextLine());
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);
        phoneBook = mapper.readValue(parseJson.toString(), new TypeReference<List<Subscriber>>() {
        });

        if (phoneBook.isEmpty()) {
            System.out.println("File is empty.");
        } else {
            System.out.println("Phonebook was downloaded from file successfully.");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PhoneBook{\n");
        for (int i = 0; i < phoneBook.size(); i++) {
            stringBuilder.append((i + 1) + " " + phoneBook.get(i) + "\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
