package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.CorResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.cor.UcListarCor;
import br.com.senior.tchunai.business.application.cadastros.dto.CorDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.cor.UcObterCor;
import br.com.senior.tchunai.business.application.cadastros.usecase.cor.UcIncluirCor;
import br.com.senior.tchunai.business.application.cadastros.usecase.cor.UcAlterarCor;
import br.com.senior.tchunai.business.application.cadastros.usecase.cor.UcExcluirCor;

@RestController
@RequestMapping("api/cadastros/cor")
public class CorController {

    private final UseCaseFacade facade;

    @Autowired
    public CorController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<CorResumoDto> listar(UcListarCor filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public CorDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterCor().withId(id));
    }

    @PostMapping
        public CorDto inserir(@RequestBody UcIncluirCor uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public CorDto atualizar(@RequestBody UcAlterarCor uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirCor().withId(id));
    }

}
