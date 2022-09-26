package book;

public class Book {
    private final String title;
    private final String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String title() {
        return this.title;
    }

    public String author() {
        return this.author;
    }

    /**
     * この世界ではタイトルと著者名が同じ本は同じ本とみなす
     * @param book
     * @return 同じであればtrue
     */
    public boolean sameBook(Book book) {
        return this.title == book.title() && this.author == book.author();
    }
}