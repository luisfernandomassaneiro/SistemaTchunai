package br.com.senior.tchunai.business.application.cadastros.usecase.pedido;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import br.com.senior.tchunai.business.entity.cadastros.Pedido;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoResumoDto;
import br.com.senior.tchunai.business.repository.cadastros.PedidoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.PedidoResumoMapper;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static br.com.senior.tchunai.business.entity.cadastros.QPedido.pedido;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.*;

@Setter
public class UcListarPedido extends QueryPaginada<ListaPaginada<PedidoResumoDto>> {

    @Autowired
    private PedidoRepository repository;

    private LocalDateTime data;
    private Long cliente;
    private BigDecimal valorTotal;

    @Override
    protected ListaPaginada<PedidoResumoDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
	    filtro.and(nullSafeEq(pedido.data, data));
        filtro.and(nullSafeEq(pedido.cliente.id, cliente));
	    filtro.and(nullSafeEq(pedido.valorTotal, valorTotal));

        Page<Pedido> page = repository.findAll(filtro, getPage());
        return new ListaPaginada<>(page.getTotalElements(), page.getTotalPages(),
            map(PedidoResumoMapper.class).toListPedidoResumoDto(page.getContent()));
    }
}
