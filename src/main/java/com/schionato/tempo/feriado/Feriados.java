package com.schionato.tempo.feriado;

import com.schionato.tempo.Dia;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Feriados {

    @PersistenceContext
    private EntityManager em;

    public boolean contains(Dia dia) {
        String hql = String.format("SELECT count(f) FROM %s f " +
                "WHERE year(f.data) = year(:data) " +
                "AND month(f.data) = month(:data) " +
                "AND day(f.data) = day(:data)", Feriado.class.getName());

        return !em.createQuery(hql, Long.class)
                .setParameter("data", dia.toData())
                .getResultList()
                .isEmpty();
    }

}
