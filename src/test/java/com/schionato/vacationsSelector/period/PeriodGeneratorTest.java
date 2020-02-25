package com.schionato.vacationsSelector.period;

import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.period.PeriodsGenerator;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeriodGeneratorTest {

    @Test
    public void checkPeriodGenerator() {
        Day startDate = new Day("01/01/2018");
        Day endDate = new Day("31/01/2018");

        List<Day> days = new PeriodsGenerator(startDate, endDate).getDays();
        assertEquals(31, days.size());

        for (int i = 0; i < 31; i++) {
            Day dia = days.get(i);
            assertEquals(i +1, dia.getDayOfMonth());
        }
    }
}