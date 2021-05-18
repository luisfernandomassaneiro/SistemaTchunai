package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Cor;
import br.com.senior.tchunai.business.application.cadastros.dto.CorResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.CorDto;

@Mapper
public interface CorResumoMapper {
	@IterableMapping(elementTargetType = CorResumoDto.class)
	List<CorResumoDto> toListCorResumoDto(Iterable<Cor> entities);
	CorDto toCorDto(Cor entity);
}
