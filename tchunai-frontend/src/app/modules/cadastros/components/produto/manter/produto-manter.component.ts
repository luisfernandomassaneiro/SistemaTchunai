import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { ReactiveFormsUtils } from '@shared/utils/reactive-forms.utils';
import { ComparatorUtils } from '@shared/utils/comparator.utils';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ValidationService } from '@shared/services/validation.service';
import { ProdutoService } from '../../../services/produto.service';
import { ProdutoModel } from '../../../models/produto.model';
import { HashService } from '@shared/services/hash.service';
import { CorDominioService } from '@shared/services/domain/cadastros/cor-domain.service';
import { TamanhoDominioService } from '@shared/services/domain/cadastros/tamanho-domain.service';
import { CategoriaDominioService } from '@shared/services/domain/cadastros/categoria-domain.service';
import { MarcaDominioService } from '@shared/services/domain/cadastros/marca-domain.service';

@Component({
  templateUrl: './produto-manter.component.html'
})
export class ProdutoManterComponent implements OnInit {

  comparator = ComparatorUtils.getInstance();
  entity: ProdutoModel;
  title: string;
  form: FormGroup;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'}, {label: 'menu.cadastros.produto', route: '/cadastros/produto'}];

  constructor(
    private service: ProdutoService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hash: HashService,
    public corService: CorDominioService,
    public categoriaService: CategoriaDominioService,
    public tamanhoService: TamanhoDominioService,
    public marcaService: MarcaDominioService
) {}

  ngOnInit(): void {


    this.entity = this.route.snapshot.data.entity || new ProdutoModel();
    if (this.entity.id) {
      this.title = 'cadastros.produto.edit.title';
      this.breadcrumb.push({label: this.entity.descricao, route: ['../../visualizar/' + this.hash.encode(this.entity.id)]});
      this.breadcrumb.push({label: 'general.labels.edit'});
    } else {
      this.title = 'cadastros.produto.add.title';
      this.breadcrumb.push({label: 'general.labels.add'});
    }

    this.form = this.formBuilder.group({
      id: [this.entity.id, []],
      descricao: [this.entity.descricao, []],
      precoCusto: [this.entity.precoCusto, []],
      precoVenda: [this.entity.precoVenda, []],
      percentualLucro: [this.entity.percentualLucro ? this.entity.percentualLucro : 100, []],
      peso: [this.entity.peso, []],
      active: [this.entity.active, []],
      quantidadeAtual: [this.entity.quantidadeAtual, []],
      cor: [this.entity.cor, []],
      marca: [this.entity.marca, []],
      tamanho: [this.entity.tamanho, []],
      categoria: [this.entity.categoria, []],
      codigoBarras: [this.entity.codigoBarras, []]
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

  calculaValorVenda() {
    let percentualLucro = this.form.get('percentualLucro').value;
    let precoCusto = this.form.get('precoCusto').value;
    if (precoCusto && percentualLucro) {
      let precoVenda = ((percentualLucro/100) * precoCusto) + precoCusto;
      this.form.get('precoVenda').setValue(precoVenda);
    }
  }
}
