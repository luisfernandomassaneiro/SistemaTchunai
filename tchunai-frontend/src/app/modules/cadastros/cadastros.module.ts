import { PedidoService } from './services/pedido.service';
import { PedidoManterComponent } from './components/pedido/manter/pedido-manter.component';
import { PedidoFilterComponent } from './components/pedido/listar/filter/pedido-filter.component';
import { PedidoVisualizarComponent } from './components/pedido/visualizar/pedido-visualizar.component';
import { PedidoListarComponent } from './components/pedido/listar/pedido-listar.component';
import { MovimentacaoEstoqueService } from './services/movimentacao-estoque.service';
import { MovimentacaoEstoqueManterComponent } from './components/movimentacao-estoque/manter/movimentacao-estoque-manter.component';
import { MovimentacaoEstoqueFilterComponent } from './components/movimentacao-estoque/listar/filter/movimentacao-estoque-filter.component';
import { MovimentacaoEstoqueVisualizarComponent } from './components/movimentacao-estoque/visualizar/movimentacao-estoque-visualizar.component';
import { MovimentacaoEstoqueListarComponent } from './components/movimentacao-estoque/listar/movimentacao-estoque-listar.component';
import { ProdutoService } from './services/produto.service';
import { ProdutoManterComponent } from './components/produto/manter/produto-manter.component';
import { ProdutoFilterComponent } from './components/produto/listar/filter/produto-filter.component';
import { ProdutoVisualizarComponent } from './components/produto/visualizar/produto-visualizar.component';
import { ProdutoListarComponent } from './components/produto/listar/produto-listar.component';
import { ClienteService } from './services/cliente.service';
import { ClienteManterComponent } from './components/cliente/manter/cliente-manter.component';
import { ClienteFilterComponent } from './components/cliente/listar/filter/cliente-filter.component';
import { ClienteVisualizarComponent } from './components/cliente/visualizar/cliente-visualizar.component';
import { ClienteListarComponent } from './components/cliente/listar/cliente-listar.component';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { SharedModule } from '@shared/shared.module';
import { CadastrosRoutes } from './cadastros.routes';

@NgModule({
  declarations: [
    ClienteListarComponent,
    ClienteVisualizarComponent,
    ClienteFilterComponent,
    ClienteManterComponent,
    ProdutoListarComponent,
    ProdutoVisualizarComponent,
    ProdutoFilterComponent,
    ProdutoManterComponent,
    MovimentacaoEstoqueListarComponent,
    MovimentacaoEstoqueVisualizarComponent,
    MovimentacaoEstoqueFilterComponent,
    MovimentacaoEstoqueManterComponent,
    PedidoListarComponent,
    PedidoVisualizarComponent,
    PedidoFilterComponent,
    PedidoManterComponent
  ],
  imports: [
    SharedModule,
    RouterModule.forChild(CadastrosRoutes)
  ],
  providers: [
    ClienteService,
    ProdutoService,
    MovimentacaoEstoqueService,
    PedidoService
  ],
  entryComponents: [
  ],
  exports: [
  ]
})
export class CadastrosModule {}
