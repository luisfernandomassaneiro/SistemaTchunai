package br.com.senior.tchunai.business.application.cadastros.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoRelatorioDto {

    private Long id;
    private String codigo;
    private String descricao;
    private String peso;
    private Integer quantidadeAtual;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private BigDecimal valorLucro;
    private BigDecimal percentualLucro;
    private String cor;
    private String categoria;
    private String marca;
    private String tamanho;
    private String colecao;
}
