import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ProdutoModel } from '../../../models/produto.model';
import { ProdutoService } from '../../../services/produto.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './produto-visualizar.component.html'
})
export class ProdutoVisualizarComponent implements OnInit {

  entity: ProdutoModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.produto', route: '/cadastros/produto'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: ProdutoService, public hash: HashService) { }

  ngOnInit() {
    this.entity = this.route.snapshot.data.entity;
    if (this.entity.descricao) {
      this.breadcrumb.push({label: this.entity.descricao});
    } else {
      this.breadcrumb.push({label: 'general.labels.view'});
    }
  }

    delete(item): void {
      this.service.confirmAndDelete(item.id).then(() => this.router.navigate(['../../'], { relativeTo: this.route }));
    }
}
