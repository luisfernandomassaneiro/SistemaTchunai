package br.com.senior.tchunai.business.application.cadastros.usecase.marca;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.MarcaRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirMarca extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private MarcaRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
