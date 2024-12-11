package domain_reverse.campaign;

import domain_reverse.engagement.EngagementStartDate;

import java.time.LocalDate;

public record CampaignGrantScheduledDate(LocalDate value) {

    private static final int 契約開始から特典付与までの年数 = 2;

    public CampaignGrantScheduledDate (EngagementStartDate engagementStartDate){
        this(engagementStartDate.getValue().plusYears(契約開始から特典付与までの年数));
    }

    public boolean isAfter(LocalDate value){
        return this.value.isAfter(value);
    }
}
