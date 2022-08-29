package book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookApp {
    /**
     * 
     * @param books
     * @param toBeAdded
     * @return
     */
    public List<Book> シチュエーション1_本のリストに重複なく本を足したい(List<Book> books, Book... toBeAdded) {
        var bookShelf = new BookShelf();

        books.forEach(book -> bookShelf.addBook(book));
        List.of(toBeAdded).forEach(book -> bookShelf.addBook(book));

        return bookShelf.bookList();
    }
}
