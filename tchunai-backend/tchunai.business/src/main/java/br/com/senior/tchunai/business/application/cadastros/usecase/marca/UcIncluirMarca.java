package br.com.senior.tchunai.business.application.cadastros.usecase.marca;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.senior.tchunai.business.application.cadastros.mappers.MarcaMapper;
import br.com.senior.tchunai.business.entity.cadastros.Marca;
import br.com.senior.tchunai.business.repository.cadastros.MarcaRepository;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;
import br.com.senior.tchunai.business.application.cadastros.dto.MarcaDto;

@Getter
@Setter
public class UcIncluirMarca extends UseCase<MarcaDto> {

    @Autowired
    private MarcaRepository repository;

    private String descricao;
    @Override
    protected MarcaDto execute() {
        Marca dto = map(MarcaMapper.class).toMarca(this);
        repository.save(dto);
        return map(MarcaMapper.class).toMarcaDto(dto);
    }
}
