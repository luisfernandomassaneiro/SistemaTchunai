package br.com.senior.tchunai.business.application.cadastros.usecase.cliente;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.ClienteRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirCliente extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private ClienteRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
