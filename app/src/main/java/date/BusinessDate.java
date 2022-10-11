package date;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

public class BusinessDate {
    private final OffsetDateTime businessDate ;
    public BusinessDate(Date date) {
        this.businessDate = OffsetDateTime.ofInstant(date.toInstant(), ZoneId.of("Asia/Tokyo"));
    }

    public String getBusinessDateString() {
        return OffsetDateTime.now().toString();
    }

    public boolean isInBusiness() {
        return true;
    }
}