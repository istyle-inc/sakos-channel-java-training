package date;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class DateApiTest {
    @Nested
    class currentBusinessDateのテスト {
        @Test
        public void 出力確認() {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 0, 0, 0, 0, ZoneOffset.UTC);
            var sut = new DateApi(testdateTime);
            var response = sut.currentBusinessDate();

            assertThat(response.date())
            .as("日付を持っている")
            .isEqualTo("2022年10月11日");

            assertThat(response.isInBusiness())
            .as("営業中かのフラグを持っている")
            .isEqualTo(false);
        }
    }
}
