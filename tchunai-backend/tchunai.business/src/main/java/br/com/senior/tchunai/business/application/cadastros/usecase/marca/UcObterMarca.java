package br.com.senior.tchunai.business.application.cadastros.usecase.marca;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.MarcaRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.MarcaResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterMarca extends IdentifiedUseCase<MarcaDto, Long> {

	@Autowired
	private MarcaRepository repository;

	@Override
	protected MarcaDto execute() {
		return map(MarcaResumoMapper.class).toMarcaDto(repository.require(getId()));
	}
}
