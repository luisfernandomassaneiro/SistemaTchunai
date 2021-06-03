package br.com.senior.tchunai.business.application.cadastros.usecase.colecao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.ColecaoMapper;
import br.com.senior.tchunai.business.entity.cadastros.Colecao;
import br.com.senior.tchunai.business.repository.cadastros.ColecaoRepository;
import br.com.senior.tchunai.lib.business.application.usecase.impl.IdentifiedUseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.ColecaoDto;

@Getter
@Setter
public class UcAlterarColecao extends IdentifiedUseCase<ColecaoDto, Long> {

    @Autowired
    private ColecaoRepository repository;

    private String descricao;
    @Override
    protected ColecaoDto execute() {
        Colecao entity = repository.require(getId());
        map(ColecaoMapper.class).updateColecao(this, entity);
        repository.save(entity);
        return map(ColecaoMapper.class).toColecaoDto(entity);
    }
}
