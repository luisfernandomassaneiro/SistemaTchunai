package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.*;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.mappers.ProdutoResumoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Categoria;
import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import static br.com.senior.tchunai.business.entity.cadastros.QProduto.produto;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.nullSafeContainsIgnoreCase;

@Setter
public class UcListarProduto extends QueryPaginada<ListaPaginada<ProdutoResumoDto>> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;
    private CorDominioDto cor;
    private Categoria categoria;
    private MarcaDominioDto marca;
    private TamanhoDominioDto tamanho;
    private ColecaoDominioDto colecao;
    private String codigoBarras;

    @Override
    protected ListaPaginada<ProdutoResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeContainsIgnoreCase(produto.descricao, descricao));
        filtro.and(nullSafeContainsIgnoreCase(produto.codigoBarras, codigoBarras));

        Page<Produto> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(ProdutoResumoMapper.class).toListProdutoResumoDto(page.getContent()));
    }
}
