package br.com.senior.tchunai.business.application.cadastros.dominio;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CorDominioDto;
import br.com.senior.tchunai.business.repository.cadastros.CorRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCaseDominio;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;

import static br.com.senior.tchunai.business.entity.cadastros.QCor.cor;

public class UcObterDominioCor extends UseCaseDominio<CorDominioDto, Long, CorRepository> {
    @Override
    protected ListaPaginada<CorDominioDto> execute() {
        return query(cor.id, cor.descricao, CorDominioDto.class);
    }
}
