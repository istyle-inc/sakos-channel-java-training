package date;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

// 判定用に時間まで持つため日時クラス
public class BusinessDateTime {

    private final LocalDateTime time;

    // 前日の営業日時判定用
    private static int PREVIOUS_START_HOUR = 0;
    private static int PREVIOUS_END_HOUR = 4;

    private static int OPEN_HOUR = 9;
    private static int CLOSE_HOUR = 18;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");

    public BusinessDateTime(OffsetDateTime offsetDateTime) {
        this.time = offsetDateTime.toLocalDateTime();
    }

    // 営業日付を返す　yyyy年mm月dd日形式
    public String date() {
        // フォーマットを年月日の形にする
        // LocalDateTimeから文字列に変換
        // 0~4時までならtimeの日にちをマイナス1にする。

        if (isPrevious()) {
            return this.time
                    .minusDays(1)
                    .format(formatter);
        }
        return this.time.format(formatter);
    }

    public boolean isOpen() {
        return OPEN_HOUR <= this.time.getHour()
                && this.time.getHour() < CLOSE_HOUR;
    }

    // 0 ~ 4時まではtrue
    private boolean isPrevious() {
        return PREVIOUS_START_HOUR <= this.time.getHour()
                && this.time.getHour() < PREVIOUS_END_HOUR;
    }
}
