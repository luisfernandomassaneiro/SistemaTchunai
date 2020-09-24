package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.business.application.cadastros.mappers.ProdutoResumoMapper;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcObterProduto extends IdentifiedUseCase<ProdutoDto, Long> {

	@Autowired
	private ProdutoRepository repository;

	@Override
	protected ProdutoDto execute() {
		return map(ProdutoResumoMapper.class).toProdutoDto(repository.require(getId()));
	}
}
