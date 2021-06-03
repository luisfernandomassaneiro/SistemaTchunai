package br.com.senior.tchunai.external.api.cadastros.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioColecao;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ColecaoDominioDto;

import java.util.Collection;

@RestController
public class DominioColecaoController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioColecaoController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/colecao")
    public Collection<ColecaoDominioDto> all() {
        return facade.execute(new UcObterDominioColecao().paged(false)).getItens();
    }

    @GetMapping("api/dominio/colecao/paged")
    public ListaPaginada<ColecaoDominioDto> paged(UcObterDominioColecao uc) {
        return facade.execute(uc.paged(true));
    }
}
