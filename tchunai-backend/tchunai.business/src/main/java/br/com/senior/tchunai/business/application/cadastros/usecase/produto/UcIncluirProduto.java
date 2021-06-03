package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.*;
import br.com.senior.tchunai.business.entity.cadastros.QProduto;
import com.querydsl.core.BooleanBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.ProdutoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;

import javax.validation.constraints.AssertFalse;
import java.math.BigDecimal;

import static br.com.senior.tchunai.business.entity.cadastros.QProduto.produto;

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
    private ColecaoDominioDto colecao;
    private String codigoBarras;

    @AssertFalse(message = "page.cadastro.produto.codigoBarras.unique")
    public boolean isCodigoBarrasDuplicado() {
        BooleanBuilder b = new BooleanBuilder(produto.codigoBarras.eq(codigoBarras));
        return repository.exists(b);
    }
    @Override
    protected ProdutoDto execute() {
        Produto dto = map(ProdutoMapper.class).toProduto(this);
        repository.save(dto);
        return map(ProdutoMapper.class).toProdutoDto(dto);
    }
}
