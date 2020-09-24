import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ProdutoFiltroModel } from '../../../../models/produto-filtro.model';
import { ProdutoResumoModel } from '../../../../models/produto-resumo.model';


@Component({
  selector: 'app-produto-filter',
  templateUrl: './produto-filter.component.html'
})
export class ProdutoFilterComponent implements OnInit {

  @Input() filtro: ProdutoFiltroModel;
  @Input() grid: FilteredTableWrapper<ProdutoResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
