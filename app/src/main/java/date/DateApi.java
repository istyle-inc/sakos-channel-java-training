package date;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import date.response.BusinessDateResponse;

/**
 * あるサービスにおけるAPI
 * ※メソッドの実装は変更してよいが、宣言を変更しないこと
 */
public class DateApi {
    private final OffsetDateTime time;
    
    public DateApi(OffsetDateTime offsetDateTime) {
        this.time = offsetDateTime;
    }

    /**
     * 実日時をISO8061拡張形式(秒まで)で返却する
     *
     * @return 実日時の文字列
     */
    public String actualCurrentDate() {
        return this.time
                .truncatedTo(ChronoUnit.MINUTES)
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    /**
     * 営業日付オブジェクトを返却するメソッドのスタブ
     *
     * @return 営業日付オブジェクト
     */
    public BusinessDateResponse currentBusinessDate() {
        var businessdateTime = new BusinessDateTime(this.time);

        return new BusinessDateResponse(
                businessdateTime.date(),
                businessdateTime.isOpen());
    }
}
