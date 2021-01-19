import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { ReactiveFormsUtils } from '@shared/utils/reactive-forms.utils';
import { ComparatorUtils } from '@shared/utils/comparator.utils';
import { BreadCrumbItem } from '@shared/components/layout/page-header.component';
import { ValidationService } from '@shared/services/validation.service';
import { PedidoService } from '../../../services/pedido.service';
import { PedidoDetalheModel, PedidoModel } from '../../../models/pedido.model';
import { ClienteDominioService } from '@shared/services/domain/cadastros/cliente-domain.service';
import { HashService } from '@shared/services/hash.service';
import { ProdutoDominioModel, ProdutoDominioService } from '@shared/services/domain/cadastros/produto-domain.service';
import { MessagesService, NotificationType } from '@shared/services/message.service';

@Component({
  templateUrl: './pedido-manter.component.html'
})
export class PedidoManterComponent implements OnInit {

  comparator = ComparatorUtils.getInstance();
  entity: PedidoModel;
  title: string;
  form: FormGroup;
  produtoForm: FormGroup;
  breadcrumb: BreadCrumbItem[] = [{label: 'menu.home', route: '/'}, {label: 'menu.cadastros.pedido', route: '/cadastros/pedido'}];
  isModalVisible: boolean = false;
  produtos: ProdutoDominioModel[] = []

  constructor(
    public clienteService: ClienteDominioService,
    public produtoService: ProdutoDominioService,
    private service: PedidoService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private hash: HashService,
    private messageService: MessagesService
) {}

  ngOnInit(): void {
    this.produtoService.list().subscribe(list => this.produtos = list);

    this.entity = this.route.snapshot.data.entity || new PedidoModel();
    if (this.entity.id) {
      this.title = 'cadastros.pedido.edit.title';
      this.breadcrumb.push({label: this.entity.id.toString(), route: ['../../visualizar/' + this.hash.encode(this.entity.id)]});
      this.breadcrumb.push({label: 'general.labels.edit'});
    } else {
      this.title = 'cadastros.pedido.add.title';
      this.breadcrumb.push({label: 'general.labels.add'});
    }

    this.form = this.formBuilder.group({
      id: [this.entity.id, []],
      data: [this.entity.data, [Validators.required]],
      cliente: [this.entity.cliente, [Validators.required, ]],
      valorTotal: [this.entity.valorTotal, []],
    });

    this.produtoForm = this.formBuilder.group({
      produto: [null, [Validators.required]],
      quantidade: [null, [Validators.required]]
    })
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

  openModal(): void {
    this.produtoForm.reset();
    this.isModalVisible = true;
  }

  
  insereProduto(model) {
    if (!ReactiveFormsUtils.eval(this.produtoForm)) {
      return;
    }

    let pedidoDetalhes;
    let pedidoDetalhesProduto;
    if (this.entity.pedidoDetalhes && this.entity.pedidoDetalhes.length > 0) {
      pedidoDetalhesProduto = this.entity.pedidoDetalhes.filter(med => med.produto.id === model.produto.id);
    }

    if (pedidoDetalhesProduto && pedidoDetalhesProduto.length > 0) {
      pedidoDetalhesProduto[0].quantidade += model.quantidade
    } else {
      pedidoDetalhes = new PedidoDetalheModel();
      pedidoDetalhes.produto = model.produto;
      pedidoDetalhes.quantidade = model.quantidade;
      this.entity.pedidoDetalhes.push(pedidoDetalhes);
    }
    this.messageService.notifyI18n('cadastros.movimentacaoestoque.mensagem.produto_adicionado', NotificationType.Success);
    this.produtoForm.reset();
  }

  delete(pedidoDetalhes: PedidoDetalheModel) {
    this.entity.pedidoDetalhes = this.entity.pedidoDetalhes.filter(med => med !== pedidoDetalhes);
  }
}
