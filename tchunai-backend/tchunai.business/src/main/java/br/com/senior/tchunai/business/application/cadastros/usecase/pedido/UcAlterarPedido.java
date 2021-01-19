package br.com.senior.tchunai.business.application.cadastros.usecase.pedido;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;

import br.com.senior.tchunai.business.application.cadastros.mappers.PedidoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Pedido;
import br.com.senior.tchunai.business.repository.cadastros.PedidoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ClienteDominioDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class UcAlterarPedido extends IdentifiedUseCase<PedidoDto, Long> {

    @Autowired
    private PedidoRepository repository;

    private LocalDateTime data;
    @NotNull(message="pedido.cliente.required")
    private ClienteDominioDto cliente;
    @NotNull(message="pedido.valorTotal.required")
    private BigDecimal valorTotal;
    @Override
    protected PedidoDto execute() {
        Pedido entity = repository.require(getId());
        map(PedidoMapper.class).updatePedido(this, entity);
        repository.save(entity);
        return map(PedidoMapper.class).toPedidoDto(entity);
    }
}
