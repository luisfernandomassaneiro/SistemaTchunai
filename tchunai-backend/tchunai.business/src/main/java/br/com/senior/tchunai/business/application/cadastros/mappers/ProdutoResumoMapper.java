package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;

@Mapper
public interface ProdutoResumoMapper {
	@IterableMapping(elementTargetType = ProdutoResumoDto.class)
	List<ProdutoResumoDto> toListProdutoResumoDto(Iterable<Produto> entities);
	ProdutoDto toProdutoDto(Produto entity);
}
