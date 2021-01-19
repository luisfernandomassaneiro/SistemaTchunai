import { Component, OnInit, Input } from '@angular/core';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { PedidoFiltroModel } from '../../../../models/pedido-filtro.model';
import { PedidoResumoModel } from '../../../../models/pedido-resumo.model';

import { ClienteDominioService } from '@shared/services/domain/cadastros/cliente-domain.service';
import { ClienteDominioModel } from '@shared/services/domain/cadastros/cliente-domain.service';

@Component({
  selector: 'app-pedido-filter',
  templateUrl: './pedido-filter.component.html'
})
export class PedidoFilterComponent implements OnInit {

  @Input() filtro: PedidoFiltroModel;
  @Input() grid: FilteredTableWrapper<PedidoResumoModel>;
  clienteDomain: ClienteDominioModel[] = [];

  constructor(
    public clienteService: ClienteDominioService,
  ) { }

  ngOnInit() {
    this.clienteService.list().subscribe(domain => this.clienteDomain = domain);
  }
}
