package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Cor;
import br.com.senior.tchunai.business.application.cadastros.dto.CorDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.cor.UcAlterarCor;
import br.com.senior.tchunai.business.application.cadastros.usecase.cor.UcIncluirCor;

@Mapper
public interface CorMapper {
    CorDto toCorDto(Cor entity);
    Cor toCor(UcIncluirCor dto);
    void updateCor(UcAlterarCor dto, @MappingTarget Cor entity);
}
