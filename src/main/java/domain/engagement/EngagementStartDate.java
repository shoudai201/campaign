package domain.engagement;

import lombok.Getter;

import java.time.LocalDate;

public record EngagementStartDate(LocalDate value) {
    public LocalDate getValue() {
        return value;
    }
}
