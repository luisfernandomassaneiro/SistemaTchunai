package br.com.senior.tchunai.external.api.cadastros;

import br.com.senior.tchunai.business.application.cadastros.usecase.produto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;

import javax.servlet.http.HttpServletResponse;
import br.com.senior.tchunai.external.reports.JasperReportBuilder;
import br.com.senior.tchunai.lib.commom.Messages;
import br.com.senior.tchunai.external.reports.ReportFormatEnum;
import br.com.senior.tchunai.external.reports.PagedBeanCollectionDataSource;

@RestController
@RequestMapping("api/cadastros/produto")
public class ProdutoController {

    @Autowired
    private JasperReportBuilder reportBuilder;
    @Autowired
    private Messages messages;

    private final UseCaseFacade facade;

    @Autowired
    public ProdutoController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<ProdutoResumoDto> listar(UcListarProduto filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public ProdutoDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterProduto().withId(id));
    }

    @PostMapping
        public ProdutoDto inserir(@RequestBody UcIncluirProduto uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public ProdutoDto atualizar(@RequestBody UcAlterarProduto uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirProduto().withId(id));
    }

    @GetMapping(value = "export")
    public void exportar(UcRelatorioProduto filtro, HttpServletResponse response, @RequestParam(name = "format") ReportFormatEnum format) {
        reportBuilder.generateReport("produto", null, new PagedBeanCollectionDataSource<>(facade, messages, filtro), response, format);
    }

}
