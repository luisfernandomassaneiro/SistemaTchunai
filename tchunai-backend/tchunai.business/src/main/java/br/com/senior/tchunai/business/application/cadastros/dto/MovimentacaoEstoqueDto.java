package br.com.senior.tchunai.business.application.cadastros.dto;

import br.com.senior.tchunai.business.entity.cadastros.MovimentacaoEstoqueDetalhe;
import lombok.Data;
import br.com.senior.tchunai.business.entity.cadastros.OrigemMovimentacao;
import br.com.senior.tchunai.business.entity.cadastros.TipoMovimentacao;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ProdutoDominioDto;

import java.util.Date;
import java.util.List;

@Data
public class MovimentacaoEstoqueDto {
    private Long id;
    private Date data;
    private String notaFiscal;
    private TipoMovimentacao tipoMovimentacao;
    private OrigemMovimentacao origemMovimentacao;
    private List<MovimentacaoEstoqueDetalhe> movimentacaoEstoqueDetalhes;
}
