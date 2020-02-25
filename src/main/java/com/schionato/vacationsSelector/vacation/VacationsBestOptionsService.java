package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.date.weekend.Weekends;
import com.schionato.vacationsSelector.date.holiday.Holidays;
import org.springframework.stereotype.Service;
import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.period.Period;

import java.util.Arrays;
import java.util.List;

@Service
class VacationsBestOptionsService {

    private final Holidays holidays;
    private final Weekends weekends;

    public VacationsBestOptionsService(Holidays holidays, Weekends weekends) {
        this.holidays = holidays;
        this.weekends = weekends;
    }

    List<Vacation> findOptions(Day startDate, Day endDate, int daysOff) {
        var allDefaultDaysOff = Arrays.asList(holidays, weekends);
        var period = new Period(startDate, endDate, allDefaultDaysOff);
        return new BestVacationsPeriodsSelector(daysOff, period).getBestResults();
    }

}
