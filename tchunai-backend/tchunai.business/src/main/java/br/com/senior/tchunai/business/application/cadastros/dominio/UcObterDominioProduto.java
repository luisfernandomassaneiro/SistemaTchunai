package br.com.senior.tchunai.business.application.cadastros.dominio;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ProdutoDominioDto;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCaseDominio;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;

import static br.com.senior.tchunai.business.entity.cadastros.QProduto.produto;

public class UcObterDominioProduto extends UseCaseDominio<ProdutoDominioDto, Long, ProdutoRepository> {
    @Override
    protected ListaPaginada<ProdutoDominioDto> execute() {
        return query(produto.id, produto.descricao, ProdutoDominioDto.class);
    }
}
