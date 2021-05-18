import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CorService } from '../../../services/cor.service';
import { CorResumoModel } from '../../../models/cor-resumo.model';
import { CorFiltroModel } from '../../../models/cor-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './cor-listar.component.html'
})
export class CorListarComponent {

  filtro = new CorFiltroModel();
  gridWrapper: FilteredTableWrapper<CorResumoModel>;

  constructor(private service: CorService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: CorResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: CorResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

}
