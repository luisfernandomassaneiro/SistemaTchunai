package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirProduto extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private ProdutoRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
