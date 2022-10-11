package date;

import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.Date;


public class BusinessDateTest {
    // @Test
    // public void 営業日時を文字列で取得できること() {
    //     var sut = new BusinessDate(OffsetDateTime.now());
    //     var dateString = sut.getBusinessDateString();
    //     assertThat(dateString)
    //         .as("とりあえず出力させてみる")
    //         .isEqualTo("???");
    //         // (dateString instanceof String, String.class);
    // }
    @Test
    public void 営業中かどうか確認() {
        var sut = new BusinessDate(new Date());
        assertThat(sut.isInBusiness()).isEqualTo(true);
    }
}
