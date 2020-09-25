package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.MovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueDto;

@Mapper
public interface MovimentacaoEstoqueResumoMapper {
	@IterableMapping(elementTargetType = MovimentacaoEstoqueResumoDto.class)
	List<MovimentacaoEstoqueResumoDto> toListMovimentacaoEstoqueResumoDto(Iterable<MovimentacaoEstoque> entities);
	MovimentacaoEstoqueDto toMovimentacaoEstoqueDto(MovimentacaoEstoque entity);
}
