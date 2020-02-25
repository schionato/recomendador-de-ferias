package com.schionato.ferias;

import com.schionato.tempo.Dia;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/analises")
public class AnalisadorDeFeriasController {

    private final AnalisadorDeFeriasService service;

    public AnalisadorDeFeriasController(AnalisadorDeFeriasService service) {
        this.service = service;
    }

    @GetMapping()
    public List<FeriasDto> analisaPorPeriodo(@RequestParam("data-inicio") String dataInicio,
                                             @RequestParam("data-fim") String dataFinal,
                                             @RequestParam("quantidade") int quantidadeDias) {

        Dia inicio = new Dia(dataInicio);
        Dia fim = new Dia(dataFinal);
        return service.analise(inicio, fim, quantidadeDias).stream()
                .map(Ferias::toDto)
                .collect(Collectors.toList());
    }

}
