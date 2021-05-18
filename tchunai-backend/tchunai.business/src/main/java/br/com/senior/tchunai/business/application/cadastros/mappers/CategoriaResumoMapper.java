package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Categoria;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaDto;

@Mapper
public interface CategoriaResumoMapper {
	@IterableMapping(elementTargetType = CategoriaResumoDto.class)
	List<CategoriaResumoDto> toListCategoriaResumoDto(Iterable<Categoria> entities);
	CategoriaDto toCategoriaDto(Categoria entity);
}
