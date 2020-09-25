package br.com.senior.tchunai.business.entity.cadastros;

import br.com.senior.tchunai.lib.generator.annotations.GenHint;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "movimentacao_estoque")
public class MovimentacaoEstoque implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GenHint(label = true, listing = true)
    @Column(name = "nota_fiscal")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Produto produto;

    @Column(name = "tipo_movimentacao")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @Column(name = "origem_movimentacao")
    @Enumerated(EnumType.STRING)
    private OrigemMovimentacao origemMovimentacao;

}
