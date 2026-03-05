package com.gustavo.conversor_moedas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.conversor_moedas.model.Cotacao;
import com.gustavo.conversor_moedas.repository.CotacaoRepository;
import com.gustavo.conversor_moedas.service.ConversorService;

@RestController
@RequestMapping("/conversor")
public class ConversorController {
    @Autowired
    private ConversorService conversorService;
    @Autowired
    private CotacaoRepository repository;

    @GetMapping("/{moeda}")
    public Cotacao obterCotacao(@PathVariable String moeda, @RequestParam double valor) {
        return conversorService.consultarCotacao(moeda, valor);
    }

    @PostMapping("/calcular/{moeda}")
    public void create(@PathVariable String moeda, @RequestParam double valor) {
        conversorService.obterCotacao(moeda, valor);
    }

    @GetMapping("/listagem")
    public List<Cotacao> obterCotacaoPost() {
        return repository.findAll();
    }
}
