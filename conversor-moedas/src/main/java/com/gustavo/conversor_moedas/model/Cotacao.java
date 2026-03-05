package com.gustavo.conversor_moedas.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Cotacao {
    @JsonProperty("ask")
    private String valor;
    private double valorConvertido;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public void setValorConvertido(double valorConvertido) {
        this.valorConvertido = valorConvertido;
    }
}
