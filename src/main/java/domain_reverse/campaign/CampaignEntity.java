package domain_reverse.campaign;

import domain_reverse.campaign.cashback.CashBack;
import domain_reverse.campaign.cashback.GiftCertificate;
import domain_reverse.campaign.cashback.Money;
import domain_reverse.engagement.EngagementEntity;
import domain_reverse.engagement.EngagementID;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@NonNull
public class CampaignEntity {

    private final CampaignId campaignId;

    private final CampaignStatus campaignStatus;

    private final CampaignType campaignType;

    private final CampaignGrantScheduledDate campaignGrantScheduledDate;

    private final EngagementID targetEngagementId;

    public CampaignEntity(CampaignId campaignId,
                          CampaignStatus campaignStatus,
                          CampaignType campaignType,
                          EngagementEntity engagementEntity) {
        this.campaignId = campaignId;
        this.campaignStatus = campaignStatus;
        this.campaignType = campaignType;
        this.campaignGrantScheduledDate = new CampaignGrantScheduledDate(engagementEntity.getEngagementStartDate());
        this.targetEngagementId = engagementEntity.getEngagementID();

    }

    public CampaignEntity cancel(){
        return new CampaignEntity(
                this.campaignId,
                CampaignStatus.CANCELED,
                this.campaignType,
                this.campaignGrantScheduledDate,
                this.targetEngagementId
        );
    }

    public Optional<CashBack> grant(EngagementEntity engagementEntity){
        if(engagementEntity.equals(this.targetEngagementId)){
            throw new RuntimeException("特典と契約が不整合");
        }
        
        if(!engagementEntity.isEngaged()){
            return  Optional.empty();
        }
        if(!this.campaignGrantScheduledDate.isAfter(LocalDate.now())){
                return Optional.empty();
        }
        switch (this.campaignType){
            case GIFT_CERTIFICATE -> {
                return Optional.of(new GiftCertificate(10000));
            }
            case MONEY -> {
                return Optional.of(new Money(9000));
            }
            default -> {
                throw new RuntimeException("キャッシュバック特典が特定できない");
            }
        }
    }
}
