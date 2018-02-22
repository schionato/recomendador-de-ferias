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

    //TODO rename para ehIncluso(List<DiaNaoTrabalhavel> diasNaoTrabalhaveis)
    boolean ehUmDiaUtil(List<VerificadorDiaUtil> verificadores) {
        return verificadores.stream().allMatch(verificador -> verificador.check(this));
    }

    //TODO mover para a nova estrutura
    public boolean ehFinalDeSemana() {
        return FinalDeSemana.contains(this.raw.getDayOfWeek().getValue());
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
