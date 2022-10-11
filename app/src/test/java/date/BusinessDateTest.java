package date;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class BusinessDateTest {
    @Test
    public void 営業日時を文字列で取得できること() {
        var sut = new BusinessDate(OffsetDateTime.now());
        var dateString = sut.getBusinessDateString();
        assertThat(dateString instanceof String, String.class);
    }
    public void 営業中かどうか確認() {
        var sut = new BusinessDate(OffsetDateTime.now());
        assertThat(sut.isInBusiness(), true);
    }
}
