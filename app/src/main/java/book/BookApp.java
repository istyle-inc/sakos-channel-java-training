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
        var baseBookShelf = new BookShelf(books);
        var candidateBookShelf = new BookShelf(Arrays.asList(toBeAdded));
        var mergedBookShelf = baseBookShelf.merge(candidateBookShelf);

        return mergedBookShelf.books();
    }
}
