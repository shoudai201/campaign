package atm;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 利用日時
 * @param value
 */
public record UseDateTime(LocalDateTime value) {

    public boolean isSaturdayOrSunday() {
        return value.getDayOfWeek() == java.time.DayOfWeek.SATURDAY
        || value.getDayOfWeek() == java.time.DayOfWeek.SUNDAY;
    }

    public boolean isWeekDay(){
        return !this.isSaturdayOrSunday();
    }

    public UseTime getUseTime(){
        return new UseTime(this.value.toLocalTime());
    }
}
