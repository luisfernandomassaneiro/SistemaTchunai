import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { PedidoModel } from '../../../models/pedido.model';
import { PedidoService } from '../../../services/pedido.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './pedido-visualizar.component.html'
})
export class PedidoVisualizarComponent implements OnInit {

  entity: PedidoModel;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'},
    {label: 'menu.cadastros.pedido', route: '/cadastros/pedido'}];

  constructor(private route: ActivatedRoute, private router: Router, private service: PedidoService, public hash: HashService) { }

  ngOnInit() {
    this.entity = this.route.snapshot.data.entity;
    if (this.entity.data) {
      this.breadcrumb.push({label: this.entity.id.toString()});
    } else {
      this.breadcrumb.push({label: 'general.labels.view'});
    }
  }

    delete(item): void {
      this.service.confirmAndDelete(item.id).then(() => this.router.navigate(['../../'], { relativeTo: this.route }));
    }
}
