package br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;

import br.com.senior.tchunai.business.application.cadastros.mappers.MovimentacaoEstoqueMapper;
import br.com.senior.tchunai.business.entity.cadastros.MovimentacaoEstoque;
import br.com.senior.tchunai.business.repository.cadastros.MovimentacaoEstoqueRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ProdutoDominioDto;
import br.com.senior.tchunai.business.entity.cadastros.OrigemMovimentacao;
import br.com.senior.tchunai.business.entity.cadastros.TipoMovimentacao;

@Getter
@Setter
public class UcAlterarMovimentacaoEstoque extends IdentifiedUseCase<MovimentacaoEstoqueDto, Long> {

    @Autowired
    private MovimentacaoEstoqueRepository repository;

    private String nome;
    @NotNull(message="movimentacaoEstoque.produto.required")
    private ProdutoDominioDto produto;
    private TipoMovimentacao tipoMovimentacao;
    private OrigemMovimentacao origemMovimentacao;
    @Override
    protected MovimentacaoEstoqueDto execute() {
        MovimentacaoEstoque entity = repository.require(getId());
        map(MovimentacaoEstoqueMapper.class).updateMovimentacaoEstoque(this, entity);
        repository.save(entity);
        return map(MovimentacaoEstoqueMapper.class).toMovimentacaoEstoqueDto(entity);
    }
}
