package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.date.weekend.Weekends;
import com.schionato.vacationsSelector.date.DayOffByDefault;
import org.junit.Before;
import org.junit.Test;
import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.period.Period;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BestVacationsPeriodsSelectorTest {

    private List<DayOffByDefault> daysOff;

    @Before
    public void setUp() {
        daysOff = Collections.singletonList(new Weekends());
    }

    @Test
    public void findBestPeriod() {
        Day startDate = new Day("01/01/9999");
        Day endDate = new Day("31/01/9999");

        Period period = new Period(startDate, endDate, daysOff);

        List<Vacation> bestResults = new BestVacationsPeriodsSelector(10, period).getBestResults();

        assertEquals(3, bestResults.size());

        bestResults.stream().mapToInt(Vacation::size).forEach(daysOff -> assertEquals(12, daysOff));
    }

    @Test
    public void addWeekends() {
        Day monday = new Day("04/01/9999");
        Day otherMonday = new Day("11/01/9999");

        Period period = new Period(monday, otherMonday, daysOff);

        List<Vacation> bestResults = new BestVacationsPeriodsSelector(5, period).getBestResults();

        assertEquals(7, bestResults.get(0).size());
    }

}