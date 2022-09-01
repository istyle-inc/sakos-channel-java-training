package book;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.CoreMatchers.*;


public class BookTest {
    @Test
    public void 初期化時に渡した値を取得できること_著者() {
        // SetUp
        var sut = new Book("タイトル1", "著者1");
        // Exercise
        var actual = sut.author();
        // Test
        assertThat(actual, is("著者1"));
    }

    @Test
    public void 初期化時に渡した値を取得できること_タイトル() {
        // SetUp
        var sut = new Book("タイトル1", "著者1");
        // Exercise
        var actual = sut.title();
        // Test
        assertThat(actual, is("タイトル1"));
    }

    @Test
    public void タイトルと著者名が一致する場合は同じ本と判定されること() {
        // SetUp
        var book_1 = new Book("タイトル1", "著者1");
        var book_2 = new Book("タイトル1", "著者1");
        // Exercise
        var actual = book_1.sameAs(book_2);
        // Test
        assertTrue(actual);
    }


}
