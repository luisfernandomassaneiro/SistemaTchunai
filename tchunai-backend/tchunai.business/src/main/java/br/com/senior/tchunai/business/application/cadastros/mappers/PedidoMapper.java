package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Pedido;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.pedido.UcAlterarPedido;
import br.com.senior.tchunai.business.application.cadastros.usecase.pedido.UcIncluirPedido;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ClienteDominioDto;
import br.com.senior.tchunai.business.entity.cadastros.Cliente;

@Mapper
public interface PedidoMapper {
    Cliente toCliente(ClienteDominioDto dto);
    PedidoDto toPedidoDto(Pedido entity);
    Pedido toPedido(UcIncluirPedido dto);
    void updatePedido(UcAlterarPedido dto, @MappingTarget Pedido entity);
}
