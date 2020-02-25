package com.schionato.ferias;

import com.schionato.tempo.DiaNaoTrabalhavel;
import com.schionato.tempo.FinalDeSemana;
import com.schionato.tempo.feriado.Feriados;
import org.springframework.stereotype.Service;
import com.schionato.tempo.Dia;
import com.schionato.tempo.Periodo;

import java.util.Arrays;
import java.util.List;

@Service
class AnalisadorDeFeriasService {

    private final Feriados feriados;
    private final FinalDeSemana finaisDeSemana;

    public AnalisadorDeFeriasService(Feriados feriados, FinalDeSemana finaisDeSemana) {
        this.feriados = feriados;
        this.finaisDeSemana = finaisDeSemana;
    }

    List<Ferias> analise(Dia dataInicio, Dia dataFinal, int quantidadeDias) {
        List<DiaNaoTrabalhavel> diasNaoTrabalhaveis = Arrays.asList(feriados, finaisDeSemana);
        Periodo periodo = new Periodo(dataInicio, dataFinal, diasNaoTrabalhaveis);

        return new CalculadorDeFerias(quantidadeDias, periodo).getMelhoresResultados();
    }

}
