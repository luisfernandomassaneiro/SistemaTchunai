package br.com.senior.tchunai.business.application.cadastros.dominio;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.MarcaDominioDto;
import br.com.senior.tchunai.business.repository.cadastros.MarcaRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCaseDominio;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;

import static br.com.senior.tchunai.business.entity.cadastros.QMarca.marca;

public class UcObterDominioMarca extends UseCaseDominio<MarcaDominioDto, Long, MarcaRepository> {
    @Override
    protected ListaPaginada<MarcaDominioDto> execute() {
        return query(marca.id, marca.descricao, MarcaDominioDto.class);
    }
}
