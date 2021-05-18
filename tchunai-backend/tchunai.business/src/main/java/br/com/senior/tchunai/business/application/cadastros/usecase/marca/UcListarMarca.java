package br.com.senior.tchunai.business.application.cadastros.usecase.marca;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Marca;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.MarcaRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.MarcaResumoMapper;
import static br.com.senior.tchunai.business.entity.cadastros.QMarca.marca;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarMarca extends QueryPaginada<ListaPaginada<MarcaResumoDto>> {

    @Autowired
    private MarcaRepository repository;

    private String descricao;

    @Override
    protected ListaPaginada<MarcaResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeContainsIgnoreCase(marca.descricao, descricao));

        Page<Marca> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(MarcaResumoMapper.class).toListMarcaResumoDto(page.getContent()));
    }
}
