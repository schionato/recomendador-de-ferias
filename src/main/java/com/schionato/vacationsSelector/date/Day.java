package com.schionato.vacationsSelector.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Day {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate raw;

    Day(LocalDate raw) {
        this.raw = raw;
    }

    public Day(String date) {
        this.raw = LocalDate.parse(date, FORMATTER);
    }

    public DayOfWeek getDayOfWeek() {
        return this.raw.getDayOfWeek();
    }

    public boolean in(List<DayOffByDefault> daysOffByDefault) {
        return daysOffByDefault.stream().anyMatch(dayOff -> dayOff.in(this));
    }

    boolean isBefore(Day other) {
        return raw.isBefore(other.raw);
    }

    boolean isBeforeThanToday() {
        return raw.isBefore(LocalDate.now());
    }

    boolean isEqual(Day other) {
        return raw.isEqual(other.raw);
    }

    int getDayOfMonth() {
        return raw.getDayOfMonth();
    }

    public Day getTomorrow() {
        return new Day(raw.plusDays(1L));
    }

    public String getAsString() {
        return raw.format(FORMATTER);
    }

    public Date toData() {
        return Date.from(raw.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
