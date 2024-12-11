package domain.engagement;

import domain.campaign.CampaignEntity;
import lombok.NonNull;

@NonNull
public class EngagementEntity {

    private final EngagementID engagementID;

    private final EngagementStatus engagementStatus;

    private final EngagementStartDate engagementStartDate;

    private final CampaignEntity grantedCampaignEntity;

    public EngagementEntity(EngagementID engagementID,
                            EngagementStatus engagementStatus,
                            EngagementStartDate engagementStartDate,
                            CampaignEntity campaignEntity) {
        this.engagementID= engagementID;
        this.engagementStatus = engagementStatus;
        this.engagementStartDate = engagementStartDate;
        this.grantedCampaignEntity = campaignEntity;
    }

    public EngagementEntity terminated(){
        return new EngagementEntity(
                this.engagementID,
                engagementStatus.TERMINATED,
                this.engagementStartDate,
                this.grantedCampaignEntity.cancel()
        );
    }
}
