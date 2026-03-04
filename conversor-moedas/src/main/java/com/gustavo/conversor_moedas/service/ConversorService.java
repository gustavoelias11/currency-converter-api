package com.gustavo.conversor_moedas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gustavo.conversor_moedas.model.Cotacao;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class ConversorService {
    private String apiUrl = "https://economia.awesomeapi.com.br/json/last/";

    public Cotacao obterCotacao(String moeda) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + moeda + "-BRL";
        try {
            String resposta = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            String chaveMoeda = moeda + "BRL";

            JsonNode node = mapper.readTree(resposta);

            String valorEncontrado = node.get(chaveMoeda).get("ask").asText();

            Cotacao minhaCotacao = new Cotacao();
            minhaCotacao.setValor(valorEncontrado);

            return minhaCotacao;
        } catch (Exception e) {
            System.out.println("Erro ao obter cotação: " + e.getMessage());
            return null;
        }
    }
}
