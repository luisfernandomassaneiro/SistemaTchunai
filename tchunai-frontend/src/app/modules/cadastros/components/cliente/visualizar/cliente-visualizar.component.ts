import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ClienteModel } from '../../../models/cliente.model';
import { ClienteService } from '../../../services/cliente.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './cliente-visualizar.component.html'
})
export class ClienteVisualizarComponent implements OnInit {

  entity: ClienteModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.cliente', route: '/cadastros/cliente'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: ClienteService, public hash: HashService) { }

  ngOnInit() {
    this.entity = this.route.snapshot.data.entity;
    if (this.entity.nome) {
      this.breadcrumb.push({label: this.entity.nome});
    } else {
      this.breadcrumb.push({label: 'general.labels.view'});
    }
  }

    delete(item): void {
      this.service.confirmAndDelete(item.id).then(() => this.router.navigate(['../../'], { relativeTo: this.route }));
    }
}
