import { ColecaoService } from './services/colecao.service';
import { ColecaoManterComponent } from './components/colecao/manter/colecao-manter.component';
import { ColecaoFilterComponent } from './components/colecao/listar/filter/colecao-filter.component';
import { ColecaoVisualizarComponent } from './components/colecao/visualizar/colecao-visualizar.component';
import { ColecaoListarComponent } from './components/colecao/listar/colecao-listar.component';
import { TamanhoService } from './services/tamanho.service';
import { TamanhoManterComponent } from './components/tamanho/manter/tamanho-manter.component';
import { TamanhoFilterComponent } from './components/tamanho/listar/filter/tamanho-filter.component';
import { TamanhoVisualizarComponent } from './components/tamanho/visualizar/tamanho-visualizar.component';
import { TamanhoListarComponent } from './components/tamanho/listar/tamanho-listar.component';
import { MarcaService } from './services/marca.service';
import { MarcaManterComponent } from './components/marca/manter/marca-manter.component';
import { MarcaFilterComponent } from './components/marca/listar/filter/marca-filter.component';
import { MarcaVisualizarComponent } from './components/marca/visualizar/marca-visualizar.component';
import { MarcaListarComponent } from './components/marca/listar/marca-listar.component';
import { CorService } from './services/cor.service';
import { CorManterComponent } from './components/cor/manter/cor-manter.component';
import { CorFilterComponent } from './components/cor/listar/filter/cor-filter.component';
import { CorVisualizarComponent } from './components/cor/visualizar/cor-visualizar.component';
import { CorListarComponent } from './components/cor/listar/cor-listar.component';
import { CategoriaService } from './services/categoria.service';
import { CategoriaManterComponent } from './components/categoria/manter/categoria-manter.component';
import { CategoriaFilterComponent } from './components/categoria/listar/filter/categoria-filter.component';
import { CategoriaVisualizarComponent } from './components/categoria/visualizar/categoria-visualizar.component';
import { CategoriaListarComponent } from './components/categoria/listar/categoria-listar.component';
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
    PedidoManterComponent,
    CategoriaListarComponent,
    CategoriaVisualizarComponent,
    CategoriaFilterComponent,
    CategoriaManterComponent,
    CorListarComponent,
    CorVisualizarComponent,
    CorFilterComponent,
    CorManterComponent,
    MarcaListarComponent,
    MarcaVisualizarComponent,
    MarcaFilterComponent,
    MarcaManterComponent,
    TamanhoListarComponent,
    TamanhoVisualizarComponent,
    TamanhoFilterComponent,
    TamanhoManterComponent,
    ColecaoListarComponent,
    ColecaoVisualizarComponent,
    ColecaoFilterComponent,
    ColecaoManterComponent
  ],
  imports: [
    SharedModule,
    RouterModule.forChild(CadastrosRoutes)
  ],
  providers: [
    ClienteService,
    ProdutoService,
    MovimentacaoEstoqueService,
    PedidoService,
    CategoriaService,
    CorService,
    MarcaService,
    TamanhoService,
    ColecaoService
  ],
  entryComponents: [
  ],
  exports: [
  ]
})
export class CadastrosModule {}
