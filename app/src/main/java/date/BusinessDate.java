package date;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class BusinessDate {
    private final OffsetDateTime businessDate ;
    private static final String FORMAT_PATTERN = "yyyy年MM月dd日";
    private static final int REAL_DATE_MIDNIGHT = 0;
    private static final int BUSINESS_DATE_MIDNIGHT = 4;
    private static final int BUSINESS_TIME_START_HOUR = 9;
    private static final int BUSINESS_TIME_END_HOUR = 18;

    public BusinessDate(Date date) {
        var businessDate = OffsetDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Tokyo"));
        businessDate = this.roundedUpOfSecond(businessDate);
        businessDate = this.AdjustmentDate(businessDate);

        this.businessDate = businessDate;
    }


    public OffsetDateTime roundedUpOfSecond(OffsetDateTime date) {
        if (date.getSecond() > date.truncatedTo(ChronoUnit.MINUTES).getSecond()) {
            return date.plusMinutes(1);
        }
        return date;
    }

    public OffsetDateTime AdjustmentDate(OffsetDateTime date) {
        var targetHour = date.getHour();
        // 深夜0時から4時までの間のみ日付調整を行う
        if (REAL_DATE_MIDNIGHT <= targetHour && targetHour < BUSINESS_DATE_MIDNIGHT) {
            return date.plusDays(-1);
        }
        return date;
    }

    public String getBusinessDateString() {
        return this.businessDate.format(DateTimeFormatter.ofPattern(FORMAT_PATTERN));
    }

    public boolean isInBusiness() {
        var hour = this.businessDate.getHour();
        return (BUSINESS_TIME_START_HOUR <= hour && hour < BUSINESS_TIME_END_HOUR);
    }
}