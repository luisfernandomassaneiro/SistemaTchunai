package br.com.senior.tchunai.business.application.cadastros.usecase.produto;

import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ColecaoDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.CorDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.MarcaDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.TamanhoDominioDto;
import br.com.senior.tchunai.business.application.cadastros.dto.ProdutoRelatorioDto;
import br.com.senior.tchunai.business.entity.cadastros.Categoria;
import br.com.senior.tchunai.business.entity.cadastros.Produto;
import br.com.senior.tchunai.business.repository.cadastros.ProdutoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.ListaPaginada;
import br.com.senior.tchunai.lib.business.application.usecase.impl.QueryPaginada;
import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static br.com.senior.tchunai.business.entity.cadastros.QProduto.produto;
import static br.com.senior.tchunai.lib.business.application.commom.QueryDslExpressionUtils.nullSafeContainsIgnoreCase;

@Setter
public class UcRelatorioProduto extends QueryPaginada<ListaPaginada<ProdutoRelatorioDto>> {

    @Autowired
    private ProdutoRepository repository;

    private String descricao;
    private CorDominioDto cor;
    private Categoria categoria;
    private MarcaDominioDto marca;
    private TamanhoDominioDto tamanho;
    private ColecaoDominioDto colecao;
    private String codigoBarras;

    @Override
    protected ListaPaginada<ProdutoRelatorioDto> execute() {

        BooleanBuilder filtro = new BooleanBuilder();
        filtro.and(nullSafeContainsIgnoreCase(produto.descricao, descricao));
        filtro.and(nullSafeContainsIgnoreCase(produto.codigoBarras, codigoBarras));

        List<ProdutoRelatorioDto> lista = new ArrayList<>();
        List<Produto> listaProdutos = (List<Produto>) repository.findAll(filtro, Sort.by(Sort.Direction.ASC, "categoria.descricao"));
        if (!listaProdutos.isEmpty()) {
            listaProdutos.forEach(p -> {
                ProdutoRelatorioDto dto = new ProdutoRelatorioDto();
                dto.setId(p.getId());
                dto.setCodigo(p.getCodigoBarras());
                dto.setDescricao(p.getDescricao());
                dto.setPrecoVenda(p.getPrecoVenda());
                dto.setPrecoCusto(p.getPrecoCusto());
                dto.setQuantidadeAtual(p.getQuantidadeAtual());
                dto.setPeso(p.getPeso());
                if (Objects.nonNull(p.getPrecoVenda()) && p.getPrecoVenda().doubleValue() > 0) {
                    dto.setValorLucro(p.getPrecoVenda().subtract(dto.getPrecoCusto()));
                }
                dto.setPercentualLucro(p.getPercentualLucro());
                if (Objects.nonNull(p.getCategoria())) {
                    dto.setCategoria(p.getCategoria().getDescricao());
                }
                if (Objects.nonNull(p.getMarca())) {
                    dto.setMarca(p.getMarca().getDescricao());
                }
                if (Objects.nonNull(p.getTamanho())) {
                    dto.setTamanho(p.getTamanho().getDescricao());
                }
                if (Objects.nonNull(p.getCor())) {
                    dto.setCor(p.getCor().getDescricao());
                }
                if (Objects.nonNull(p.getColecao())) {
                    dto.setColecao(p.getColecao().getDescricao());
                }
                lista.add(dto);
            });
        }

        return new ListaPaginada<>(lista.size(), 1, lista);
    }
}
