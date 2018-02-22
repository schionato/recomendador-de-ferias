package com.schionato.tempo;

import com.schionato.ferias.Ferias;

import java.util.ArrayList;
import java.util.List;

public class Periodo {

    private final List<Dia> dias;
    private final List<DiaNaoTrabalhavel> diasNaoTrabalhaveis;

    private Periodo(List<Dia> dias, List<DiaNaoTrabalhavel> diasNaoTrabalhaveis) {
        this.dias = new ArrayList<>(dias);
        this.diasNaoTrabalhaveis = diasNaoTrabalhaveis;
    }

    public Periodo(Dia dataInicial, Dia dataFinal, List<DiaNaoTrabalhavel> diasNaoTrabalhaveis) {
        this.diasNaoTrabalhaveis = diasNaoTrabalhaveis;
        this.dias = new GeradorDePeriodo(dataInicial, dataFinal).getDias();
    }

    public List<Ferias> gerarFerias(int quantidadeDias) {
        List<Ferias> possiveisFerias = new ArrayList<>();

        for (int i = 0; i < dias.size() - quantidadeDias; i++) {
            Dia dia = dias.get(i);

            if (dia.estaInlcusoNos(diasNaoTrabalhaveis)) {
                continue;
            }

            Periodo periodo = new Periodo(dias.subList(i, i + quantidadeDias), diasNaoTrabalhaveis);

            possiveisFerias.add(new Ferias(periodo, diasNaoTrabalhaveis));
        }

        return possiveisFerias;
    }

    public long getQuantidadeDeDiasUteis() {
        return dias.stream().filter(dia -> !dia.estaInlcusoNos(diasNaoTrabalhaveis)).count();
    }

    public int size() {
        return dias.size();
    }

    public Dia getUltimoDia() {
        return dias.get(dias.size() - 1);
    }

    public Dia getPrimeiroDia() {
        return dias.isEmpty() ? null : dias.get(0);
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
