package tempo;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class FinalDeSemana {

    private static final List<Integer> DIAS_FINAL_DE_SEMANA = Arrays.asList(
            DayOfWeek.SUNDAY.getValue(),
            DayOfWeek.SATURDAY.getValue()
    );

    private FinalDeSemana() {}

    static boolean contains(int dia) {
        return DIAS_FINAL_DE_SEMANA.contains(dia);
    }
}
