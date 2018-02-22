package com.schionato.tempo;

import java.time.LocalDate;

class Amanha extends Dia {

    Amanha() {
        super(LocalDate.now().plusDays(1));
    }

    Amanha(LocalDate raw) {
        super(raw);
    }

}
