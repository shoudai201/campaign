package domain.atm;

public class 銀行ATMEntity implements AtmEntity{
    private final AtmType atmType = AtmType.銀行ATM;

    public Fee chargeFee(UseDateTime useDateTime) {
        if(WorkingTime.銀行ATM.isWorkingTime(useDateTime.getUseTime())){
            return new Fee(0);
        }
        return new Fee(110);
    }
}
