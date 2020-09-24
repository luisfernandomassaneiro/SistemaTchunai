import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ClienteService } from '../../../services/cliente.service';
import { ClienteResumoModel } from '../../../models/cliente-resumo.model';
import { ClienteFiltroModel } from '../../../models/cliente-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ReportTypeEnum } from '@shared/enum/report-type.enum';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './cliente-listar.component.html'
})
export class ClienteListarComponent {

  filtro = new ClienteFiltroModel();
  gridWrapper: FilteredTableWrapper<ClienteResumoModel>;

  constructor(private service: ClienteService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: ClienteResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: ClienteResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

  report(type: ReportTypeEnum): void {
    this.service.export(type, this.gridWrapper.filter, 'cliente');
  }

}
