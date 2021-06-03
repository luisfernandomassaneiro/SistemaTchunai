package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.colecao.UcListarColecao;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.colecao.UcObterColecao;
import br.com.senior.tchunai.business.application.cadastros.usecase.colecao.UcIncluirColecao;
import br.com.senior.tchunai.business.application.cadastros.usecase.colecao.UcAlterarColecao;
import br.com.senior.tchunai.business.application.cadastros.usecase.colecao.UcExcluirColecao;

@RestController
@RequestMapping("api/cadastros/colecao")
public class ColecaoController {

    private final UseCaseFacade facade;

    @Autowired
    public ColecaoController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<ColecaoResumoDto> listar(UcListarColecao filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public ColecaoDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterColecao().withId(id));
    }

    @PostMapping
        public ColecaoDto inserir(@RequestBody UcIncluirColecao uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public ColecaoDto atualizar(@RequestBody UcAlterarColecao uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirColecao().withId(id));
    }

}
