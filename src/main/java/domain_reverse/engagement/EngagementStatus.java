package domain_reverse.engagement;

public enum EngagementStatus {
    ORDERED,
    ENGAGED,
    TERMINATED;

    public boolean isEngaged(){
        return this.equals(ENGAGED);
    }
}
