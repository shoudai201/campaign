package domain.atm;

public class AtmEntity {

    private final AtmType atmType;

    public AtmEntity(AtmType atmType) {
        this.atmType = atmType;
    }

    
    public Fee chargeFee(UseDateTime useDateTime) {
        
        if(this.atmType.equals(AtmType.銀行ATM)){

            if(WorkingTime.銀行ATM.isWorkingTime(useDateTime.getUseTime())){
                return new Fee(0);
            }
            return new Fee(110);
            
        }else if(this.atmType.equals(AtmType.コンビニATM)){
            if(useDateTime.isSaturdayOrSunday()){
                return new Fee(330);
            }
            if(useDateTime.isWeekDay()){
                if(WorkingTime.コンビニATM.isWorkingTime(useDateTime.getUseTime())){
                    return new Fee(220);
                }
                return new Fee(330);
            }
            throw new RuntimeException("コンビニATMの手数料が算出できません");
        }
        throw new RuntimeException("ATMの種類が特定できません");
    }
}
