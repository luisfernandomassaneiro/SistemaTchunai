import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { CategoriaService } from '../../../services/categoria.service';
import { CategoriaResumoModel } from '../../../models/categoria-resumo.model';
import { CategoriaFiltroModel } from '../../../models/categoria-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './categoria-listar.component.html'
})
export class CategoriaListarComponent {

  filtro = new CategoriaFiltroModel();
  gridWrapper: FilteredTableWrapper<CategoriaResumoModel>;

  constructor(private service: CategoriaService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: CategoriaResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: CategoriaResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

}
