package domain.atm;

public class AtmFactory {

    public AtmEntity create(AtmType atmType){
        return new AtmEntity(atmType);
    }
}
