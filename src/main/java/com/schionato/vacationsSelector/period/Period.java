package com.schionato.vacationsSelector.period;

import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.date.DayOffByDefault;
import com.schionato.vacationsSelector.vacation.Vacation;

import java.util.ArrayList;
import java.util.List;

public class Period {

    private final List<Day> days;
    private final List<DayOffByDefault> daysOffByDefault;

    private Period(List<Day> days, List<DayOffByDefault> daysOffByDefault) {
        this.days = new ArrayList<>(days);
        this.daysOffByDefault = daysOffByDefault;
    }

    public Period(Day startDate, Day endDate, List<DayOffByDefault> daysOffByDefault) {
        new PeriodValidator(startDate, endDate).check();

        this.daysOffByDefault = daysOffByDefault;
        this.days = new PeriodsGenerator(startDate, endDate).getDays();
    }

    public List<Vacation> generate(int daysOffQuantity) {
        List<Vacation> allVacationOptions = new ArrayList<>();

        for (int i = 0; i < days.size() - daysOffQuantity; i++) {
            Day day = days.get(i);
            if (day.in(daysOffByDefault)) {
                continue;
            }

            Period period = new Period(days.subList(i, i + daysOffQuantity), daysOffByDefault);
            allVacationOptions.add(new Vacation(period, daysOffByDefault));
        }

        return allVacationOptions;
    }

    public long countBusinessDay() {
        return days.stream().filter(day -> !day.in(daysOffByDefault)).count();
    }

    public int size() {
        return days.size();
    }

    public Day getLastDay() {
        return days.get(days.size() - 1);
    }

    public Day getFirstDay() {
        return days.isEmpty() ? null : days.get(0);
    }

    public void add(Day day) {
        this.days.add(day);
    }

    public PeriodDto toDto() {
        PeriodDto dto = new PeriodDto();
        dto.startDate = getFirstDay().getAsString();
        dto.endDate = getLastDay().getAsString();
        return dto;
    }
}
