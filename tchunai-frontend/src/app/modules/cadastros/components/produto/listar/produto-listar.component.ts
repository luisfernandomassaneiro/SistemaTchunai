import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { ProdutoService } from '../../../services/produto.service';
import { ProdutoResumoModel } from '../../../models/produto-resumo.model';
import { ProdutoFiltroModel } from '../../../models/produto-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ReportTypeEnum } from '@shared/enum/report-type.enum';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './produto-listar.component.html'
})
export class ProdutoListarComponent {

  filtro = new ProdutoFiltroModel();
  gridWrapper: FilteredTableWrapper<ProdutoResumoModel>;

  constructor(private service: ProdutoService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: ProdutoResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: ProdutoResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

  report(type: ReportTypeEnum): void {
    this.service.export(type, this.gridWrapper.filter, 'produto');
  }

}
