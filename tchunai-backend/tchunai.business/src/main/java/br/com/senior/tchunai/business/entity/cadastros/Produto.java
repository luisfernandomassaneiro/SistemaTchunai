package br.com.senior.tchunai.business.entity.cadastros;

import br.com.senior.tchunai.lib.generator.annotations.GenHint;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GenHint(label = true, listing = true)
    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_custo")
    private BigDecimal precoCusto;

    @Column(name = "preco_venda")
    private BigDecimal precoVenda;

    @Column(name = "percentual_lucro")
    private Integer percentualLucro;

    @Column(name = "peso")
    private String peso;

    @Column(name = "ativo")
    @ColumnDefault("true")
    private boolean active;

    @Column(name = "quantidade_atual")
    private Integer quantidadeAtual;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="marca_id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name="cor_id")
    private Cor cor;

    @ManyToOne
    @JoinColumn(name="colecao_id")
    private Colecao colecao;

    @ManyToOne
    @JoinColumn(name="tamanho_id")
    private Tamanho tamanho;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    public void alteraQuantidade(TipoMovimentacao tipoMovimentacao, Integer quantidade) {
        if (Objects.isNull(quantidadeAtual)) {
            this.quantidadeAtual = 0;
        }

        if (TipoMovimentacao.ENTRADA.equals(tipoMovimentacao)) {
            this.quantidadeAtual += quantidade;
        } else {
            this.quantidadeAtual -= quantidade;
        }
    }
}
