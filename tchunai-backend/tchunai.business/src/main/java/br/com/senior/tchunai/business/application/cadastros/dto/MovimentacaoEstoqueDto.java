package br.com.senior.tchunai.business.application.cadastros.dto;

import lombok.Data;
import br.com.senior.tchunai.business.entity.cadastros.OrigemMovimentacao;
import br.com.senior.tchunai.business.entity.cadastros.TipoMovimentacao;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ProdutoDominioDto;

@Data
public class MovimentacaoEstoqueDto {
    private Long id;
    private String nome;
    private ProdutoDominioDto produto;
    private TipoMovimentacao tipoMovimentacao;
    private OrigemMovimentacao origemMovimentacao;
}
