import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ClienteFiltroModel } from '../../../../models/cliente-filtro.model';
import { ClienteResumoModel } from '../../../../models/cliente-resumo.model';


@Component({
  selector: 'app-cliente-filter',
  templateUrl: './cliente-filter.component.html'
})
export class ClienteFilterComponent implements OnInit {

  @Input() filtro: ClienteFiltroModel;
  @Input() grid: FilteredTableWrapper<ClienteResumoModel>;

  constructor(
  ) { }

  ngOnInit() {
  }
}
