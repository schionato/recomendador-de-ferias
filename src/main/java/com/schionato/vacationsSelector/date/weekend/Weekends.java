package com.schionato.vacationsSelector.date.weekend;

import com.schionato.vacationsSelector.date.Day;
import com.schionato.vacationsSelector.date.DayOffByDefault;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

@Component
public class Weekends implements DayOffByDefault {

    private static final List<Integer> WEEKEND_DAYS = Arrays.asList(
            DayOfWeek.SUNDAY.getValue(),
            DayOfWeek.SATURDAY.getValue()
    );

    @Override
    public boolean in(Day day) {
        return WEEKEND_DAYS.contains(day.getDayOfWeek().getValue());
    }
}
