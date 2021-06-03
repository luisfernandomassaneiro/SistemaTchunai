package br.com.senior.tchunai.business.application.cadastros.usecase.colecao;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Colecao;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.ColecaoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.ColecaoResumoMapper;
import static br.com.senior.tchunai.business.entity.cadastros.QColecao.colecao;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarColecao extends QueryPaginada<ListaPaginada<ColecaoResumoDto>> {

    @Autowired
    private ColecaoRepository repository;

    private String descricao;

    @Override
    protected ListaPaginada<ColecaoResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeContainsIgnoreCase(colecao.descricao, descricao));

        Page<Colecao> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(ColecaoResumoMapper.class).toListColecaoResumoDto(page.getContent()));
    }
}
