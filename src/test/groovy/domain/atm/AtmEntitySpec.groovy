package domain.atm

import spock.lang.Specification
import spock.lang.Unroll
import java.time.LocalDateTime

@Unroll
class AtmEntitySpec extends Specification {

    def "chargeFee_#usecase"() {
        setup:
        AtmEntity atmEntity = new AtmFactory().create(atmType)
        UseDateTime useDateTime = new UseDateTime(dateTime)

        when:
        Fee fee = atmEntity.chargeFee(useDateTime)

        then:
        fee == expected

        where:
        usecase | atmType | dateTime                || expected
        "銀行ATM営業時間内"|AtmType.銀行ATM | LocalDateTime.of(2023, 1, 6, 9, 0, 0)  || new Fee(0)
        "銀行ATM営業時間外"|AtmType.銀行ATM | LocalDateTime.of(2023, 1, 6, 22, 0, 0) || new Fee(110)
        "コンビニATM土日" | AtmType.コンビニATM | LocalDateTime.of(2023,1,7,22,0,0)|| new Fee(330)
        "コンビニATM平日_営業時間内" | AtmType.コンビニATM | LocalDateTime.of(2023,1,6,9,0,0)|| new Fee(220)
        "コンビニATM平日_営業時間外" | AtmType.コンビニATM | LocalDateTime.of(2023,1,6,21,0,0)|| new Fee(330)

    }
}
