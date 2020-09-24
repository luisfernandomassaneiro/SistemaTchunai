package br.com.senior.tchunai.external.api.cadastros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.senior.tchunai.lib.business.application.usecase.UseCaseFacade;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteResumoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.cliente.UcListarCliente;
import br.com.senior.tchunai.business.application.cadastros.dto.ClienteDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.cliente.UcObterCliente;
import br.com.senior.tchunai.business.application.cadastros.usecase.cliente.UcIncluirCliente;
import br.com.senior.tchunai.business.application.cadastros.usecase.cliente.UcAlterarCliente;
import br.com.senior.tchunai.business.application.cadastros.usecase.cliente.UcExcluirCliente;
import javax.servlet.http.HttpServletResponse;
import br.com.senior.tchunai.external.reports.JasperReportBuilder;
import br.com.senior.tchunai.lib.commom.Messages;
import br.com.senior.tchunai.external.reports.ReportFormatEnum;
import br.com.senior.tchunai.external.reports.PagedBeanCollectionDataSource;

@RestController
@RequestMapping("api/cadastros/cliente")
public class ClienteController {

    @Autowired
    private JasperReportBuilder reportBuilder;
    @Autowired
    private Messages messages;

    private final UseCaseFacade facade;

    @Autowired
    public ClienteController(UseCaseFacade facade) { this.facade = facade; }

    @GetMapping
    public ListaPaginada<ClienteResumoDto> listar(UcListarCliente filtro) { return facade.execute(filtro); }

    @GetMapping("{id}")
    public ClienteDto obter(@PathVariable Long id) {
        return facade.execute(new UcObterCliente().withId(id));
    }

    @PostMapping
        public ClienteDto inserir(@RequestBody UcIncluirCliente uc) {
        return facade.execute(uc);
    }

    @PostMapping("{id}")
        public ClienteDto atualizar(@RequestBody UcAlterarCliente uc) {
        return facade.execute(uc);
    }

    @DeleteMapping("{id}")
        public void excluir(@PathVariable Long id) {
        facade.execute(new UcExcluirCliente().withId(id));
    }

    @GetMapping(value = "export")
    public void exportar(UcListarCliente filtro, HttpServletResponse response, @RequestParam(name = "format") ReportFormatEnum format) {
        reportBuilder.generateReport("cliente", null, new PagedBeanCollectionDataSource<>(facade, messages, filtro), response, format);
    }

}
