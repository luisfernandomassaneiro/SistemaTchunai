package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Tamanho;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoDto;

@Mapper
public interface TamanhoResumoMapper {
	@IterableMapping(elementTargetType = TamanhoResumoDto.class)
	List<TamanhoResumoDto> toListTamanhoResumoDto(Iterable<Tamanho> entities);
	TamanhoDto toTamanhoDto(Tamanho entity);
}
