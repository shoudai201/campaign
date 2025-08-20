package domain.atm;

public class AtmFactory {
    public AtmEntity createAtmEntity(AtmType atmType) {
        return new AtmEntity(atmType);
    }
}
