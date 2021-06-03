package br.com.senior.tchunai.business.application.cadastros.dto;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.*;
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
    private ColecaoDominioDto colecao;
    private String codigoBarras;
}
