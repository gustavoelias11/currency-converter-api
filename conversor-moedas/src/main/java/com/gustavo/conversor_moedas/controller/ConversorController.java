package com.gustavo.conversor_moedas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.conversor_moedas.model.Cotacao;
import com.gustavo.conversor_moedas.service.ConversorService;

@RestController
@RequestMapping("/conversor")
public class ConversorController {
    @Autowired
    private ConversorService conversorService;

    @GetMapping("/{moeda}")
    public Cotacao obterCotacao(@PathVariable String moeda) {
        return conversorService.obterCotacao(moeda);
    }
}
