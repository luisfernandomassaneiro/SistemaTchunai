package br.com.senior.tchunai.external.api.cadastros.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioProduto;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ProdutoDominioDto;

import java.util.Collection;

@RestController
public class DominioProdutoController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioProdutoController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/produto")
    public Collection<ProdutoDominioDto> all() {
        return facade.execute(new UcObterDominioProduto().paged(false)).getItens();
    }

    @GetMapping("api/dominio/produto/paged")
    public ListaPaginada<ProdutoDominioDto> paged(UcObterDominioProduto uc) {
        return facade.execute(uc.paged(true));
    }
}
