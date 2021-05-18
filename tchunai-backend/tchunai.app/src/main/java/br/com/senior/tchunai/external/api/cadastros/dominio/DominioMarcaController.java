package br.com.senior.tchunai.external.api.cadastros.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioMarca;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.MarcaDominioDto;

import java.util.Collection;

@RestController
public class DominioMarcaController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioMarcaController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/marca")
    public Collection<MarcaDominioDto> all() {
        return facade.execute(new UcObterDominioMarca().paged(false)).getItens();
    }

    @GetMapping("api/dominio/marca/paged")
    public ListaPaginada<MarcaDominioDto> paged(UcObterDominioMarca uc) {
        return facade.execute(uc.paged(true));
    }
}
