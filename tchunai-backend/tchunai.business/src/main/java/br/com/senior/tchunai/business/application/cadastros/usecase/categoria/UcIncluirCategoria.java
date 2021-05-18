package br.com.senior.tchunai.business.application.cadastros.usecase.categoria;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.CategoriaMapper;
import br.com.senior.tchunai.business.entity.cadastros.Categoria;
import br.com.senior.tchunai.business.repository.cadastros.CategoriaRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.CategoriaDto;

@Getter
@Setter
public class UcIncluirCategoria extends UseCase<CategoriaDto> {

    @Autowired
    private CategoriaRepository repository;

    private String descricao;
    @Override
    protected CategoriaDto execute() {
        Categoria dto = map(CategoriaMapper.class).toCategoria(this);
        repository.save(dto);
        return map(CategoriaMapper.class).toCategoriaDto(dto);
    }
}
