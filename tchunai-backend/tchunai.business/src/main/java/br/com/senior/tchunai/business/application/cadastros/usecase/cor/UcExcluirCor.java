package br.com.senior.tchunai.business.application.cadastros.usecase.cor;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.CorRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirCor extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private CorRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
