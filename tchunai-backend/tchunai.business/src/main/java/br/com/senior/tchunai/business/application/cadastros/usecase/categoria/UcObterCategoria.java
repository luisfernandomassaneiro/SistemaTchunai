package br.com.senior.tchunai.business.application.cadastros.usecase.categoria;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.CategoriaRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.CategoriaResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterCategoria extends IdentifiedUseCase<CategoriaDto, Long> {

	@Autowired
	private CategoriaRepository repository;

	@Override
	protected CategoriaDto execute() {
		return map(CategoriaResumoMapper.class).toCategoriaDto(repository.require(getId()));
	}
}
