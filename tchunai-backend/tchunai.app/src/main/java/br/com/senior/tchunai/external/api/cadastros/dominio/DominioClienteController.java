package br.com.senior.tchunai.external.api.cadastros.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioCliente;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ClienteDominioDto;

import java.util.Collection;

@RestController
public class DominioClienteController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioClienteController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/cliente")
    public Collection<ClienteDominioDto> all() {
        return facade.execute(new UcObterDominioCliente().paged(false)).getItens();
    }

    @GetMapping("api/dominio/cliente/paged")
    public ListaPaginada<ClienteDominioDto> paged(UcObterDominioCliente uc) {
        return facade.execute(uc.paged(true));
    }
}
