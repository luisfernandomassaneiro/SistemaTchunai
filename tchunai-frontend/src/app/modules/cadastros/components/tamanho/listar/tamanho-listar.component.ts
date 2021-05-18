import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { TamanhoService } from '../../../services/tamanho.service';
import { TamanhoResumoModel } from '../../../models/tamanho-resumo.model';
import { TamanhoFiltroModel } from '../../../models/tamanho-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './tamanho-listar.component.html'
})
export class TamanhoListarComponent {

  filtro = new TamanhoFiltroModel();
  gridWrapper: FilteredTableWrapper<TamanhoResumoModel>;

  constructor(private service: TamanhoService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: TamanhoResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: TamanhoResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

}
