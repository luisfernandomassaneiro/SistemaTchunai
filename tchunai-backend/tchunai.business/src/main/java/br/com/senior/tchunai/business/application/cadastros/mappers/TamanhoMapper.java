package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Tamanho;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.tamanho.UcAlterarTamanho;
import br.com.senior.tchunai.business.application.cadastros.usecase.tamanho.UcIncluirTamanho;

@Mapper
public interface TamanhoMapper {
    TamanhoDto toTamanhoDto(Tamanho entity);
    Tamanho toTamanho(UcIncluirTamanho dto);
    void updateTamanho(UcAlterarTamanho dto, @MappingTarget Tamanho entity);
}
