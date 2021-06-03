package br.com.senior.tchunai.business.application.cadastros.usecase.colecao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.ColecaoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Colecao;
import br.com.senior.tchunai.business.repository.cadastros.ColecaoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoDto;

@Getter
@Setter
public class UcIncluirColecao extends UseCase<ColecaoDto> {

    @Autowired
    private ColecaoRepository repository;

    private String descricao;
    @Override
    protected ColecaoDto execute() {
        Colecao dto = map(ColecaoMapper.class).toColecao(this);
        repository.save(dto);
        return map(ColecaoMapper.class).toColecaoDto(dto);
    }
}
