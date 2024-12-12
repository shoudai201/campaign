package domain_reverse.engagement;

import lombok.Getter;
import lombok.NonNull;

@Getter
@NonNull
public class EngagementEntity {

    private final EngagementID engagementID;

    private final EngagementStatus engagementStatus;

    private final EngagementStartDate engagementStartDate;

    public EngagementEntity(EngagementID engagementID,
                            EngagementStatus engagementStatus,
                            EngagementStartDate engagementStartDate
    ) {
        this.engagementID= engagementID;
        this.engagementStatus = engagementStatus;
        this.engagementStartDate = engagementStartDate;
    }

    public boolean equalsId(EngagementID engagementID){
        return this.engagementID.equals(engagementID);
    }

    public EngagementEntity terminated(){
        return new EngagementEntity(
                this.engagementID,
                engagementStatus.TERMINATED,
                this.engagementStartDate
        );
    }

    public boolean isEngaged(){
        return this.engagementStatus.isEngaged();
    }

}
