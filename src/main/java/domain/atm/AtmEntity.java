package domain.atm;


public interface AtmEntity {

    Fee chargeFee(UseDateTime useDateTime);
}
