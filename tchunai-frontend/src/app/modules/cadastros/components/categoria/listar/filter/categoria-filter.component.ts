import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { CategoriaFiltroModel } from '../../../../models/categoria-filtro.model';
import { CategoriaResumoModel } from '../../../../models/categoria-resumo.model';


@Component({
  selector: 'app-categoria-filter',
  templateUrl: './categoria-filter.component.html'
})
export class CategoriaFilterComponent implements OnInit {

  @Input() filtro: CategoriaFiltroModel;
  @Input() grid: FilteredTableWrapper<CategoriaResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
