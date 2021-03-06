import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { ReactiveFormsUtils } from '@shared/utils/reactive-forms.utils';
import { ComparatorUtils } from '@shared/utils/comparator.utils';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ValidationService } from '@shared/services/validation.service';
import { ColecaoService } from '../../../services/colecao.service';
import { ColecaoModel } from '../../../models/colecao.model';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './colecao-manter.component.html'
})
export class ColecaoManterComponent implements OnInit {

  comparator = ComparatorUtils.getInstance();
  entity: ColecaoModel;
  title: string;
  form: FormGroup;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'}, {label: 'menu.cadastros.colecao', route: '/cadastros/colecao'}];

  constructor(
    private service: ColecaoService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hash: HashService,
) {}

  ngOnInit(): void {


    this.entity = this.route.snapshot.data.entity || new ColecaoModel();
    if (this.entity.id) {
      this.title = 'cadastros.colecao.edit.title';
      this.breadcrumb.push({label: this.entity.descricao, route: ['../../visualizar/' + this.hash.encode(this.entity.id)]});
      this.breadcrumb.push({label: 'general.labels.edit'});
    } else {
      this.title = 'cadastros.colecao.add.title';
      this.breadcrumb.push({label: 'general.labels.add'});
    }

    this.form = this.formBuilder.group({
      id: [this.entity.id, []],
      descricao: [this.entity.descricao, []],
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
