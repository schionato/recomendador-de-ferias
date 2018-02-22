package com.schionato.tempo;

import com.schionato.ferias.Ferias;

import java.util.ArrayList;
import java.util.List;

public class Periodo {

    private final List<Dia> dias;
    private final List<VerificadorDiaUtil> verificadorDiaUtils;

    private Periodo(List<Dia> dias, List<VerificadorDiaUtil> verificadorDiaUtils) {
        this.dias = new ArrayList<>(dias);
        this.verificadorDiaUtils = verificadorDiaUtils;
    }

    public Periodo(Dia dataInicial, Dia dataFinal, List<VerificadorDiaUtil> verificadorDiaUtils) {
        this.verificadorDiaUtils = verificadorDiaUtils;
        this.dias = new GeradorDePeriodo(dataInicial, dataFinal).getDias();
    }

    public List<Ferias> gerarFerias(int quantidadeDias) {
        List<Ferias> possiveisFerias = new ArrayList<>();

        for (int i = 0; i < dias.size() - quantidadeDias; i++) {
            Dia dia = dias.get(i);

            if (dia.ehFinalDeSemana()) {
                continue;
            }

            Periodo periodo = new Periodo(dias.subList(i, i + quantidadeDias), verificadorDiaUtils);

            possiveisFerias.add(new Ferias(periodo));
        }

        return possiveisFerias;
    }

    public long getQuantidadeDeDiasUteis() {
        return dias.stream().filter(dia -> dia.ehUmDiaUtil(verificadorDiaUtils)).count();
    }

    public int size() {
        return dias.size();
    }

    public Dia getUltimoDia() {
        return dias.get(dias.size() - 1);
    }

    public Dia getPrimeiroDia() {
        return dias.size() > 0 ? dias.get(0) : null;
    }

    public void add(Dia dia) {
        this.dias.add(dia);
    }

    public PeriodoDto toDto() {
        Dia primeiroDia = getPrimeiroDia();
        Dia ultimoDia = getUltimoDia();

        PeriodoDto dto = new PeriodoDto();
        dto.setDataInicio(primeiroDia.getAsString());
        dto.setDataFinal(ultimoDia.getAsString());
        return dto;
    }
}
