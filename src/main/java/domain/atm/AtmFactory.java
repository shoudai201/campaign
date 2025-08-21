package domain.atm;

public class AtmFactory {
    public AtmEntity createAtmEntity(AtmType atmType) {
        if(atmType.equals(AtmType.銀行ATM)){
            return new 銀行ATMEntity();
        }
        if(atmType.equals(AtmType.コンビニATM)){
            return new コンビニATMEntity();
        }
        throw new RuntimeException("ATMの種類が特定できません");
    }
}
