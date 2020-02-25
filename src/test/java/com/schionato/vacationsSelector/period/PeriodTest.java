package com.schionato.vacationsSelector.period;

import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.date.DayOffByDefault;
import com.schionato.vacationsSelector.date.weekend.Weekends;
import com.schionato.vacationsSelector.vacation.Vacation;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeriodTest {

    private List<DayOffByDefault> daysOff;

    @Before
    public void setUp() {
        daysOff = Collections.singletonList(new Weekends());
    }

    @Test
    public void countBusinessDay() {
        Day startDate = new Day("01/01/9999");
        Day endDate = new Day("30/01/9999");

        Period period = new Period(startDate, endDate, daysOff);
        assertEquals(21, period.countBusinessDay());
    }

    @Test
    public void countSubPeriods() {
        Day startDate = new Day("01/01/9999");
        Day endDate = new Day("30/01/9999");

        Period period = new Period(startDate, endDate, daysOff);
        List<Vacation> periods = period.generate(10);

        assertEquals(14, periods.size());
        assertEquals(12, periods.stream().mapToInt(Vacation::size).max().orElse(0));
    }
}