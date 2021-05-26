package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.ProdutoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;
import java.math.BigDecimal;

@Getter
@Setter
public class UcIncluirProduto extends UseCase<ProdutoDto> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private Integer percentualLucro;
    private String peso;
    private Integer quantidadeAtual;
    private boolean active;
    private CorDominioDto cor;
    private CategoriaDominioDto categoria;
    private MarcaDominioDto marca;
    private TamanhoDominioDto tamanho;
    private String codigoBarras;
    @Override
    protected ProdutoDto execute() {
        Produto dto = map(ProdutoMapper.class).toProduto(this);
        repository.save(dto);
        return map(ProdutoMapper.class).toProdutoDto(dto);
    }
}
