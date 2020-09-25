package br.com.senior.tchunai.business.application.cadastros.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import br.com.senior.tchunai.business.entity.cadastros.MovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.dto.MovimentacaoEstoqueDto;
import br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque.UcAlterarMovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.usecase.movimentacaoestoque.UcIncluirMovimentacaoEstoque;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ProdutoDominioDto;
import br.com.senior.tchunai.business.entity.cadastros.Produto;

@Mapper
public interface MovimentacaoEstoqueMapper {
    Produto toProduto(ProdutoDominioDto dto);
    MovimentacaoEstoqueDto toMovimentacaoEstoqueDto(MovimentacaoEstoque entity);
    MovimentacaoEstoque toMovimentacaoEstoque(UcIncluirMovimentacaoEstoque dto);
    void updateMovimentacaoEstoque(UcAlterarMovimentacaoEstoque dto, @MappingTarget MovimentacaoEstoque entity);
}
