import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ColecaoFiltroModel } from '../../../../models/colecao-filtro.model';
import { ColecaoResumoModel } from '../../../../models/colecao-resumo.model';


@Component({
  selector: 'app-colecao-filter',
  templateUrl: './colecao-filter.component.html'
})
export class ColecaoFilterComponent implements OnInit {

  @Input() filtro: ColecaoFiltroModel;
  @Input() grid: FilteredTableWrapper<ColecaoResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
