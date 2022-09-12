package book;

import java.util.ArrayList;
import java.util.List;

public class Books {
    public static List<Book> of(Book... books) {
        var bookList = new ArrayList<Book>();
        for (Book book : books) {
            if (!Books.exists(bookList, book)) {
                bookList.add(book);
            }
        }
        return bookList;
    }

    public static List<Book> of(List<Book> list, Book... books) {
        var result = new ArrayList<Book>(list);
        for (Book book : books) {
            if (!Books.exists(result, book)) {
                result.add(book);
            }
        }
        return result;
    }

    private static Boolean exists(List<Book> list, Book book) {
        for (Book existingBook : list) {
            if (existingBook.sameAs(book)) {
                return true;
            }
        }
        return false;
    }
}
