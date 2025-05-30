package domain.atm;


public class AtmEntity {

    private final AtmType atmType;

    public AtmEntity(AtmType atmType) {
        this.atmType = atmType;
    }

    
    public Fee chargeFee(UseDateTime useDateTime) {
        return new Fee(100);
    }
}
