import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { MarcaModel } from '../../../models/marca.model';
import { MarcaService } from '../../../services/marca.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './marca-visualizar.component.html'
})
export class MarcaVisualizarComponent implements OnInit {

  entity: MarcaModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.marca', route: '/cadastros/marca'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: MarcaService, public hash: HashService) { }

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
