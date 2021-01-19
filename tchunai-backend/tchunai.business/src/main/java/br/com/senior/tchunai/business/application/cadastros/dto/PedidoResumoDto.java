package br.com.senior.tchunai.business.application.cadastros.dto;

import lombok.Data;
import java.math.BigDecimal;
import br.com.senior.tchunai.business.application.cadastros.dominio.dto.ClienteDominioDto;
import java.time.LocalDateTime;

@Data
public class PedidoResumoDto {

    private Long id;
    private LocalDateTime data;
    private ClienteDominioDto cliente;
    private BigDecimal valorTotal;
}
