package com.schionato.vacationsSelector.date;

public class PeriodValidator {

    private final Day endDate;
    private final Day startDate;

    PeriodValidator(Day startDate, Day endDate) {
        this.endDate = endDate;
        this.startDate = startDate;
    }

    void check() {
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("The end date must be greater than start date");
        }
        if (startDate.isBeforeThanToday()) {
            throw new IllegalArgumentException("The start date must be greater than today");
        }
    }
}
