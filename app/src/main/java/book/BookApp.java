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
        var result = removeDuplication(books);
        var additions = removeDuplication(Arrays.asList(toBeAdded));
        var actualAdditions = new ArrayList<Book>();
        
        for (Book candidate : additions) {
            if (checkNotDuplication(books, candidate)) {
                if (checkNotDuplication(actualAdditions, candidate)) {
                    actualAdditions.add(candidate);
                }
            }
        }
        result.addAll(actualAdditions);
        return result;
    }

    private List<Book> removeDuplication(List<Book> books) {
        var bookList = new ArrayList<Book>();
        
        for (Book book : books) {
            if (checkNotDuplication(bookList, book)) {
                bookList.add(book);
            }
        }
        return bookList;
    }
    
    private boolean checkNotDuplication(List<Book> books, Book candidate) {
        var foundDuplicationInList = false;
        for (Book alreadyInList : books) {
            if (alreadyInList.sameAs(candidate)) {
                foundDuplicationInList = true;
                break;
            }
        }
        return !foundDuplicationInList;
    }
}
