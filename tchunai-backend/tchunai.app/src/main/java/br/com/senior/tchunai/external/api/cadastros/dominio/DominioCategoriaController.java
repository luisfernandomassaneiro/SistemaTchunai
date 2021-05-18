package br.com.senior.tchunai.external.api.cadastros.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioCategoria;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CategoriaDominioDto;

import java.util.Collection;

@RestController
public class DominioCategoriaController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioCategoriaController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/categoria")
    public Collection<CategoriaDominioDto> all() {
        return facade.execute(new UcObterDominioCategoria().paged(false)).getItens();
    }

    @GetMapping("api/dominio/categoria/paged")
    public ListaPaginada<CategoriaDominioDto> paged(UcObterDominioCategoria uc) {
        return facade.execute(uc.paged(true));
    }
}
