package br.com.senior.tchunai.external.api.cadastros.dominio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioTamanho;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.TamanhoDominioDto;

import java.util.Collection;

@RestController
public class DominioTamanhoController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioTamanhoController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/tamanho")
    public Collection<TamanhoDominioDto> all() {
        return facade.execute(new UcObterDominioTamanho().paged(false)).getItens();
    }

    @GetMapping("api/dominio/tamanho/paged")
    public ListaPaginada<TamanhoDominioDto> paged(UcObterDominioTamanho uc) {
        return facade.execute(uc.paged(true));
    }
}
