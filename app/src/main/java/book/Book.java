package book;

import lib.curry.predicates.PartialApply;

import java.util.function.BiFunction;

public class Book {
    public static final BiFunction<Book, Book, Boolean> notDuplicateCondition = Book::sameBook;

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

    public static PartialApply<Book> sameBook() {
        return book1 -> book2 -> book1.title().equals(book2.title()) && book1.author().equals(book2.author());
    }

    /**
     * この世界ではタイトルと著者名が同じ本は同じ本とみなす
     * @param book1
     * @param book2
     * @return 同じであればtrue
     */
    private static boolean sameBook(Book book1, Book book2) {
        return book1.title() == book2.title() && book1.author() == book2.author();
    }
}
