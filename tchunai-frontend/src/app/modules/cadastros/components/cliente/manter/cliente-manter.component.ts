import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { ReactiveFormsUtils } from '@shared/utils/reactive-forms.utils';
import { ComparatorUtils } from '@shared/utils/comparator.utils';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ValidationService } from '@shared/services/validation.service';
import { ClienteService } from '../../../services/cliente.service';
import { ClienteModel } from '../../../models/cliente.model';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './cliente-manter.component.html'
})
export class ClienteManterComponent implements OnInit {

  comparator = ComparatorUtils.getInstance();
  entity: ClienteModel;
  title: string;
  form: FormGroup;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'}, {label: 'menu.cadastros.cliente', route: '/cadastros/cliente'}];

  constructor(
    private service: ClienteService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hash: HashService,
) {}

  ngOnInit(): void {


    this.entity = this.route.snapshot.data.entity || new ClienteModel();
    if (this.entity.id) {
      this.title = 'cadastros.cliente.edit.title';
      this.breadcrumb.push({label: this.entity.nome, route: ['../../visualizar/' + this.hash.encode(this.entity.id)]});
      this.breadcrumb.push({label: 'general.labels.edit'});
    } else {
      this.title = 'cadastros.cliente.add.title';
      this.breadcrumb.push({label: 'general.labels.add'});
    }

    this.form = this.formBuilder.group({
      id: [this.entity.id, []],
      nome: [this.entity.nome, []],
      endereco: [this.entity.endereco, []],
      telefone: [this.entity.telefone, []],
      email: [this.entity.email, [ValidationService.email]],
      active: [this.entity.active, []],
    });
  }

  save(model): void {
    if (!ReactiveFormsUtils.eval(this.form)) {
      return;
    }
    this.service.saveAndNotify(model, model.id).then(() => {
        history.go(-1);
    });
  }

  back() {
    history.go(-1);
  }
}
