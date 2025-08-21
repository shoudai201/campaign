package domain.atm;

public class コンビニATMEntity implements AtmEntity {
    private final AtmType atmType = AtmType.コンビニATM;

    public Fee chargeFee(UseDateTime useDateTime) {
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
}
