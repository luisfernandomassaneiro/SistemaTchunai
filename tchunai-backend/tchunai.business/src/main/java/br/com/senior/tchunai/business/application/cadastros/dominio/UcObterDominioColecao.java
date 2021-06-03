package br.com.senior.tchunai.business.application.cadastros.dominio;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ColecaoDominioDto;
import br.com.senior.tchunai.business.repository.cadastros.ColecaoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCaseDominio;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;

import static br.com.senior.tchunai.business.entity.cadastros.QColecao.colecao;

public class UcObterDominioColecao extends UseCaseDominio<ColecaoDominioDto, Long, ColecaoRepository> {
    @Override
    protected ListaPaginada<ColecaoDominioDto> execute() {
        return query(colecao.id, colecao.descricao, ColecaoDominioDto.class);
    }
}
