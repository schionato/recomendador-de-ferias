package com.schionato.tempo.feriado;

import com.schionato.tempo.Dia;
import com.schionato.tempo.DiaNaoTrabalhavel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feriados extends DiaNaoTrabalhavel, JpaRepository<Feriado, Long> {

    @Override
    default boolean eh(Dia dia) {
        return !findAll(Example.of(new Feriado(dia.toData()))).isEmpty();
    }
}
