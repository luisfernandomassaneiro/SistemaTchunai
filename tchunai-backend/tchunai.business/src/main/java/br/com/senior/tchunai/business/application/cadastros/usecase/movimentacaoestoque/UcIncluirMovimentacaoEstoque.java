package br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque;

import br.com.senior.tchunai.business.entity.cadastros.*;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.commom.exceptions.BusinessException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;

import br.com.senior.tchunai.business.application.cadastros.mappers.MovimentacaoEstoqueMapper;
import br.com.senior.tchunai.business.repository.cadastros.MovimentacaoEstoqueRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ProdutoDominioDto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UcIncluirMovimentacaoEstoque extends UseCase<MovimentacaoEstoqueDto> {

    @Autowired
    private MovimentacaoEstoqueRepository repository;
    @Autowired
    private ProdutoRepository produtoRepository;

    private Date data;
    private String notaFiscal;
    private TipoMovimentacao tipoMovimentacao;
    private OrigemMovimentacao origemMovimentacao;
    private List<MovimentacaoEstoqueDetalhe> movimentacaoEstoqueDetalhes;
    @Override
    protected MovimentacaoEstoqueDto execute() {
        List<Produto> produtoList = new ArrayList<>();
        MovimentacaoEstoque movimentacaoEstoque = map(MovimentacaoEstoqueMapper.class).toMovimentacaoEstoque(this);
        if (!movimentacaoEstoque.getMovimentacaoEstoqueDetalhes().isEmpty()) {
            movimentacaoEstoque.getMovimentacaoEstoqueDetalhes().forEach(movimentacaoEstoqueDetalhe -> {
                movimentacaoEstoqueDetalhe.setMovimentacaoEstoque(movimentacaoEstoque);
                movimentacaoEstoqueDetalhe.getProduto().alteraQuantidade(movimentacaoEstoque.getTipoMovimentacao(), movimentacaoEstoqueDetalhe.getQuantidade());
                produtoList.add(movimentacaoEstoqueDetalhe.getProduto());
            });
        } else {
            throw new BusinessException("general.message.estoque.produtos_obrigatorios");
        }
        movimentacaoEstoque.setOrigemMovimentacao(OrigemMovimentacao.ESTOQUE);
        repository.save(movimentacaoEstoque);
        produtoRepository.saveAll(produtoList);
        return map(MovimentacaoEstoqueMapper.class).toMovimentacaoEstoqueDto(movimentacaoEstoque);
    }
}
