package com.schionato.tempo;

import java.time.LocalDate;

class Ontem extends Dia {

    Ontem() {
        super(LocalDate.now().minusDays(1));
    }

}
