package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoDto;
import br.com.senior.tchunai.business.application.cadastros.mappers.ProdutoMapper;
import br.com.senior.tchunai.business.entity.cadastros.*;
import br.com.senior.tchunai.business.repository.cadastros.CategoriaRepository;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;
import com.querydsl.core.BooleanBuilder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertFalse;
import java.math.BigDecimal;
import java.util.Objects;

import static br.com.senior.tchunai.business.entity.cadastros.QProduto.produto;

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
    private Cor cor;
    private Categoria categoria;
    private Marca marca;
    private Tamanho tamanho;
    private Colecao colecao;
    private String codigoBarras;

    @AssertFalse(message = "page.cadastro.produto.codigoBarras.unique")
    public boolean isCodigoBarrasDuplicado() {
        if (Objects.isNull(produto.codigoBarras) || Objects.isNull(codigoBarras)) {
            return false;
        }
        BooleanBuilder b = new BooleanBuilder(produto.codigoBarras.eq(codigoBarras));
        b.and(produto.id.ne(getId()));
        return repository.exists(b);
    }
    
    @Override
    protected ProdutoDto execute() {
        Produto entity = repository.require(getId());
        map(ProdutoMapper.class).updateProduto(this, entity);
        repository.save(entity);
        return map(ProdutoMapper.class).toProdutoDto(entity);
    }
}
