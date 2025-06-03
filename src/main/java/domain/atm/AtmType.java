package domain.atm;

import lombok.AllArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
public enum AtmType {

    銀行ATM("銀行ATM"),
    コンビニATM("コンビニATM");

    private final String name;

}
