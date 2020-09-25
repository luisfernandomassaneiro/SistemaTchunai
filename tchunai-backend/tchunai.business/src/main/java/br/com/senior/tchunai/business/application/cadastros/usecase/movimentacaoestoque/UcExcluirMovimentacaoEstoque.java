package br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.MovimentacaoEstoqueRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirMovimentacaoEstoque extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private MovimentacaoEstoqueRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
