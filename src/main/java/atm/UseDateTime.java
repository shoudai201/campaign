package atm;

import java.time.LocalDateTime;

/**
 * 利用日
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
}
