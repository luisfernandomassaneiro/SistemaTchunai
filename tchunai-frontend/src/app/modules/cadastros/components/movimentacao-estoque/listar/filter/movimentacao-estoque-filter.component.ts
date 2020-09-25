import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { MovimentacaoEstoqueFiltroModel } from '../../../../models/movimentacao-estoque-filtro.model';
import { MovimentacaoEstoqueResumoModel } from '../../../../models/movimentacao-estoque-resumo.model';


@Component({
  selector: 'app-movimentacao-estoque-filter',
  templateUrl: './movimentacao-estoque-filter.component.html'
})
export class MovimentacaoEstoqueFilterComponent implements OnInit {

  @Input() filtro: MovimentacaoEstoqueFiltroModel;
  @Input() grid: FilteredTableWrapper<MovimentacaoEstoqueResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
