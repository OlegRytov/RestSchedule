package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

public class RestScheduleTest {

    @ParameterizedTest
/*    @CsvSource({
            "10000,3000,20000"
    })

 */
    @CsvFileSource(files = "src/test/resources/RestScheduleFinanse.csv")
    void testCalculateRestSchedule(int income, int expenses, int threshold) {
        RestSchedule service = new RestSchedule();
        int monthsOfRest = service.CalculateRestSchedule(income, expenses, threshold);

        Assertions.assertEquals(3, monthsOfRest);
    }

    @ParameterizedTest
/*      @CsvSource({
             "100000,60000,150000"
     })

 */
    @CsvFileSource(files = "src/test/resources/RestScheduleFinanseRich.csv")
    void testCalculateRestScheduleRich(int income, int expenses, int threshold) {
        RestSchedule service = new RestSchedule();
        int monthsOfRest = service.CalculateRestSchedule(income, expenses, threshold);

        Assertions.assertEquals(2, monthsOfRest);
    }

}
