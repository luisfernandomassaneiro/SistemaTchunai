package br.com.senior.tchunai.business.entity.cadastros;

import br.com.senior.tchunai.lib.generator.annotations.GenHint;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
    private String notaFiscal;

    @Column(name = "tipo_movimentacao")
    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @Column(name = "origem_movimentacao")
    @Enumerated(EnumType.STRING)
    private OrigemMovimentacao origemMovimentacao;

    @Column(name = "data")
    private LocalDateTime data;

    @OneToMany(mappedBy = "movimentacaoEstoque", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<MovimentacaoEstoqueDetalhe> movimentacaoEstoqueDetalhes;


}
