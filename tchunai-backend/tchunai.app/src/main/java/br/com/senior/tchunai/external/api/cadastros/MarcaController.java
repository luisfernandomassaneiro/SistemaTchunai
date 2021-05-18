package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.marca.UcListarMarca;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.marca.UcObterMarca;
import br.com.senior.tchunai.business.application.cadastros.usecase.marca.UcIncluirMarca;
import br.com.senior.tchunai.business.application.cadastros.usecase.marca.UcAlterarMarca;
import br.com.senior.tchunai.business.application.cadastros.usecase.marca.UcExcluirMarca;

@RestController
@RequestMapping("api/cadastros/marca")
public class MarcaController {

    private final UseCaseFacade facade;

    @Autowired
    public MarcaController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<MarcaResumoDto> listar(UcListarMarca filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public MarcaDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterMarca().withId(id));
    }

    @PostMapping
        public MarcaDto inserir(@RequestBody UcIncluirMarca uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public MarcaDto atualizar(@RequestBody UcAlterarMarca uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirMarca().withId(id));
    }

}
