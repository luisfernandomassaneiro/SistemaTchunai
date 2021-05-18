package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.tamanho.UcListarTamanho;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.tamanho.UcObterTamanho;
import br.com.senior.tchunai.business.application.cadastros.usecase.tamanho.UcIncluirTamanho;
import br.com.senior.tchunai.business.application.cadastros.usecase.tamanho.UcAlterarTamanho;
import br.com.senior.tchunai.business.application.cadastros.usecase.tamanho.UcExcluirTamanho;

@RestController
@RequestMapping("api/cadastros/tamanho")
public class TamanhoController {

    private final UseCaseFacade facade;

    @Autowired
    public TamanhoController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<TamanhoResumoDto> listar(UcListarTamanho filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public TamanhoDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterTamanho().withId(id));
    }

    @PostMapping
        public TamanhoDto inserir(@RequestBody UcIncluirTamanho uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public TamanhoDto atualizar(@RequestBody UcAlterarTamanho uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirTamanho().withId(id));
    }

}
