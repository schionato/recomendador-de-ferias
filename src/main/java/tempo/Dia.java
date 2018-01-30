package tempo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dia {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate raw;

    Dia(LocalDate raw) {
        this.raw = raw;
    }

    public Dia(String data) {
        this.raw = LocalDate.parse(data, FORMATTER);
    }

    boolean ehUmDiaUtil() {
        return !FinalDeSemana.contains(this.raw.getDayOfWeek().getValue());
    }

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
}
