package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.ProdutoResumoMapper;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarProduto extends QueryPaginada<ListaPaginada<ProdutoResumoDto>> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;

    @Override
    protected ListaPaginada<ProdutoResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    // filtro.and(nullSafeContainsIgnoreCase(produto.descricao, descricao));

        Page<Produto> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(ProdutoResumoMapper.class).toListProdutoResumoDto(page.getContent()));
    }
}
