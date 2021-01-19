package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Pedido;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoDto;

@Mapper
public interface PedidoResumoMapper {
	@IterableMapping(elementTargetType = PedidoResumoDto.class)
	List<PedidoResumoDto> toListPedidoResumoDto(Iterable<Pedido> entities);
	PedidoDto toPedidoDto(Pedido entity);
}
