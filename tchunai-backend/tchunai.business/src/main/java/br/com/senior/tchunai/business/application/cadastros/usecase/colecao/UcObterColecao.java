package br.com.senior.tchunai.business.application.cadastros.usecase.colecao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.ColecaoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.ColecaoResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterColecao extends IdentifiedUseCase<ColecaoDto, Long> {

	@Autowired
	private ColecaoRepository repository;

	@Override
	protected ColecaoDto execute() {
		return map(ColecaoResumoMapper.class).toColecaoDto(repository.require(getId()));
	}
}
