package com.gustavo.conversor_moedas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gustavo.conversor_moedas.model.Cotacao;
import com.gustavo.conversor_moedas.repository.CotacaoRepository;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class ConversorService {
    @Autowired
    private CotacaoRepository repository;

    private String apiUrl = "https://economia.awesomeapi.com.br/json/last/";

    public Cotacao consultarCotacao(String moeda, double valor) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + moeda + "-BRL";
        try {
            String resposta = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            String chaveMoeda = moeda + "BRL";
            JsonNode node = mapper.readTree(resposta);

            String valorEncontrado = node.get(chaveMoeda).get("ask").asText();
            double valorEncontradoDouble = Double.parseDouble(valorEncontrado);
            double resultadoConvertido = valor * valorEncontradoDouble;
            resultadoConvertido = Math.round(resultadoConvertido * 100.0) / 100.0;

            Cotacao minhaCotacao = new Cotacao();
            minhaCotacao.setValor(valorEncontrado);
            minhaCotacao.setValorConvertido(resultadoConvertido);

            return minhaCotacao;
        } catch (Exception e) {
            System.out.println("Erro ao obter cotação: " + e.getMessage());
            return null;
        }
    }

    public Cotacao obterCotacao(String moeda, double valor) {
        RestTemplate restTemplate = new RestTemplate();
        String url = apiUrl + moeda + "-BRL";
        try {
            String resposta = restTemplate.getForObject(url, String.class);
            ObjectMapper mapper = new ObjectMapper();
            String chaveMoeda = moeda + "BRL";
            JsonNode node = mapper.readTree(resposta);

            String valorEncontrado = node.get(chaveMoeda).get("ask").asText();
            double valorEncontradoDouble = Double.parseDouble(valorEncontrado);
            double resultadoConvertido = valor * valorEncontradoDouble;
            resultadoConvertido = Math.round(resultadoConvertido * 100.0) / 100.0;

            Cotacao minhaCotacao = new Cotacao();
            minhaCotacao.setValor(valorEncontrado);
            minhaCotacao.setValorConvertido(resultadoConvertido);
            
            repository.save(minhaCotacao);

            return minhaCotacao;
        } catch (Exception e) {
            System.out.println("Erro ao obter cotação: " + e.getMessage());
            return null;
        }
    }
}
