package br.com.senior.tchunai.business.application.cadastros.usecase.tamanho;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.TamanhoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Tamanho;
import br.com.senior.tchunai.business.repository.cadastros.TamanhoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.TamanhoDto;

@Getter
@Setter
public class UcIncluirTamanho extends UseCase<TamanhoDto> {

    @Autowired
    private TamanhoRepository repository;

    private String descricao;
    @Override
    protected TamanhoDto execute() {
        Tamanho dto = map(TamanhoMapper.class).toTamanho(this);
        repository.save(dto);
        return map(TamanhoMapper.class).toTamanhoDto(dto);
    }
}
