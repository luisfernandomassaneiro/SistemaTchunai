import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { MarcaService } from '../../../services/marca.service';
import { MarcaResumoModel } from '../../../models/marca-resumo.model';
import { MarcaFiltroModel } from '../../../models/marca-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './marca-listar.component.html'
})
export class MarcaListarComponent {

  filtro = new MarcaFiltroModel();
  gridWrapper: FilteredTableWrapper<MarcaResumoModel>;

  constructor(private service: MarcaService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: MarcaResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: MarcaResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

}
