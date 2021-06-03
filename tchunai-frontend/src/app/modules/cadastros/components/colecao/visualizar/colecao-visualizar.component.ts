import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ColecaoModel } from '../../../models/colecao.model';
import { ColecaoService } from '../../../services/colecao.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './colecao-visualizar.component.html'
})
export class ColecaoVisualizarComponent implements OnInit {

  entity: ColecaoModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.colecao', route: '/cadastros/colecao'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: ColecaoService, public hash: HashService) { }

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
