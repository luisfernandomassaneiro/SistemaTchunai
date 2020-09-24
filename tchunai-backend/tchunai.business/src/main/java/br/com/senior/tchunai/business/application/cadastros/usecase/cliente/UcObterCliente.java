package br.com.senior.tchunai.business.application.cadastros.usecase.cliente;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.ClienteRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.ClienteResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterCliente extends IdentifiedUseCase<ClienteDto, Long> {

	@Autowired
	private ClienteRepository repository;

	@Override
	protected ClienteDto execute() {
		return map(ClienteResumoMapper.class).toClienteDto(repository.require(getId()));
	}
}
