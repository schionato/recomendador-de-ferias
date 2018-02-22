package com.schionato.tempo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Dia {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate raw;

    Dia(LocalDate raw) {
        this.raw = raw;
    }

    public Dia(String data) {
        this.raw = LocalDate.parse(data, FORMATTER);
    }

    public DayOfWeek getDiaDaSemana() {
        return this.raw.getDayOfWeek();
    }


    public boolean estaInlcusoNos(List<DiaNaoTrabalhavel> diasNaoTrabalhaveis) {
        return diasNaoTrabalhaveis.stream().anyMatch(diaNaoTrabalhavel -> diaNaoTrabalhavel.eh(this));
    }

    boolean antes(Dia outroDia) {
        return raw.isBefore(outroDia.raw);
    }

    boolean igual(Dia outroDia) {
        return raw.isEqual(outroDia.raw);
    }

    int getDiaDoMes() {
        return raw.getDayOfMonth();
    }

    public Amanha getAmanha() {
        return new Amanha(raw.plusDays(1L));
    }

    public String getAsString() {
        return raw.format(FORMATTER);
    }

    public Date toData() {
        return Date.from(raw.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
