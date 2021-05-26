package br.com.senior.tchunai.business.application.cadastros.usecase.cliente;

import br.com.senior.tchunai.business.application.cadastros.dto.ClienteDto;
import br.com.senior.tchunai.business.application.cadastros.mappers.ClienteMapper;
import br.com.senior.tchunai.business.entity.cadastros.Cliente;
import br.com.senior.tchunai.business.repository.cadastros.ClienteRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Getter
@Setter
public class UcIncluirCliente extends UseCase<ClienteDto> {

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
        Cliente dto = map(ClienteMapper.class).toCliente(this);
        repository.save(dto);
        return map(ClienteMapper.class).toClienteDto(dto);
    }
}
