package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.Cliente;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteDto;

@Mapper
public interface ClienteResumoMapper {
	@IterableMapping(elementTargetType = ClienteResumoDto.class)
	List<ClienteResumoDto> toListClienteResumoDto(Iterable<Cliente> entities);
	ClienteDto toClienteDto(Cliente entity);
}
