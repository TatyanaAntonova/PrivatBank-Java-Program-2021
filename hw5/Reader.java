import java.util.ArrayList;
import java.util.List;

public class Reader {
    private final String READER_NAME;
    private final int NUMBER_OF_LIBRARY_CARD;
    private final String DATE_OF_BIRTH;
    private final String GENDER;
    private String faculty;
    private String phoneNumber;
    private List<Book> readerBookList = new ArrayList<>();

    public Reader(String readerName, int numberOfLibraryCard, String dateOfBirth, String gender, String faculty, String phoneNumber) {
        READER_NAME = readerName;
        NUMBER_OF_LIBRARY_CARD = numberOfLibraryCard;
        DATE_OF_BIRTH = dateOfBirth;
        GENDER = gender;
        this.faculty = faculty;
        this.phoneNumber = phoneNumber;
    }

    public String getReaderInfo(){
        return READER_NAME + " " + DATE_OF_BIRTH + " " + phoneNumber;
    }

    public void takeBook(int countOfTakenBooks) {
        String book = "";
        if (countOfTakenBooks % 10 == 1) {
            book = "книгу";
        } else if (countOfTakenBooks % 10 > 1 && countOfTakenBooks % 10 < 5) {
            book = "книги";
        } else {
            book = "книг";
        }

        String verb = "";
        if (GENDER.equalsIgnoreCase("male")) {
            verb = "взял";
        } else {
            verb = "взяла";
        }

        String space = " ";

        System.out.println(READER_NAME + space + verb + space + countOfTakenBooks + space + book + ".");
    }

    public void takeBook(String bookList) {
        String verb = "";
        if (GENDER.equalsIgnoreCase("male")) {
            verb = "взял книги:";
        } else {
            verb = "взяла книги:";
        }

        String space = " ";

        System.out.println(READER_NAME + space + verb + space + bookList + ".");
    }

    public void takeBook(List<Book> bookList) {
        readerBookList = bookList;

        String verb = "";
        if (GENDER.equalsIgnoreCase("male")) {
            verb = "взял книги:";
        } else {
            verb = "взяла книги:";
        }

        String space = " ";

        StringBuilder stringBuilder = new StringBuilder();
        for (Book b : bookList) {
            stringBuilder.append(b.getBookInfo() + ", ");
        }

        System.out.println(READER_NAME + space + verb + space + stringBuilder.substring(0, stringBuilder.length() - 2) + ".");
    }

    public void returnBook(int countOfReturnedBoos){
        String book = "";
        if (countOfReturnedBoos % 10 == 1) {
            book = "книгу";
        } else if (countOfReturnedBoos % 10 > 1 && countOfReturnedBoos % 10 < 5) {
            book = "книги";
        } else {
            book = "книг";
        }

        String verb = "";
        if (GENDER.equalsIgnoreCase("male")) {
            verb = "вернул ";
        } else {
            verb = "вернула ";
        }

        System.out.println(READER_NAME + " " + verb + countOfReturnedBoos + " " + book + ".");
    }

    public void returnBook(String bookList){
        String verb = "";
        if (GENDER.equalsIgnoreCase("male")) {
            verb = "вернул книги:";
        } else {
            verb = "вернула книги:";
        }

        String space = " ";

        System.out.println(READER_NAME + space + verb + space + bookList + ".");
    }

    public void returnBook(List<Book> bookList) {
        String verb = "";
        if (GENDER.equalsIgnoreCase("male")) {
            verb = "вернул книги:";
        } else {
            verb = "вернула книги:";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Book b : bookList) {
            b.bringBack();
            stringBuilder.append(b.getBookInfo() + ", ");
        }

        System.out.println(READER_NAME + " " + verb + " " + stringBuilder.substring(0, stringBuilder.length() - 2) + ".");
    }

    public Reader findReaderByNumberOfLibraryCard(int numberOfLibraryCard) {
        if (NUMBER_OF_LIBRARY_CARD == numberOfLibraryCard) return this;
        return null;
    }

    public Reader findReaderByPhoneNumber(String phoneNumber) {
        if (this.phoneNumber.equals(phoneNumber)) return this;
        return null;
    }

    public List<Book> getReaderBookList(){
        return readerBookList;
    }
}
