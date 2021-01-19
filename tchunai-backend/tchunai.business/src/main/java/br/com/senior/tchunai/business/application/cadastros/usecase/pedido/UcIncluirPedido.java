package br.com.senior.tchunai.business.application.cadastros.usecase.pedido;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotNull;

import br.com.senior.tchunai.business.application.cadastros.mappers.PedidoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Pedido;
import br.com.senior.tchunai.business.repository.cadastros.PedidoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ClienteDominioDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class UcIncluirPedido extends UseCase<PedidoDto> {

    @Autowired
    private PedidoRepository repository;

    private LocalDateTime data;
    @NotNull(message="pedido.cliente.required")
    private ClienteDominioDto cliente;
    @NotNull(message="pedido.valorTotal.required")
    private BigDecimal valorTotal;
    @Override
    protected PedidoDto execute() {
        Pedido dto = map(PedidoMapper.class).toPedido(this);
        repository.save(dto);
        return map(PedidoMapper.class).toPedidoDto(dto);
    }
}
