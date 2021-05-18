package br.com.senior.tchunai.business.application.cadastros.usecase.cor;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.CorMapper;
import br.com.senior.tchunai.business.entity.cadastros.Cor;
import br.com.senior.tchunai.business.repository.cadastros.CorRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.CorDto;

@Getter
@Setter
public class UcIncluirCor extends UseCase<CorDto> {

    @Autowired
    private CorRepository repository;

    private String descricao;
    @Override
    protected CorDto execute() {
        Cor dto = map(CorMapper.class).toCor(this);
        repository.save(dto);
        return map(CorMapper.class).toCorDto(dto);
    }
}
