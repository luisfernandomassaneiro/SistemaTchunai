package br.com.senior.tchunai.business.application.cadastros.usecase.cor;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Cor;
import br.com.senior.tchunai.business.application.cadastros.dto.CorResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.CorRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.CorResumoMapper;
import static br.com.senior.tchunai.business.entity.cadastros.QCor.cor;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarCor extends QueryPaginada<ListaPaginada<CorResumoDto>> {

    @Autowired
    private CorRepository repository;

    private String descricao;

    @Override
    protected ListaPaginada<CorResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeContainsIgnoreCase(cor.descricao, descricao));

        Page<Cor> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(CorResumoMapper.class).toListCorResumoDto(page.getContent()));
    }
}
