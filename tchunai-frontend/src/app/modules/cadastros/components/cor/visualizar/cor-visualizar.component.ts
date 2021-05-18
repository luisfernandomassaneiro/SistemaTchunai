import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { CorModel } from '../../../models/cor.model';
import { CorService } from '../../../services/cor.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './cor-visualizar.component.html'
})
export class CorVisualizarComponent implements OnInit {

  entity: CorModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.cor', route: '/cadastros/cor'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: CorService, public hash: HashService) { }

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
