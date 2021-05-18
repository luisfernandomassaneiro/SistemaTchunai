package br.com.senior.tchunai.business.application.cadastros.dominio;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CategoriaDominioDto;
import br.com.senior.tchunai.business.repository.cadastros.CategoriaRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCaseDominio;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;

import static br.com.senior.tchunai.business.entity.cadastros.QCategoria.categoria;

public class UcObterDominioCategoria extends UseCaseDominio<CategoriaDominioDto, Long, CategoriaRepository> {
    @Override
    protected ListaPaginada<CategoriaDominioDto> execute() {
        return query(categoria.id, categoria.descricao, CategoriaDominioDto.class);
    }
}
