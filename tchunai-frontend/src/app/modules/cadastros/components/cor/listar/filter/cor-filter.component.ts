import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { CorFiltroModel } from '../../../../models/cor-filtro.model';
import { CorResumoModel } from '../../../../models/cor-resumo.model';


@Component({
  selector: 'app-cor-filter',
  templateUrl: './cor-filter.component.html'
})
export class CorFilterComponent implements OnInit {

  @Input() filtro: CorFiltroModel;
  @Input() grid: FilteredTableWrapper<CorResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
