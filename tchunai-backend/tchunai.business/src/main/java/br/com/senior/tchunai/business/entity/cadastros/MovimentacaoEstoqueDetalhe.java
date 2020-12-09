package br.com.senior.tchunai.business.entity.cadastros;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "movimentacao_estoque_detalhe")
public class MovimentacaoEstoqueDetalhe implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movimento_estoque_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private MovimentacaoEstoque movimentacaoEstoque;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id", nullable = false)
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

}
