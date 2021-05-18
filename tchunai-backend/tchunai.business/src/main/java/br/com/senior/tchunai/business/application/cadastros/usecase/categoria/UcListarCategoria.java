package br.com.senior.tchunai.business.application.cadastros.usecase.categoria;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Categoria;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.CategoriaRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.CategoriaResumoMapper;
import static br.com.senior.tchunai.business.entity.cadastros.QCategoria.categoria;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarCategoria extends QueryPaginada<ListaPaginada<CategoriaResumoDto>> {

    @Autowired
    private CategoriaRepository repository;

    private String descricao;

    @Override
    protected ListaPaginada<CategoriaResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeContainsIgnoreCase(categoria.descricao, descricao));

        Page<Categoria> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(CategoriaResumoMapper.class).toListCategoriaResumoDto(page.getContent()));
    }
}
