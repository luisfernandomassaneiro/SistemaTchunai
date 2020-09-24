package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.produto.UcAlterarProduto;
import br.com.senior.tchunai.business.application.cadastros.usecase.produto.UcIncluirProduto;

@Mapper
public interface ProdutoMapper {
    ProdutoDto toProdutoDto(Produto entity);
    Produto toProduto(UcIncluirProduto dto);
    void updateProduto(UcAlterarProduto dto, @MappingTarget Produto entity);
}
