package com.schionato.tempo.feriado;

import com.schionato.tempo.Dia;
import com.schionato.tempo.VerificadorDiaUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Feriados implements VerificadorDiaUtil {

    @PersistenceContext
    private EntityManager em;

    private boolean contains(Dia dia) {
        String hql = String.format("SELECT count(f) FROM %s f " +
                "WHERE year(f.data) = year(:data) " +
                "AND month(f.data) = month(:data) " +
                "AND day(f.data) = day(:data)", Feriado.class.getName());

        return !em.createQuery(hql, Long.class)
                .setParameter("data", dia.toData())
                .getResultList()
                .isEmpty();
    }

    @Override
    public boolean check(Dia dia) {
        return contains(dia);
    }
}
