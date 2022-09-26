package book;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class BookShelf {
    private final List<Book> books;

    public BookShelf(List<Book> books) {
        this.books = uniqueOf(books);
    }

    public List<Book> books() {
        return new ArrayList<>(this.books);
    }

    /**
     * 対象を追加して新たな本棚を作成
     * @param target
     * @return
     */
    public BookShelf merge(BookShelf target) {
        var books = target.books();
        books.addAll(this.books);
        return new BookShelf(books);
    }

    /**
     * 重複のない本のリストを作成
     * @param books
     * @return
     */
    private List<Book> uniqueOf(List<Book> books) {
        var uniqueBooks = new ArrayList<Book>();;
        for (var candidate : books) {
            if (!isExists(uniqueBooks, candidate)){
                uniqueBooks.add(candidate);
            }
        }
        return uniqueBooks;
    }

    /**
     * リストに対象が存在するか確認
     * @param books
     * @param target
     * @return 存在すればtrue
     */
    private boolean isExists(List<Book> books, Book target) {
        return books.stream().anyMatch(b -> b.sameBook(target));
    }
}