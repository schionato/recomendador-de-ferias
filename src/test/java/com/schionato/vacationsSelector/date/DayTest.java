package com.schionato.vacationsSelector.date;

import com.schionato.vacationsSelector.date.holiday.Holidays;
import com.schionato.vacationsSelector.date.weekend.Weekends;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DayTest {

    private final List<DayOffByDefault> weekend = singletonList(new Weekends());
    private final Day yesterday = new Day(LocalDate.now().minusDays(1));
    private final Day today = new Day(LocalDate.now());

    @Test
    public void checkIfMondayIsNotDayOff() {
        Day monday = new Day("22/01/2018");
        assertFalse(monday.in(weekend));
    }

    @Test
    public void checkIfTuesdayIsNotDayOff() {
        Day tuesday = new Day("23/01/2018");
        assertFalse(tuesday.in(weekend));
    }

    @Test
    public void checkIfWednesdayIsNotDayOff() {
        Day wednesday = new Day("24/01/2018");
        assertFalse(wednesday.in(weekend));
    }

    @Test
    public void checkIfThursdayIsNotDayOff() {
        Day thursday = new Day("25/01/2018");
        assertFalse(thursday.in(weekend));
    }

    @Test
    public void checkIfFridayIsNotDayOff() {
        Day friday = new Day("26/01/2018");
        assertFalse(friday.in(weekend));
    }

    @Test
    public void checkIfSaturdayIsDayOff() {
        Day saturday = new Day("27/01/2018");
        assertTrue(saturday.in(weekend));
    }

    @Test
    public void checkIfSundayIsDayOff() {
        Day sunday = new Day("28/01/2018");
        assertTrue(sunday.in(weekend));
    }

    @Test
    public void checkIfIndependencyDayIsHoliday() {
        Holidays holidays = mock(Holidays.class);
        when(holidays.in(any())).thenReturn(true);

        Day independencyDay = new Day("07/09/2018");
        assertTrue(independencyDay.in(asList(new Weekends(), holidays)));
    }

    @Test
    public void toData() throws ParseException {
        Day day = new Day("22/09/1987");

        Date expected = new SimpleDateFormat("dd/MM/yyyy").parse("22/09/1987");

        assertFalse(expected.after(day.toData()));
        assertFalse(expected.before(day.toData()));
    }

    @Test
    public void checkIfYesterdayIsNotBeforeThanToday() {
        assertTrue(yesterday.isBefore(today));
    }

    @Test
    public void checkIfYesterdayIsNotEqualToday() {
        assertFalse(yesterday.isEqual(today));
    }

    @Test
    public void checkIfTodayIsEqualsToday() {
        assertTrue(today.isEqual(today));
    }

}