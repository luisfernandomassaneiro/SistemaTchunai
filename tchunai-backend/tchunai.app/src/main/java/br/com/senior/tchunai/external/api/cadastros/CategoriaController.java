package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.categoria.UcListarCategoria;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.categoria.UcObterCategoria;
import br.com.senior.tchunai.business.application.cadastros.usecase.categoria.UcIncluirCategoria;
import br.com.senior.tchunai.business.application.cadastros.usecase.categoria.UcAlterarCategoria;
import br.com.senior.tchunai.business.application.cadastros.usecase.categoria.UcExcluirCategoria;

@RestController
@RequestMapping("api/cadastros/categoria")
public class CategoriaController {

    private final UseCaseFacade facade;

    @Autowired
    public CategoriaController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<CategoriaResumoDto> listar(UcListarCategoria filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public CategoriaDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterCategoria().withId(id));
    }

    @PostMapping
        public CategoriaDto inserir(@RequestBody UcIncluirCategoria uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public CategoriaDto atualizar(@RequestBody UcAlterarCategoria uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirCategoria().withId(id));
    }

}
