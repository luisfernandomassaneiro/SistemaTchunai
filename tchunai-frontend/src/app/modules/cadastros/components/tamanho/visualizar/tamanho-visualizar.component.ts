import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { TamanhoModel } from '../../../models/tamanho.model';
import { TamanhoService } from '../../../services/tamanho.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './tamanho-visualizar.component.html'
})
export class TamanhoVisualizarComponent implements OnInit {

  entity: TamanhoModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.tamanho', route: '/cadastros/tamanho'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: TamanhoService, public hash: HashService) { }

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
