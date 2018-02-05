package com.schionato.ferias;

import org.springframework.stereotype.Service;
import com.schionato.tempo.Dia;
import com.schionato.tempo.Periodo;

import java.util.List;

@Service
class AnalisadorDeFeriasService {

    List<Ferias> analise(Dia dataInicio, Dia dataFinal, int quantidadeDias) {
        Periodo periodo = new Periodo(dataInicio, dataFinal);
        return new CalculadorDeFerias(quantidadeDias, periodo).getMelhoresResultados();
    }

}
