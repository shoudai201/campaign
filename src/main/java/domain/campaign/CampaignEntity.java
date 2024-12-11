package domain.campaign;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@NonNull
public class CampaignEntity {

    private final CampaignId campaignId;

    private final CampaignStatus campaignStatus;

    private final CampaignType campaignType;

    public CampaignEntity(CampaignId campaignId,
                          CampaignStatus campaignStatus,
                          CampaignType campaignType
                          ) {
        this.campaignId=campaignId;
        this.campaignStatus = campaignStatus;
        this.campaignType= campaignType;
    }

    public CampaignEntity cancel(){
        return new CampaignEntity(
                this.campaignId,
                CampaignStatus.CANCELED,
                this.campaignType
        );
    }
}
