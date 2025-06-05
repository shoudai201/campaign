package domain.atm;

public class AtmFactory {
    public static AtmEntity createAtmEntity(AtmType atmType) {
        return new AtmEntity(atmType);
    }
}
