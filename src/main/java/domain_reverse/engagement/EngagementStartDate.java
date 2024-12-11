package domain_reverse.engagement;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public record EngagementStartDate(LocalDate value) {
    public LocalDate getValue() {
        return value;
    }
}
