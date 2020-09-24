package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Cliente;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.cliente.UcAlterarCliente;
import br.com.senior.tchunai.business.application.cadastros.usecase.cliente.UcIncluirCliente;

@Mapper
public interface ClienteMapper {
    ClienteDto toClienteDto(Cliente entity);
    Cliente toCliente(UcIncluirCliente dto);
    void updateCliente(UcAlterarCliente dto, @MappingTarget Cliente entity);
}
