package br.com.senior.tchunai.business.application.cadastros.usecase.tamanho;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.TamanhoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.TamanhoResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterTamanho extends IdentifiedUseCase<TamanhoDto, Long> {

	@Autowired
	private TamanhoRepository repository;

	@Override
	protected TamanhoDto execute() {
		return map(TamanhoResumoMapper.class).toTamanhoDto(repository.require(getId()));
	}
}
