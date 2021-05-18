import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { MarcaFiltroModel } from '../../../../models/marca-filtro.model';
import { MarcaResumoModel } from '../../../../models/marca-resumo.model';


@Component({
  selector: 'app-marca-filter',
  templateUrl: './marca-filter.component.html'
})
export class MarcaFilterComponent implements OnInit {

  @Input() filtro: MarcaFiltroModel;
  @Input() grid: FilteredTableWrapper<MarcaResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
