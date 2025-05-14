package domain.atm;

import lombok.AllArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
public enum AtmType {

    銀行ATM(LocalTime.of(8,45,0),LocalTime.of(21,0,0)),
    コンビニATM(LocalTime.of(8,45,0),LocalTime.of(18,0,0));

    private final LocalTime startTime;

    private final LocalTime endTime;
    
    
}
