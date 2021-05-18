package br.com.senior.tchunai.business.application.cadastros.usecase.categoria;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.CategoriaRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirCategoria extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private CategoriaRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
