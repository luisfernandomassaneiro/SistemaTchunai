package br.com.senior.tchunai.business.application.cadastros.usecase.cliente;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.ClienteMapper;
import br.com.senior.tchunai.business.entity.cadastros.Cliente;
import br.com.senior.tchunai.business.repository.cadastros.ClienteRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteDto;

import java.time.LocalDate;

@Getter
@Setter
public class UcAlterarCliente extends IdentifiedUseCase<ClienteDto, Long> {

    @Autowired
    private ClienteRepository repository;

    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private boolean active;
    @Override
    protected ClienteDto execute() {
        Cliente entity = repository.require(getId());
        map(ClienteMapper.class).updateCliente(this, entity);
        repository.save(entity);
        return map(ClienteMapper.class).toClienteDto(entity);
    }
}
