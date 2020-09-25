package br.com.senior.tchunai.business.application.cadastros.dominio;

import java.util.ArrayList;
import java.util.List;

import br.com.senior.tchunai.business.entity.cadastros.TipoMovimentacao;
import br.com.senior.tchunai.lib.business.application.usecase.UseCase;

public class UcObterDominioTipoMovimentacao extends UseCase<List<String>> {

    @Override
    protected List<String> execute() {
        List<String> names = new ArrayList<>();
        for (TipoMovimentacao value : TipoMovimentacao.values()) {
            names.add(value.name());
        }
        return names;
    }
}
