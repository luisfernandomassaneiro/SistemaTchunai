package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Colecao;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoDto;

@Mapper
public interface ColecaoResumoMapper {
	@IterableMapping(elementTargetType = ColecaoResumoDto.class)
	List<ColecaoResumoDto> toListColecaoResumoDto(Iterable<Colecao> entities);
	ColecaoDto toColecaoDto(Colecao entity);
}
