package br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.MovimentacaoEstoqueRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.MovimentacaoEstoqueResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterMovimentacaoEstoque extends IdentifiedUseCase<MovimentacaoEstoqueDto, Long> {

	@Autowired
	private MovimentacaoEstoqueRepository repository;

	@Override
	protected MovimentacaoEstoqueDto execute() {
		return map(MovimentacaoEstoqueResumoMapper.class).toMovimentacaoEstoqueDto(repository.require(getId()));
	}
}
