import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { ReactiveFormsUtils } from '@shared/utils/reactive-forms.utils';
import { ComparatorUtils } from '@shared/utils/comparator.utils';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ValidationService } from '@shared/services/validation.service';
import { MovimentacaoEstoqueService } from '../../../services/movimentacao-estoque.service';
import { MovimentacaoEstoqueModel } from '../../../models/movimentacao-estoque.model';
import { ProdutoDominioService } from '@shared/services/domain/cadastros/produto-domain.service';
import { TipoMovimentacaoDominioService } from '@shared/services/domain/cadastros/tipo-movimentacao-domain.service';
import { OrigemMovimentacaoDominioService } from '@shared/services/domain/cadastros/origem-movimentacao-domain.service';
import { HashService } from '@shared/services/hash.service';

@Component({
  templateUrl: './movimentacao-estoque-manter.component.html'
})
export class MovimentacaoEstoqueManterComponent implements OnInit {

  comparator = ComparatorUtils.getInstance();
  entity: MovimentacaoEstoqueModel;
  title: string;
  form: FormGroup;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'}, {label: 'menu.cadastros.movimentacaoestoque', route: '/cadastros/movimentacaoestoque'}];
  tipoMovimentacaoDomain: string[] = [];
  origemMovimentacaoDomain: string[] = [];

  constructor(
    public produtoService: ProdutoDominioService,
    public tipoMovimentacaoService: TipoMovimentacaoDominioService,
    public origemMovimentacaoService: OrigemMovimentacaoDominioService,
    private service: MovimentacaoEstoqueService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hash: HashService,
) {}

  ngOnInit(): void {

    this.tipoMovimentacaoService.list().subscribe(list => this.tipoMovimentacaoDomain = list);
    this.origemMovimentacaoService.list().subscribe(list => this.origemMovimentacaoDomain = list);

    this.entity = this.route.snapshot.data.entity || new MovimentacaoEstoqueModel();
    if (this.entity.id) {
      this.title = 'cadastros.movimentacaoestoque.edit.title';
      this.breadcrumb.push({label: this.entity.nome, route: ['../../visualizar/' + this.hash.encode(this.entity.id)]});
      this.breadcrumb.push({label: 'general.labels.edit'});
    } else {
      this.title = 'cadastros.movimentacaoestoque.add.title';
      this.breadcrumb.push({label: 'general.labels.add'});
    }

    this.form = this.formBuilder.group({
      id: [this.entity.id, []],
      nome: [this.entity.nome, []],
      produto: [this.entity.produto, [Validators.required, ]],
      tipoMovimentacao: [this.entity.tipoMovimentacao, []],
      origemMovimentacao: [this.entity.origemMovimentacao, []],
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
