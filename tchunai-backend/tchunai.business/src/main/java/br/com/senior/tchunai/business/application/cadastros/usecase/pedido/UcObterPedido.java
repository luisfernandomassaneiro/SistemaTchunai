package br.com.senior.tchunai.business.application.cadastros.usecase.pedido;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.PedidoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.PedidoResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterPedido extends IdentifiedUseCase<PedidoDto, Long> {

	@Autowired
	private PedidoRepository repository;

	@Override
	protected PedidoDto execute() {
		return map(PedidoResumoMapper.class).toPedidoDto(repository.require(getId()));
	}
}
