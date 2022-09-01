package book;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BookShelfTest {
    @Test
    public void 初期状態の場合_bookListが空であること() {
        // SetUp
        var sut = new BookShelf();
        // Exercise
        var actual = sut.bookList();
        // Test
        assertThat(actual).hasSize(0);
    }

    @Test
    public void addBookで追加した本がbookListに追加されていること() {
        // SetUp
        var sut = new BookShelf();
        var toBeAdded = new Book("タイトル1", "著者1");
        // Exercise
        sut.addBook(toBeAdded);
        var actual = sut.bookList();
        // Test
        assertThat(actual)
                .anyMatch(book -> book.title() == "タイトル1" && book.author() == "著者1")
                .hasSize(1);
    }

    @Test
    public void 複数の本をaddBookで追加する_重複がなければ全てbookListに追加されていること() {
        // SetUp
        var sut = new BookShelf();
        var toBeAdded_1 = new Book("タイトル1", "著者1");
        var toBeAdded_2 = new Book("タイトル2", "著者2");
        // Exercise
        sut.addBook(toBeAdded_1);
        sut.addBook(toBeAdded_2);
        var actual = sut.bookList();
        // Test
        assertThat(actual)
                .anyMatch(book -> book.title() == "タイトル1" && book.author() == "著者1")
                .anyMatch(book -> book.title() == "タイトル2" && book.author() == "著者2")
                .hasSize(2);
    }

    @Test
    public void 複数の本をaddBookで追加する_重複がある場合はbookListに追加されないこと() {
        // SetUp
        var sut = new BookShelf();
        var toBeAdded_1 = new Book("タイトル1", "著者1");
        var toBeAdded_2 = new Book("タイトル2", "著者2");
        var toBeAdded_3 = new Book("タイトル1", "著者1");
        // Exercise
        sut.addBook(toBeAdded_1);
        sut.addBook(toBeAdded_2);
        sut.addBook(toBeAdded_3);
        var actual = sut.bookList();
        // Test
        assertThat(actual)
                .anyMatch(book -> book.title() == "タイトル1" && book.author() == "著者1")
                .anyMatch(book -> book.title() == "タイトル2" && book.author() == "著者2")
                .hasSize(2);
    }
}
