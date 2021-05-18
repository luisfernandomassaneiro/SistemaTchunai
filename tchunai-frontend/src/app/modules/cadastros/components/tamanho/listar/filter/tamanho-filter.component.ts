import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { TamanhoFiltroModel } from '../../../../models/tamanho-filtro.model';
import { TamanhoResumoModel } from '../../../../models/tamanho-resumo.model';


@Component({
  selector: 'app-tamanho-filter',
  templateUrl: './tamanho-filter.component.html'
})
export class TamanhoFilterComponent implements OnInit {

  @Input() filtro: TamanhoFiltroModel;
  @Input() grid: FilteredTableWrapper<TamanhoResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
