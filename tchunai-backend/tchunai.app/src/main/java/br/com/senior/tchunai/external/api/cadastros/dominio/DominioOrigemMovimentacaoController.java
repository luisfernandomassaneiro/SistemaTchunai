package br.com.senior.tchunai.external.api.cadastros.dominio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.business.application.cadastros.dominio.UcObterDominioOrigemMovimentacao;

@RestController
public class DominioOrigemMovimentacaoController {

    private final UseCaseFacade facade;

    @Autowired
    public DominioOrigemMovimentacaoController(UseCaseFacade facade) {
        this.facade = facade;
    }

    @GetMapping("api/dominio/origemmovimentacao")
    public List<String> listar() {
        return facade.execute(new UcObterDominioOrigemMovimentacao());
    }
}
