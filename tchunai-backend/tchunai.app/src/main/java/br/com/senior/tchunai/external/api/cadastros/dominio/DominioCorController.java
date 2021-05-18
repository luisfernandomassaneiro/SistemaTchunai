package br.com.senior.tchunai.external.api.cadastros.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioCor;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CorDominioDto;

import java.util.Collection;

@RestController
public class DominioCorController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioCorController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/cor")
    public Collection<CorDominioDto> all() {
        return facade.execute(new UcObterDominioCor().paged(false)).getItens();
    }

    @GetMapping("api/dominio/cor/paged")
    public ListaPaginada<CorDominioDto> paged(UcObterDominioCor uc) {
        return facade.execute(uc.paged(true));
    }
}
