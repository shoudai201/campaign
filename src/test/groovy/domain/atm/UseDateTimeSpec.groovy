package domain.atm

import domain.atm.UseDateTime
import domain.atm.UseTime

import java.time.DayOfWeek
import java.time.LocalDateTime
import spock.lang.Specification

import java.time.LocalTime

class UseDateTimeSpec extends Specification {
    def "isSaturdayOrSunday のテスト"() {
        setup:
        def useDateTime = new UseDateTime(LocalDateTime.of(2023, 1, 1, 12, 0, 0).with(dayOfWeek))

        expect:
        useDateTime.isSaturdayOrSunday() == expected

        where:
        dayOfWeek               | expected
        DayOfWeek.MONDAY        | false
        DayOfWeek.TUESDAY       | false
        DayOfWeek.WEDNESDAY     | false
        DayOfWeek.THURSDAY      | false
        DayOfWeek.FRIDAY        | false
        DayOfWeek.SATURDAY      | true
        DayOfWeek.SUNDAY        | true
    }

    def "isWeekDay のテスト"() {
        setup:
        def useDateTime = new UseDateTime(LocalDateTime.of(2023, 1, 1, 12, 0, 0).with(dayOfWeek))

        expect:
        useDateTime.isWeekDay() == expected

        where:
        dayOfWeek               | expected
        DayOfWeek.MONDAY        | true
        DayOfWeek.TUESDAY       | true
        DayOfWeek.WEDNESDAY     | true
        DayOfWeek.THURSDAY      | true
        DayOfWeek.FRIDAY        | true
        DayOfWeek.SATURDAY      | false
        DayOfWeek.SUNDAY        | false
    }

    def "getUseTime のテスト"() {
        setup:
        def useDateTime = new UseDateTime( LocalDateTime.of(2023, 1, 1, 12, 30, 0))
        def expectTime = new UseTime(LocalTime.of(12,30,0))

        expect:
        useDateTime.getUseTime() == expectTime
    }
}
