package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Colecao;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.colecao.UcAlterarColecao;
import br.com.senior.tchunai.business.application.cadastros.usecase.colecao.UcIncluirColecao;

@Mapper
public interface ColecaoMapper {
    ColecaoDto toColecaoDto(Colecao entity);
    Colecao toColecao(UcIncluirColecao dto);
    void updateColecao(UcAlterarColecao dto, @MappingTarget Colecao entity);
}
