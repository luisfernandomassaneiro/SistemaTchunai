package br.com.senior.tchunai.business.application.cadastros.usecase.pedido;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.repository.cadastros.PedidoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;

public class UcExcluirPedido extends IdentifiedUseCase<Void, Long> {

    @Autowired
    private PedidoRepository repository;

    @Override
    protected Void execute() {
        repository.deleteById(getId());
        return null;
    }
}
