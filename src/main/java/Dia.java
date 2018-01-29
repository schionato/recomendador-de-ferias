import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Dia {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate raw;

    Dia(LocalDate raw) {
        this.raw = raw;
    }

    Dia(String data) {
        this.raw = LocalDate.parse(data, FORMATTER);
    }

    boolean ehUmDiaUtil() {
        int diaDaSemana = this.raw.getDayOfWeek().getValue();
        return !FinalDeSemana.contains(diaDaSemana);
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

    Amanha getAmanha() {
        return new Amanha(raw.plusDays(1L));
    }
}
