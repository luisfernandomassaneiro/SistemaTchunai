package br.com.senior.tchunai.business.application.cadastros.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdutoDto {
    private Long id;
    private String descricao;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private Integer percentualLucro;
    private String peso;
    private boolean active;
}
