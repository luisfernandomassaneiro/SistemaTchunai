import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { MovimentacaoEstoqueService } from '../../../services/movimentacao-estoque.service';
import { MovimentacaoEstoqueResumoModel } from '../../../models/movimentacao-estoque-resumo.model';
import { MovimentacaoEstoqueFiltroModel } from '../../../models/movimentacao-estoque-filtro.model';

import { HashService } from '@shared/services/hash.service';
import { FilteredTableWrapper } from '@shared/utils/filtered-table.wrapper';
import { ReportTypeEnum } from '@shared/enum/report-type.enum';
import { PersistentFilterService } from '@shared/services/persistent-filter.service';

@Component({
  templateUrl: './movimentacao-estoque-listar.component.html'
})
export class MovimentacaoEstoqueListarComponent {

  filtro = new MovimentacaoEstoqueFiltroModel();
  gridWrapper: FilteredTableWrapper<MovimentacaoEstoqueResumoModel>;

  constructor(private service: MovimentacaoEstoqueService, private router: Router, private route: ActivatedRoute,
              filterService: PersistentFilterService, public hash: HashService) {
    this.gridWrapper = new FilteredTableWrapper(service, this.filtro, null, filterService);
  }

  delete(item: MovimentacaoEstoqueResumoModel): void {
    this.service.confirmAndDelete(item.id).then(() => this.gridWrapper.refresh());
  }

  view(item: MovimentacaoEstoqueResumoModel): void {
    this.router.navigate(['../visualizar', this.hash.encode(item.id)], {relativeTo: this.route});
  }

  report(type: ReportTypeEnum): void {
    this.service.export(type, this.gridWrapper.filter, 'movimentacaoestoque');
  }

}
