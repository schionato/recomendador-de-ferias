package com.schionato.vacationsSelector.period;

import com.schionato.vacationsSelector.date.Day;

import java.util.ArrayList;
import java.util.List;

class PeriodsGenerator {

    private final List<Day> days;

    PeriodsGenerator(Day startDate, Day endDate) {
        this.days = new ArrayList<>();

        for (Day dia = startDate;
             dia.isBefore(endDate) || dia.isEqual(endDate);
             dia = dia.getTomorrow()) {
            days.add(dia);
        }
    }

    public List<Day> getDays() {
        return new ArrayList<>(days);
    }
}
