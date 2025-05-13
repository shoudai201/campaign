package atm

import java.time.LocalTime
import spock.lang.Specification

class UseTimeSpec extends Specification {
    def "isEqualsAndBefore のテスト"() {
        setup:
        def useTime = new UseTime(baseTime)

        expect:
        useTime.isEqualsAndBefore(localTime) == expected

        where:
        baseTime             | localTime                      | expected
        LocalTime.of(12, 30, 0) | LocalTime.of(12, 30, 0)          | true
        LocalTime.of(12, 30, 0) | LocalTime.of(12, 30, 1)          | true
        LocalTime.of(12, 30, 0) | LocalTime.of(12, 29, 59)         | false
    }

    def "isEqualsAndAfter のテスト"() {
        setup:
        def useTime = new UseTime(baseTime)

        expect:
        useTime.isEqualsAndAfter(localTime) == expected

        where:
        baseTime             | localTime                      | expected
        LocalTime.of(12, 30, 0) | LocalTime.of(12, 30, 0)          | true
        LocalTime.of(12, 30, 0) | LocalTime.of(12, 30, 1)          | false
        LocalTime.of(12, 30, 0) | LocalTime.of(12, 29, 59)         | true
    }
}
