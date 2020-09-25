package br.com.senior.tchunai.business.application.cadastros.dominio;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.OrigemMovimentacao;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;

public class UcObterDominioOrigemMovimentacao extends UseCase<List<String>> {

    @Override
    protected List<String> execute() {
        List<String> names = new ArrayList<>();
        for (OrigemMovimentacao value : OrigemMovimentacao.values()) {
            names.add(value.name());
        }
        return names;
    }
}
