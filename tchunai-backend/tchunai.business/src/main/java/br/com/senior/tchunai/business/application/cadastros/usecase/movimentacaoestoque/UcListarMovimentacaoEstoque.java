package br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.MovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.MovimentacaoEstoqueRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.MovimentacaoEstoqueResumoMapper;
import static br.com.senior.tchunai.business.entity.cadastros.QMovimentacaoEstoque.movimentacaoEstoque;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarMovimentacaoEstoque extends QueryPaginada<ListaPaginada<MovimentacaoEstoqueResumoDto>> {

    @Autowired
    private MovimentacaoEstoqueRepository repository;

    private String notaFiscal;

    @Override
    protected ListaPaginada<MovimentacaoEstoqueResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeContainsIgnoreCase(movimentacaoEstoque.notaFiscal, notaFiscal));

        Page<MovimentacaoEstoque> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(MovimentacaoEstoqueResumoMapper.class).toListMovimentacaoEstoqueResumoDto(page.getContent()));
    }
}
