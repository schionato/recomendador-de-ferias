package com.schionato.vacationsSelector.date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;

public class ValidadorPeriodTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void verifyIfStartDateIsGreaterThenFinalDate() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The end date must be greater than start date");
        new PeriodValidator(new Day("30/01/2018"), new Day("01/01/2018")).check();
    }

    @Test
    public void verifyIfStartDateIsGreaterThanToday() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("The start date must be greater than today");

        Day yesterday = new Day(LocalDate.now().minusDays(1));
        Day tomorrow = new Day(LocalDate.now().plusDays(1));
        new PeriodValidator(yesterday, tomorrow).check();
    }
}