package book;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class BookTest {
    @Nested
    class タイトルと著者名が同じ本は同じ本とみなす判定のテスト {
        @Test
        public void タイトルと著者がどっちも同じ場合にtrueが返ること() {
            // SetUp
            var sut = new Book("タイトル", "著者");
            // Exercise
            var actual = sut.sameAs(new Book("タイトル", "著者"));
            // Test
            System.out.println(actual);
            assertThat(actual).isTrue();
        }
        public void タイトルが同じで著者が違う場合にfalseが返ること() {
            // SetUp
            var sut = new Book("タイトル", "著者");
            // Exercise
            var actual = sut.sameAs(new Book("タイトル", "違う著者"));
            // Test
            System.out.println(actual);
            assertThat(actual).isFalse();
        }
        public void タイトルが違い著者が同じ場合にfalseが返ること() {
            // SetUp
            var sut = new Book("タイトル", "著者");
            // Exercise
            var actual = sut.sameAs(new Book("違うタイトル", "著者"));
            // Test
            System.out.println(actual);
            assertThat(actual).isFalse();
        }
        public void タイトルと著者がどっちも違う場合にfalseが返ること() {
            // SetUp
            var sut = new Book("タイトル", "著者");
            // Exercise
            var actual = sut.sameAs(new Book("違うタイトル", "違う著者"));
            // Test
            System.out.println(actual);
            assertThat(actual).isFalse();
        }
    }
}
