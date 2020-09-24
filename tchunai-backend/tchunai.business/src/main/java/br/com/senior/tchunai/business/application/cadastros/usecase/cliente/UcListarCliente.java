package br.com.senior.tchunai.business.application.cadastros.usecase.cliente;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Cliente;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.ClienteRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.ClienteResumoMapper;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarCliente extends QueryPaginada<ListaPaginada<ClienteResumoDto>> {

    @Autowired
    private ClienteRepository repository;

    private String nome;

    @Override
    protected ListaPaginada<ClienteResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    //filtro.and(nullSafeContainsIgnoreCase(cliente.nome, nome));

        Page<Cliente> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(ClienteResumoMapper.class).toListClienteResumoDto(page.getContent()));
    }
}
