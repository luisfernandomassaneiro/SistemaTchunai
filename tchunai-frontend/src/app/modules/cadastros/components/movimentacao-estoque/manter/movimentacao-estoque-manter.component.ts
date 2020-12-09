import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { ReactiveFormsUtils } from '@shared/utils/reactive-forms.utils';
import { ComparatorUtils } from '@shared/utils/comparator.utils';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ValidationService } from '@shared/services/validation.service';
import { MovimentacaoEstoqueService } from '../../../services/movimentacao-estoque.service';
import { MovimentacaoEstoqueDetalheModel, MovimentacaoEstoqueModel } from '../../../models/movimentacao-estoque.model';
import { ProdutoDominioModel, ProdutoDominioService } from '@shared/services/domain/cadastros/produto-domain.service';
import { TipoMovimentacaoDominioService } from '@shared/services/domain/cadastros/tipo-movimentacao-domain.service';
import { OrigemMovimentacaoDominioService } from '@shared/services/domain/cadastros/origem-movimentacao-domain.service';
import { HashService } from '@shared/services/hash.service';
import { MessagesService, NotificationType } from '@shared/services/message.service';

@Component({
  templateUrl: './movimentacao-estoque-manter.component.html'
})
export class MovimentacaoEstoqueManterComponent implements OnInit {

  comparator = ComparatorUtils.getInstance();
  entity: MovimentacaoEstoqueModel;
  title: string;
  form: FormGroup;
  produtoForm: FormGroup;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'}, {label: 'menu.cadastros.movimentacaoestoque', route: '/cadastros/movimentacaoestoque'}];
  tipoMovimentacaoDomain: string[] = [];
  origemMovimentacaoDomain: string[] = [];
  isModalVisible: boolean = false;
  produtos: ProdutoDominioModel[] = []

  constructor(
    public produtoService: ProdutoDominioService,
    public tipoMovimentacaoService: TipoMovimentacaoDominioService,
    private service: MovimentacaoEstoqueService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hash: HashService,
    private messageService: MessagesService
) {}

  ngOnInit(): void {

    this.tipoMovimentacaoService.list().subscribe(list => this.tipoMovimentacaoDomain = list);
    this.produtoService.list().subscribe(list => this.produtos = list);

    this.entity = this.route.snapshot.data.entity || new MovimentacaoEstoqueModel();
    if (this.entity.id) {
      this.title = 'cadastros.movimentacaoestoque.edit.title';
      this.breadcrumb.push({label: this.entity.notaFiscal, route: ['../../visualizar/' + this.hash.encode(this.entity.id)]});
      this.breadcrumb.push({label: 'general.labels.edit'});
    } else {
      this.title = 'cadastros.movimentacaoestoque.add.title';
      this.breadcrumb.push({label: 'general.labels.add'});
    }

    this.form = this.formBuilder.group({
      id: [this.entity.id, []],
      notaFiscal: [this.entity.notaFiscal, []],
      tipoMovimentacao: [this.entity.tipoMovimentacao, []],
      data: [this.entity.data, []],
      
    });

    this.produtoForm = this.formBuilder.group({
      produto: [null, [Validators.required]],
      quantidade: [null, [Validators.required]]
    })
  }

  openModal(): void {
    this.produtoForm.reset();
    this.isModalVisible = true;
  }

  insereProduto(model) {
    if (!ReactiveFormsUtils.eval(this.form)) {
      return;
    }

    let movimentacaoEstoqueDetalhe;
    let movimentacaoEstoqueDetalheProduto;
    if (this.entity.movimentacaoEstoqueDetalhes && this.entity.movimentacaoEstoqueDetalhes.length > 0) {
      movimentacaoEstoqueDetalheProduto = this.entity.movimentacaoEstoqueDetalhes.filter(med => med.produto.id === model.produto.id);
    }

    if (movimentacaoEstoqueDetalheProduto && movimentacaoEstoqueDetalheProduto.length > 0) {
      movimentacaoEstoqueDetalheProduto[0].quantidade += model.quantidade
    } else {
      movimentacaoEstoqueDetalhe = new MovimentacaoEstoqueDetalheModel();
      movimentacaoEstoqueDetalhe.produto = model.produto;
      movimentacaoEstoqueDetalhe.quantidade = model.quantidade;
      this.entity.movimentacaoEstoqueDetalhes.push(movimentacaoEstoqueDetalhe);
    }
    this.messageService.notifyI18n('cadastros.movimentacaoestoque.mensagem.produto_adicionado', NotificationType.Success);
    this.produtoForm.reset();
  }

  save(model): void {
    if (!ReactiveFormsUtils.eval(this.form)) {
      return;
    }

    model.movimentacaoEstoqueDetalhes = this.entity.movimentacaoEstoqueDetalhes;
    this.service.saveAndNotify(model, model.id).then(() => {
        history.go(-1);
    });
  }

  back() {
    history.go(-1);
  }

  delete(movimentacaoEstoqueDetalhe: MovimentacaoEstoqueDetalheModel) {
    this.entity.movimentacaoEstoqueDetalhes = this.entity.movimentacaoEstoqueDetalhes.filter(med => med !== movimentacaoEstoqueDetalhe);
  }
}
