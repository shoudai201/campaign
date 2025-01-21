package domain_reverse.campaign;

import domain_reverse.engagement.EngagementEntity;

public class NotYetCampaignEntity implements CampaignEntity{
    NotYetCampaignEntity(CampaignId campaignId,
                   CampaignStatus campaignStatus,
                   CampaignType campaignType,
                   EngagementEntity engagementEntity) {
        this.campaignId = campaignId;
        this.campaignStatus = campaignStatus;
        this.campaignType = campaignType;
        this.campaignGrantScheduledDate = new CampaignGrantScheduledDate(engagementEntity.getEngagementStartDate());
        this.targetEngagementId = engagementEntity.getEngagementID();

    }

}
