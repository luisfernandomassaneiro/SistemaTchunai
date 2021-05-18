package br.com.senior.tchunai.business.application.cadastros.usecase.tamanho;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.TamanhoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirTamanho extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private TamanhoRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
