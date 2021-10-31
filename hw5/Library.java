import java.util.ArrayList;
import java.util.List;

public class Library {
    private static List<Book> bookList = new ArrayList<>();
    private static List<Reader> readerList = new ArrayList<>();
    private static int nextNumberOfLibraryCard = 3;

    public Library() {
        bookList.add(new Book("Маленький принц", "Антуан де Сент-Экзюпери", "1943"));
        bookList.add(new Book("Белый Клык", "Джек Лондон", "1906"));
        bookList.add(new Book("Белый Клык", "Джек Лондон", "1906"));
        bookList.add(new Book("Три мушкетёра", "Дюма А.", "1844"));
        bookList.add(new Book("Три мушкетёра", "Дюма А.", "1844"));
        bookList.add(new Book("Три мушкетёра", "Дюма А.", "1844"));

        readerList.add(new Reader("Петров В.А.", 0, "22.01.1994", "male", "Правоведение", "+380984605478"));
        readerList.add(new Reader("Иванова А.А.", 1, "20.10.1999", "female", "Экономика", "+380994508795"));
        readerList.add(new Reader("Кулик И.В.", 2, "08.08.1996", "male", "Компьютерные науки", "+380501506489"));
    }

    public static void getBookList(){
        StringBuilder stringBuilder = new StringBuilder("Список доступных книг: ");
        for(Book book: bookList){
            if(book.isAvailable()){
                stringBuilder.append(book.getBookInfo() + ", ");
            }
        }

        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
    }

    public static void getReaderList(){
        StringBuilder stringBuilder = new StringBuilder("Список всех читателей: ");
        for (Reader reader: readerList){
            stringBuilder.append(reader.getReaderInfo() + ", ");
        }

        System.out.println(stringBuilder.substring(0, stringBuilder.length() - 2));
    }

    public static int getNextNumberOfLibraryCard() {
        nextNumberOfLibraryCard++;
        return nextNumberOfLibraryCard - 1;
    }

    public static void addNewBook(Book book) {
        bookList.add(book);
    }

    public static void addNewReader(Reader reader) {
        readerList.add(reader);
    }

    public static Book takeAvailableBookHome() {
        for (Book book : bookList) {
            if (book != null && book.isAvailable()) {
                book.takeHome();
                return book;
            }
        }
        return null;
    }

    public static Reader findReaderByNumberOfLibraryCard(int numberOfLibraryCard) {
        for (int i = 0; i < readerList.size(); i++) {
            if (readerList.get(i).findReaderByNumberOfLibraryCard(numberOfLibraryCard) != null) {
                return readerList.get(i).findReaderByNumberOfLibraryCard(numberOfLibraryCard);
            }
        }
        return null;
    }

    public static Reader findReaderByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < readerList.size(); i++) {
            if (readerList.get(i).findReaderByPhoneNumber(phoneNumber) != null) {
                return readerList.get(i).findReaderByPhoneNumber(phoneNumber);
            }
        }
        return null;
    }

    public static void deleteReader(Reader reader){
        readerList.remove(reader);
    }

    public static void deleteReaderByNumberOfLibraryCard(int numberOfLibraryCard){
        Reader reader;
        for(int i = 0; i < readerList.size(); i++){
            reader = readerList.get(i).findReaderByNumberOfLibraryCard(numberOfLibraryCard);
            if(reader != null) {
                readerList.remove(reader);
                break;
            }
        }
    }

    public static void main(String[] args) {
        new Library();
        addNewReader(new Reader("Жукова Т.А.", getNextNumberOfLibraryCard(), "09.05.2000", "female", "Архитектура", "+380981305478"));
        addNewBook(new Book("Словарь", "Даль В.", "1980"));

        Reader visitor1 = findReaderByNumberOfLibraryCard(0);
        if (visitor1 == null) {
            System.out.println("not found");
        } else {
            visitor1.takeBook(2);
            visitor1.returnBook(10);
        }

        Reader visitor2 = findReaderByPhoneNumber("+380981305478");
        List<Book> visitorBookList = new ArrayList<>();

        if (visitor1 == null) {
            System.out.println("not found");
        } else {
            visitor2.takeBook("Словарь, Энциклопедия");
            visitor2.returnBook("Словарь, Энциклопедия");
            visitorBookList.add(takeAvailableBookHome());
            visitorBookList.add(takeAvailableBookHome());
            visitorBookList.add(takeAvailableBookHome());

            visitor2.takeBook(visitorBookList);
            visitorBookList.remove(0);
            visitor2.returnBook(visitor2.getReaderBookList());
        }

        deleteReader(visitor1);
        deleteReaderByNumberOfLibraryCard(4);

        getBookList();
        getReaderList();
    }
}
