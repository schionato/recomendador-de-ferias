import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Periodo {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final LocalDate dataInicial;
    private final LocalDate dataFinal;

    Periodo(String dataInicial, String dataFinal) {
        this.dataInicial = LocalDate.parse(dataInicial, FORMATTER);
        this.dataFinal = LocalDate.parse(dataFinal, FORMATTER);
    }

    public long getQuantidadeDeDiasUteis() {
        List<LocalDate> todosOsDias = new ArrayList<>();

        for (LocalDate dia = dataInicial; dia.isBefore(dataFinal); dia = dia.plusDays(1L)) {
            todosOsDias.add(dia);
        }

        return todosOsDias.stream().map(LocalDate::getDayOfWeek)
                .filter(day -> day.getValue() != DayOfWeek.SUNDAY.getValue())
                .filter(day -> day.getValue() != DayOfWeek.SATURDAY.getValue())
                .count();
    }
}
