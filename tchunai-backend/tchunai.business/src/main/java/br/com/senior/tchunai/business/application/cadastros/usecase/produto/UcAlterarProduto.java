package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CategoriaDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CorDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.MarcaDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.TamanhoDominioDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.ProdutoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;
import java.math.BigDecimal;

@Getter
@Setter
public class UcAlterarProduto extends IdentifiedUseCase<ProdutoDto, Long> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;
    private BigDecimal precoCusto;
    private BigDecimal precoVenda;
    private Integer percentualLucro;
    private String peso;
    private boolean active;
    private Integer quantidadeAtual;
    private CorDominioDto cor;
    private CategoriaDominioDto categoria;
    private MarcaDominioDto marca;
    private TamanhoDominioDto tamanho;
    private String codigoBarras;
    @Override
    protected ProdutoDto execute() {
        Produto entity = repository.require(getId());
        map(ProdutoMapper.class).updateProduto(this, entity);
        repository.save(entity);
        return map(ProdutoMapper.class).toProdutoDto(entity);
    }
}
