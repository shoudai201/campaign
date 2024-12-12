package domain_reverse.engagement

import domain_reverse.campaign.CampaignEntity
import domain_reverse.campaign.CampaignId
import domain_reverse.campaign.CampaignStatus
import domain_reverse.campaign.CampaignType
import spock.lang.Unroll

import java.time.LocalDate

@Unroll
class EngagementEntitySpec extends spock.lang.Specification {

    private final static EngagementEntity ENGAGEMENT_ENTITY = new EngagementEntity(
            new EngagementID("1"),
            EngagementStatus.ENGAGED,
            new EngagementStartDate(LocalDate.of(2024,12,1))
    );

    private final static CampaignEntity CAMPAIGN_ENTITY = new CampaignEntity(
            new CampaignId("1"),
            CampaignStatus.PENDING,
            CampaignType.GIFT_CERTIFICATE,
            ENGAGEMENT_ENTITY
    );

    def "equalsId_#usecase"(){

        expect:
        expected == ENGAGEMENT_ENTITY.equalsId(engagementId);

        where:
        usecase | engagementId || expected
        "等しい" | new EngagementID("1") || true
        "等しくない" | new EngagementID("2") || false

    }

    def "grant_エラー"(){

        when:
        CAMPAIGN_ENTITY.grant(new EngagementEntity(
                new EngagementID("2"),
                EngagementStatus.ENGAGED,
                new EngagementStartDate(LocalDate.of(2024,12,1))
        )
        )

        then:
        def e = thrown(RuntimeException)
        e.getMessage() == "特典と契約が不整合"

    }
}
