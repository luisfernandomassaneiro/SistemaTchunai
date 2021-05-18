package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Marca;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.marca.UcAlterarMarca;
import br.com.senior.tchunai.business.application.cadastros.usecase.marca.UcIncluirMarca;

@Mapper
public interface MarcaMapper {
    MarcaDto toMarcaDto(Marca entity);
    Marca toMarca(UcIncluirMarca dto);
    void updateMarca(UcAlterarMarca dto, @MappingTarget Marca entity);
}
