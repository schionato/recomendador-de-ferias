package com.schionato.ferias;

import com.schionato.tempo.DiaNaoTrabalhavel;
import org.springframework.stereotype.Service;
import com.schionato.tempo.Dia;
import com.schionato.tempo.Periodo;

import java.util.List;

@Service
class AnalisadorDeFeriasService {

    List<Ferias> analise(Dia dataInicio, Dia dataFinal, int quantidadeDias) {
        List<DiaNaoTrabalhavel> diasNaoTrabalhaveis = DiaNaoTrabalhavel.getDefault();
        Periodo periodo = new Periodo(dataInicio, dataFinal, diasNaoTrabalhaveis);

        return new CalculadorDeFerias(quantidadeDias, periodo).getMelhoresResultados();
    }

}
