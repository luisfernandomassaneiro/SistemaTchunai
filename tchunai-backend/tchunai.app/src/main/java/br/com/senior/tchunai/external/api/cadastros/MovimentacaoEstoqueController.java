package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque.UcListarMovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque.UcObterMovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque.UcIncluirMovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque.UcAlterarMovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque.UcExcluirMovimentacaoEstoque;
import javax.servlet.http.HttpServletResponse;
import br.com.senior.tchunai.external.reports.JasperReportBuilder;
import br.com.senior.tchunai.lib.commom.Messages;
import br.com.senior.tchunai.external.reports.ReportFormatEnum;
import br.com.senior.tchunai.external.reports.PagedBeanCollectionDataSource;

@RestController
@RequestMapping("api/cadastros/movimentacaoestoque")
public class MovimentacaoEstoqueController {

    @Autowired
    private JasperReportBuilder reportBuilder;
    @Autowired
    private Messages messages;

    private final UseCaseFacade facade;

    @Autowired
    public MovimentacaoEstoqueController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<MovimentacaoEstoqueResumoDto> listar(UcListarMovimentacaoEstoque filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public MovimentacaoEstoqueDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterMovimentacaoEstoque().withId(id));
    }

    @PostMapping
        public MovimentacaoEstoqueDto inserir(@RequestBody UcIncluirMovimentacaoEstoque uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public MovimentacaoEstoqueDto atualizar(@RequestBody UcAlterarMovimentacaoEstoque uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirMovimentacaoEstoque().withId(id));
    }

    @GetMapping(value = "export")
    public void exportar(UcListarMovimentacaoEstoque filtro, HttpServletResponse response, @RequestParam(name = "format") ReportFormatEnum format) {
        reportBuilder.generateReport("movimentacaoestoque", null, new PagedBeanCollectionDataSource<>(facade, messages, filtro), response, format);
    }

}
