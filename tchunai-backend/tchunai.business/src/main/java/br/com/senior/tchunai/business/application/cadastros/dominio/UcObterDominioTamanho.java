package br.com.senior.tchunai.business.application.cadastros.dominio;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.TamanhoDominioDto;
import br.com.senior.tchunai.business.repository.cadastros.TamanhoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCaseDominio;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;

import static br.com.senior.tchunai.business.entity.cadastros.QTamanho.tamanho;

public class UcObterDominioTamanho extends UseCaseDominio<TamanhoDominioDto, Long, TamanhoRepository> {
    @Override
    protected ListaPaginada<TamanhoDominioDto> execute() {
        return query(tamanho.id, tamanho.descricao, TamanhoDominioDto.class);
    }
}
