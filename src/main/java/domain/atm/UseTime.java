package domain.atm;

import java.time.LocalTime;

/**
 * 利用日
 */
public record UseTime(LocalTime value) {

    public boolean isEqualsAndBefore(LocalTime localTime){
        return this.value.equals(localTime) || this.value.isBefore(localTime);
    }

    public boolean isEqualsAndAfter(LocalTime localTime){
        return this.value.equals(localTime) || this.value.isAfter(localTime);
    }

    public LocalTime getValue() {
        return this.value;
    }
}
