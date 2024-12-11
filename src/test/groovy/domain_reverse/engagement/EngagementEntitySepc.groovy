package domain_reverse.engagement

import spock.lang.Unroll

import java.time.LocalDate

@Unroll
class EngagementEntitySpec extends spock.lang.Specification {
    private final static EngagementEntity ENGAGEMENT_ENTITY = new EngagementEntity(
            new EngagementID("1"),
            EngagementStatus.ENGAGED,
            new EngagementStartDate(LocalDate.of(2024,12,1))
    );

    def "equals_#usecase"(){

        expect:
        expected == ENGAGEMENT_ENTITY.equals(engagementId);

        where:
        usecase | engagementId || expected
        "等しい" | new EngagementID("1") || true
        "等しくない" | new EngagementID("2") || false

    }
}
