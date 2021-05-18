package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Marca;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaDto;

@Mapper
public interface MarcaResumoMapper {
	@IterableMapping(elementTargetType = MarcaResumoDto.class)
	List<MarcaResumoDto> toListMarcaResumoDto(Iterable<Marca> entities);
	MarcaDto toMarcaDto(Marca entity);
}
