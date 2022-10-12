package date;

import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;


public class BusinessDateTest {
    @Test
    public void 営業日付を文字列で取得できる() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 10, 0, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.getBusinessDateString()).isEqualTo("2022年10月07日");
    }

    @Test
    public void 営業日付を文字列で取得できる_JSTの時刻を渡す() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 10, 0, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.getBusinessDateString()).isEqualTo("2022年10月07日");
    }

    @Test
    public void 営業日付を文字列で取得できる_UCTの時刻を渡しても日本時間で取得できる() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        testDate.set(2022, 9, 7, 20, 0, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.getBusinessDateString()).isEqualTo("2022年10月08日");
    }

    @Test
    public void 営業日付を文字列で取得できる_境界値_2022年10月7日3時59分00秒は10月6日() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 3, 59, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.getBusinessDateString()).isEqualTo("2022年10月06日");
    }

    @Test
    public void 営業日付を文字列で取得できる_境界値_2022年10月7日3時59分01秒は10月7日() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 3, 59, 1);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.getBusinessDateString()).isEqualTo("2022年10月07日");
    }

    @Test
    public void 営業日付を文字列で取得できる_2022年10月6日23時59分0秒は10月6日() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 6, 23, 59, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.getBusinessDateString()).isEqualTo("2022年10月06日");
    }

    @Test
    public void 営業日付を文字列で取得できる_2022年10月7日0時1分00秒は10月6日() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 0, 1, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.getBusinessDateString()).isEqualTo("2022年10月06日");
    }

    @Test
    public void 営業中かどうか確認＿営業時間中() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 10, 0, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.isInBusiness()).isEqualTo(true);
    }
    @Test
    public void 営業中かどうか確認_営業時間外() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 20, 0, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.isInBusiness()).isEqualTo(false);
    }
    @Test
    public void 営業中かどうか確認_2022年10月7日8時59分00秒_営業前である() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 3, 59, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.isInBusiness()).isEqualTo(false);
    }
    @Test
    public void 営業中かどうか確認_2022年10月7日8時59分01秒_営業中である() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 8, 59, 1);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.isInBusiness()).isEqualTo(true);
    }
    @Test
    public void 営業中かどうか確認_2022年10月7日17時59分00秒_営業中である() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 17, 59, 0);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.isInBusiness()).isEqualTo(true);
    }
    @Test
    public void 営業中かどうか確認_2022年10月7日17時59分01秒_営業終了中である() {
        var testDate = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        testDate.set(2022, 9, 7, 17, 59, 1);
        var sut = new BusinessDate(testDate.getTime());
        assertThat(sut.isInBusiness()).isEqualTo(false);
    }
}
