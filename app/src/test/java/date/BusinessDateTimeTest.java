package date;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;


public class BusinessDateTimeTest {
    @Nested
    class dateのテスト {
        @Test
        public void 閾値0時の際は前日判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 0, 0, 0, 0, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var dateString = sut.date();
            assertThat(dateString)
            .as("閾値0時の際は前日判定")
            .isEqualTo("2022年10月11日");
        }

        @Test
        public void 閾値23時59分の際は当日判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 23, 59, 59, 59, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var dateString = sut.date();
            assertThat(dateString)
            .as("閾値23時59分の際は当日判定")
            .isEqualTo("2022年10月12日");
        }

        @Test
        public void 閾値4時の際は当日判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 4, 0, 0, 0, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var dateString = sut.date();
            assertThat(dateString)
            .as("閾値4時の際は当日判定")
            .isEqualTo("2022年10月12日");
        }

        @Test
        public void 閾値3時59分の際は前日判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 3, 59, 59, 59, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var dateString = sut.date();
            assertThat(dateString)
            .as("閾値3時59分の際は前日判定")
            .isEqualTo("2022年10月11日");
        }
    }

    @Nested
    class isOpenのテスト {
        @Test
        public void 閾値9時の際は営業中判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 9, 0, 0, 0, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var isOpen = sut.isOpen();
            assertThat(isOpen)
            .as("閾値9時の際は営業中判定")
            .isEqualTo(true);
        }

        @Test
        public void 閾値8時59分の際は営業外判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 8, 59, 59, 59, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var isOpen = sut.isOpen();
            assertThat(isOpen)
            .as("閾値8時59分の際は営業外判定")
            .isEqualTo(false);
        }

        @Test
        public void 閾値18時の際は営業外判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 18, 0, 0, 0, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var isOpen = sut.isOpen();
            assertThat(isOpen)
            .as("閾値18時の際は営業外判定")
            .isEqualTo(false);
        }

        @Test
        public void 閾値17時59分の際は営業中判定 () {
            OffsetDateTime testdateTime = OffsetDateTime.of(2022, 10, 12, 17, 59, 59, 59, ZoneOffset.UTC);
            BusinessDateTime sut = new BusinessDateTime(testdateTime);
            var isOpen = sut.isOpen();
            assertThat(isOpen)
            .as("閾値17時59分の際は営業中判定")
            .isEqualTo(true);
        }
    }
}
