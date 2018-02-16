package com.schionato.mock;

import com.schionato.tempo.Dia;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.Stream;

@Configuration
public class Mock {

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    public void carregaFeriadosNacionais() {
        Dia sextaFeiraSanta = new Dia("30/03/2018");
        Dia domingoPascoa = new Dia("01/04/2018");
        Dia tiradentes = new Dia("21/04/2018");
        Dia trabalhador = new Dia("01/05/2018");
        Dia corposChrist = new Dia("31/05/2018");
        Dia revolucaoConstitucionalista = new Dia("09/07/2018");
        Dia independencia = new Dia("07/09/2018");
        Dia meuFeriado = new Dia("22/09/2018");
        Dia diaDasCriancas = new Dia("12/10/2018");
        Dia finados = new Dia("02/11/2018");
        Dia proclamacaoRepublica = new Dia("15/11/2018");
        Dia conscienciaNega = new Dia("20/11/2018");
        Dia natal = new Dia("25/12/2018");

        Stream.of(sextaFeiraSanta, domingoPascoa, tiradentes, trabalhador,
                corposChrist, revolucaoConstitucionalista, independencia,
                meuFeriado, diaDasCriancas, finados, proclamacaoRepublica,
                conscienciaNega, natal)
                .forEach(em::merge);
    }

}
