package br.com.senior.tchunai.business.application.cadastros.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovimentacaoEstoqueResumoDto {

    private Long id;
    private LocalDateTime data;
    private String notaFiscal;
}
