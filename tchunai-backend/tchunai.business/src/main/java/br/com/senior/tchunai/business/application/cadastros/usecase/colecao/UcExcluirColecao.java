package br.com.senior.tchunai.business.application.cadastros.usecase.colecao;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.ColecaoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirColecao extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private ColecaoRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
