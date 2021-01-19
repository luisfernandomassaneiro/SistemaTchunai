package br.com.senior.tchunai.business.application.cadastros.dominio;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ClienteDominioDto;
import br.com.senior.tchunai.business.repository.cadastros.ClienteRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCaseDominio;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;

import static br.com.senior.tchunai.business.entity.cadastros.QCliente.cliente;

public class UcObterDominioCliente extends UseCaseDominio<ClienteDominioDto, Long, ClienteRepository> {
    @Override
    protected ListaPaginada<ClienteDominioDto> execute() {
        return query(cliente.id, cliente.nome, ClienteDominioDto.class);
    }
}
