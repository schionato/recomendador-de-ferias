import java.time.LocalDate;

class Ontem extends Dia {

    protected Ontem() {
        super(LocalDate.now().minusDays(1));
    }

}
