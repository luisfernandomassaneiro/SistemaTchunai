package br.com.senior.tchunai.business.entity.cadastros;

import br.com.senior.tchunai.lib.generator.annotations.GenHint;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "colecao")
public class Colecao implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @GenHint(label = true, listing = true)
    @Column(name = "descricao")
    private String descricao;

}
