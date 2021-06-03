import { Component, OnInit, Input } from '@angular/core';
import { CategoriaDominioService } from '@shared/services/domain/cadastros/categoria-domain.service';
import { ColecaoDominioService } from '@shared/services/domain/cadastros/colecao-domain.service';
import { CorDominioService } from '@shared/services/domain/cadastros/cor-domain.service';
import { MarcaDominioService } from '@shared/services/domain/cadastros/marca-domain.service';
import { TamanhoDominioService } from '@shared/services/domain/cadastros/tamanho-domain.service';
import { ComparatorUtils } from '@shared/utils/comparator.utils';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ProdutoFiltroModel } from '../../../../models/produto-filtro.model';
import { ProdutoResumoModel } from '../../../../models/produto-resumo.model';


@Component({
  selector: 'app-produto-filter',
  templateUrl: './produto-filter.component.html'
})
export class ProdutoFilterComponent implements OnInit {

  comparator = ComparatorUtils.getInstance();
  @Input() filtro: ProdutoFiltroModel;
  @Input() grid: FilteredTableWrapper<ProdutoResumoModel>;

  constructor(
    public corService: CorDominioService,
    public categoriaService: CategoriaDominioService,
    public tamanhoService: TamanhoDominioService,
    public marcaService: MarcaDominioService,
    public colecaoService: ColecaoDominioService
  ) { }

  ngOnInit() {
  }
}
