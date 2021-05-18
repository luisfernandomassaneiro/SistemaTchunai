package br.com.senior.tchunai.business.application.cadastros.usecase.cor;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.CorRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.CorResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.CorDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterCor extends IdentifiedUseCase<CorDto, Long> {

	@Autowired
	private CorRepository repository;

	@Override
	protected CorDto execute() {
		return map(CorResumoMapper.class).toCorDto(repository.require(getId()));
	}
}
