package book;

import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (notContains(book)) {
            books.add(book);
        }
    }

    private boolean notContains(Book candidate) {
        var foundDuplicationInList = false;
        for (Book alreadyBook : this.books) {
            if (alreadyBook.sameAs(candidate)) {
                foundDuplicationInList = true;
                break;
            }
        }
        return !foundDuplicationInList;
    }

    public List<Book> bookList() {
        return books;
    }

}