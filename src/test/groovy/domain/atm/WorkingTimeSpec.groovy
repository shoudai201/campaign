package domain.atm

import spock.lang.Specification
import java.time.LocalTime

class WorkingTimeSpec extends Specification {

    def "isWorkingTime should return correct value based on useTime"() {
        given:
        def workingTime = workingTimeValue

        when:
        def result = workingTime.isWorkingTime(new UseTime(useTime))

        then:
        result == expected

        where:
        workingTimeValue          | useTime                 | expected
        WorkingTime.銀行ATM       | LocalTime.of(8, 44, 59) | false
        WorkingTime.銀行ATM       | LocalTime.of(8, 45, 0)  | true
        WorkingTime.銀行ATM       | LocalTime.of(21,0 , 0)  | true
        WorkingTime.銀行ATM       | LocalTime.of(21, 0, 1)  | true

    }
}
