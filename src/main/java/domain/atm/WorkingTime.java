package domain.atm;


import java.time.LocalTime;

public enum WorkingTime {

    銀行ATM(AtmType.銀行ATM,LocalTime.of(8,45,0),LocalTime.of(21,0,9)),
    コンビニATM(AtmType.コンビニATM,LocalTime.of(8,45,0),LocalTime.of(18,0,9));

    private final AtmType atmType;

    private final LocalTime startTime;

    private final LocalTime endTime;

    WorkingTime(AtmType atmType, LocalTime startTime, LocalTime endTime) {
        this.atmType = atmType;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isWorkingTime(UseTime useTime){
        LocalTime useLocalTime = useTime.getValue();
        return !useLocalTime.isBefore(this.startTime) && !useLocalTime.isAfter(this.endTime);
    }
}
