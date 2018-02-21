package com.schionato.tempo.feriado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "FERIADO")
class Feriado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date date;

    private Feriado() {} //JPA compatibility

    public Feriado(Date date) {
        this.date = date;
    }
}
