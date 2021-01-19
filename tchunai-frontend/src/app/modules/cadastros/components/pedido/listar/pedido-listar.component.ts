import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { PedidoService } from '../../../services/pedido.service';
import { PedidoResumoModel } from '../../../models/pedido-resumo.model';
import { PedidoFiltroModel } from '../../../models/pedido-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ReportTypeEnum } from '@shared/enum/report-type.enum';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './pedido-listar.component.html'
})
export class PedidoListarComponent {

  filtro = new PedidoFiltroModel();
  gridWrapper: FilteredTableWrapper<PedidoResumoModel>;

  constructor(private service: PedidoService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: PedidoResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: PedidoResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

  report(type: ReportTypeEnum): void {
    this.service.export(type, this.gridWrapper.filter, 'pedido');
  }

}
