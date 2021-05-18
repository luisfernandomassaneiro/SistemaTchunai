package br.com.senior.tchunai.business.application.cadastros.usecase.tamanho;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Tamanho;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.TamanhoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.TamanhoResumoMapper;
import static br.com.senior.tchunai.business.entity.cadastros.QTamanho.tamanho;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarTamanho extends QueryPaginada<ListaPaginada<TamanhoResumoDto>> {

    @Autowired
    private TamanhoRepository repository;

    private String descricao;

    @Override
    protected ListaPaginada<TamanhoResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeContainsIgnoreCase(tamanho.descricao, descricao));

        Page<Tamanho> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(TamanhoResumoMapper.class).toListTamanhoResumoDto(page.getContent()));
    }
}
