package br.com.senior.tchunai.business.application.cadastros.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDto {
    private Long id;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private boolean active;
}
