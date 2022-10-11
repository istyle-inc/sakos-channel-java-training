package date;

import java.time.OffsetDateTime;

public class BusinessDate {
    private final OffsetDateTime businessDate ;
    public BusinessDate(OffsetDateTime businessDate) {
        this.businessDate = businessDate;
    }

    public String getBusinessDateString() {
        return OffsetDateTime.now().toString();
    }

    public boolean isInBusiness() {
        return true;
    }
}