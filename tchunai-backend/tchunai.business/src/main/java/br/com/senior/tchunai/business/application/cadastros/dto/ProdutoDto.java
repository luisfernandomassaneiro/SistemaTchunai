package br.com.senior.tchunai.business.application.cadastros.dto;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CategoriaDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CorDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.MarcaDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.TamanhoDominioDto;
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
    private Integer quantidadeAtual;
    private CorDominioDto cor;
    private CategoriaDominioDto categoria;
    private MarcaDominioDto marca;
    private TamanhoDominioDto tamanho;
    private String codigoBarras;
}
