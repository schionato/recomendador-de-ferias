import java.time.LocalDate;

class Amanha extends Dia {

    public Amanha(LocalDate raw) {
        super(raw);
    }

    Amanha() {
        super(LocalDate.now().plusDays(1L));
    }

}
