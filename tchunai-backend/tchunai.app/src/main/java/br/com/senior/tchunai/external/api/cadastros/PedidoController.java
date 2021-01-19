package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.pedido.UcListarPedido;
import br.com.senior.tchunai.business.application.cadastros.dto.PedidoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.pedido.UcObterPedido;
import br.com.senior.tchunai.business.application.cadastros.usecase.pedido.UcIncluirPedido;
import br.com.senior.tchunai.business.application.cadastros.usecase.pedido.UcAlterarPedido;
import br.com.senior.tchunai.business.application.cadastros.usecase.pedido.UcExcluirPedido;
import javax.servlet.http.HttpServletResponse;
import br.com.senior.tchunai.external.reports.JasperReportBuilder;
import br.com.senior.tchunai.lib.commom.Messages;
import br.com.senior.tchunai.external.reports.ReportFormatEnum;
import br.com.senior.tchunai.external.reports.PagedBeanCollectionDataSource;

@RestController
@RequestMapping("api/cadastros/pedido")
public class PedidoController {

    @Autowired
    private JasperReportBuilder reportBuilder;
    @Autowired
    private Messages messages;

    private final UseCaseFacade facade;

    @Autowired
    public PedidoController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<PedidoResumoDto> listar(UcListarPedido filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public PedidoDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterPedido().withId(id));
    }

    @PostMapping
        public PedidoDto inserir(@RequestBody UcIncluirPedido uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public PedidoDto atualizar(@RequestBody UcAlterarPedido uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirPedido().withId(id));
    }

    @GetMapping(value = "export")
    public void exportar(UcListarPedido filtro, HttpServletResponse response, @RequestParam(name = "format") ReportFormatEnum format) {
        reportBuilder.generateReport("pedido", null, new PagedBeanCollectionDataSource<>(facade, messages, filtro), response, format);
    }

}
