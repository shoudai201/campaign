package domain.engagement;

import lombok.NonNull;

@NonNull
public class EngagementEntity {

    private final EngagementID engagementID;

    private final EngagementStatus engagementStatus;

    public EngagementEntity(EngagementID engagementID,
                            EngagementStatus engagementStatus) {
        this.engagementID= engagementID;
        this.engagementStatus = engagementStatus;
    }

    public EngagementEntity terminated(){
        return new EngagementEntity(
                this.engagementID,
                engagementStatus.TERMINATED
        );
    }
}
