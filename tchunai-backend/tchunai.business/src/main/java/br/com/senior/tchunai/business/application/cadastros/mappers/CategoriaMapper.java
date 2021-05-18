package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Categoria;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.categoria.UcAlterarCategoria;
import br.com.senior.tchunai.business.application.cadastros.usecase.categoria.UcIncluirCategoria;

@Mapper
public interface CategoriaMapper {
    CategoriaDto toCategoriaDto(Categoria entity);
    Categoria toCategoria(UcIncluirCategoria dto);
    void updateCategoria(UcAlterarCategoria dto, @MappingTarget Categoria entity);
}
