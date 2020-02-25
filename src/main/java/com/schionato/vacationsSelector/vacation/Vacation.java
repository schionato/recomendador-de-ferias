package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.date.DayOffByDefault;
import com.schionato.vacationsSelector.period.Period;

import java.util.List;

public class Vacation {

    private final Period period;
    private final List<DayOffByDefault> allDaysOffByDefault;

    public Vacation(Period period, List<DayOffByDefault> allDaysOffByDefault) {
        this.period = period;
        this.allDaysOffByDefault = allDaysOffByDefault;
        checkIfNextDayIsInDaysOffList();
    }

    private void checkIfNextDayIsInDaysOffList() {
        Day nextDay = period.getLastDay().getTomorrow();
        if (nextDay.in(allDaysOffByDefault)) {
            period.add(nextDay);
            checkIfNextDayIsInDaysOffList();
        }
    }

    public int size() {
        return period.size();
    }

    public VacationDto toDto() {
        VacationDto dto = new VacationDto();
        dto.period = this.period.toDto();
        dto.daysOff = this.size();
        return dto;
    }
}
