package com.schionato.vacationsSelector.vacation;

import com.schionato.vacationsSelector.period.Period;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

class BestVacationsPeriodsSelector {

    private final Map<Integer, List<Vacation>> allVacationsPeriodsGroupedByDaysOff;

    BestVacationsPeriodsSelector(int daysOff, Period period) {
        this.allVacationsPeriodsGroupedByDaysOff = period.generate(daysOff).stream()
                .collect(groupingBy(Vacation::size));
    }

    public List<Vacation> getBestResults() {
        int maxDaysOffsPossible = allVacationsPeriodsGroupedByDaysOff.keySet()
                .stream()
                .mapToInt(daysOff -> daysOff)
                .max()
                .orElseThrow(RuntimeException::new);
        return allVacationsPeriodsGroupedByDaysOff.get(maxDaysOffsPossible);
    }
}
