public class Book {
    private final String NAME;
    private final String AUTHOR;
    private final String YEAR_OF_PUBLICATION;
    private boolean available = true;

    public Book(String name, String author, String yearOfPublication) {
        NAME = name;
        AUTHOR = author;
        YEAR_OF_PUBLICATION = yearOfPublication;
    }

    public boolean isAvailable(){
        return available;
    }

    public void takeHome(){
        available = false;
    }

    public void bringBack(){
        available = true;
    }

    public String getBookInfo() {
        return NAME + " (" + AUTHOR + " " + YEAR_OF_PUBLICATION + "г.)";
    }
}
