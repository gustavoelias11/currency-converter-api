package com.gustavo.conversor_moedas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConversorService {
    private String apiUrl = "https://economia.awesomeapi.com.br/json/last/";

    public String obterCotacao(String moeda) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + moeda + "-BRL";
        try {
            String resposta = restTemplate.getForObject(url, String.class);
            return resposta;
        } catch (Exception e) {
            return "Erro ao obter cotação: " + e.getMessage();
        }
    }
}
