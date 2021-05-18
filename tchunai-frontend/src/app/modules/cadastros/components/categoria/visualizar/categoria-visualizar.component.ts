import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { CategoriaModel } from '../../../models/categoria.model';
import { CategoriaService } from '../../../services/categoria.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './categoria-visualizar.component.html'
})
export class CategoriaVisualizarComponent implements OnInit {

  entity: CategoriaModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.categoria', route: '/cadastros/categoria'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: CategoriaService, public hash: HashService) { }

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
