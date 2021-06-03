import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ColecaoService } from '../../../services/colecao.service';
import { ColecaoResumoModel } from '../../../models/colecao-resumo.model';
import { ColecaoFiltroModel } from '../../../models/colecao-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './colecao-listar.component.html'
})
export class ColecaoListarComponent {

  filtro = new ColecaoFiltroModel();
  gridWrapper: FilteredTableWrapper<ColecaoResumoModel>;

  constructor(private service: ColecaoService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: ColecaoResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: ColecaoResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

}
