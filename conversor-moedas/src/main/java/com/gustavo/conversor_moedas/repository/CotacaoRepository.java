package com.gustavo.conversor_moedas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gustavo.conversor_moedas.model.Cotacao;

public interface CotacaoRepository extends JpaRepository <Cotacao, Long>{

}
