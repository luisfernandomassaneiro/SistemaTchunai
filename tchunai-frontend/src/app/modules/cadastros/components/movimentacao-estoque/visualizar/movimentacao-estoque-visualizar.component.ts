import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { MovimentacaoEstoqueModel } from '../../../models/movimentacao-estoque.model';
import { MovimentacaoEstoqueService } from '../../../services/movimentacao-estoque.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './movimentacao-estoque-visualizar.component.html'
})
export class MovimentacaoEstoqueVisualizarComponent implements OnInit {

  entity: MovimentacaoEstoqueModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.movimentacaoestoque', route: '/cadastros/movimentacaoestoque'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: MovimentacaoEstoqueService, public hash: HashService) { }

  ngOnInit() {
    this.entity = this.route.snapshot.data.entity;
    if (this.entity.notaFiscal) {
      this.breadcrumb.push({label: this.entity.notaFiscal});
    } else {
      this.breadcrumb.push({label: 'general.labels.view'});
    }
  }

    delete(item): void {
      this.service.confirmAndDelete(item.id).then(() => this.router.navigate(['../../'], { relativeTo: this.route }));
    }
}
