package com.schionato.tempo.feriado;

import com.schionato.tempo.Dia;
import com.schionato.tempo.DiaNaoTrabalhavel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Feriados implements DiaNaoTrabalhavel {

    @PersistenceContext
    private EntityManager em;

    private boolean contains(Dia dia) {
        String hql = String.format("SELECT count(f) FROM %s f " +
                "WHERE year(f.date) = year(:data) " +
                "AND month(f.date) = month(:data) " +
                "AND day(f.date) = day(:data)", Feriado.class.getName());

        return !em.createQuery(hql, Long.class)
                .setParameter("data", dia.toData())
                .getResultList()
                .isEmpty();
    }

    @Override
    public boolean eh(Dia dia) {
        return !contains(dia);
    }
}
