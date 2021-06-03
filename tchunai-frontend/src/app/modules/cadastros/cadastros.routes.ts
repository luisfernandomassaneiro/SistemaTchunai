import { ColecaoManterComponent } from './components/colecao/manter/colecao-manter.component';
import { ColecaoService } from './services/colecao.service';
import { ColecaoVisualizarComponent } from './components/colecao/visualizar/colecao-visualizar.component';
import { ColecaoListarComponent } from './components/colecao/listar/colecao-listar.component';
import { TamanhoManterComponent } from './components/tamanho/manter/tamanho-manter.component';
import { TamanhoService } from './services/tamanho.service';
import { TamanhoVisualizarComponent } from './components/tamanho/visualizar/tamanho-visualizar.component';
import { TamanhoListarComponent } from './components/tamanho/listar/tamanho-listar.component';
import { MarcaManterComponent } from './components/marca/manter/marca-manter.component';
import { MarcaService } from './services/marca.service';
import { MarcaVisualizarComponent } from './components/marca/visualizar/marca-visualizar.component';
import { MarcaListarComponent } from './components/marca/listar/marca-listar.component';
import { CorManterComponent } from './components/cor/manter/cor-manter.component';
import { CorService } from './services/cor.service';
import { CorVisualizarComponent } from './components/cor/visualizar/cor-visualizar.component';
import { CorListarComponent } from './components/cor/listar/cor-listar.component';
import { CategoriaManterComponent } from './components/categoria/manter/categoria-manter.component';
import { CategoriaService } from './services/categoria.service';
import { CategoriaVisualizarComponent } from './components/categoria/visualizar/categoria-visualizar.component';
import { CategoriaListarComponent } from './components/categoria/listar/categoria-listar.component';
import { PedidoManterComponent } from './components/pedido/manter/pedido-manter.component';
import { PedidoService } from './services/pedido.service';
import { PedidoVisualizarComponent } from './components/pedido/visualizar/pedido-visualizar.component';
import { PedidoListarComponent } from './components/pedido/listar/pedido-listar.component';
import { MovimentacaoEstoqueManterComponent } from './components/movimentacao-estoque/manter/movimentacao-estoque-manter.component';
import { MovimentacaoEstoqueService } from './services/movimentacao-estoque.service';
import { MovimentacaoEstoqueVisualizarComponent } from './components/movimentacao-estoque/visualizar/movimentacao-estoque-visualizar.component';
import { MovimentacaoEstoqueListarComponent } from './components/movimentacao-estoque/listar/movimentacao-estoque-listar.component';
import { ProdutoManterComponent } from './components/produto/manter/produto-manter.component';
import { ProdutoService } from './services/produto.service';
import { ProdutoVisualizarComponent } from './components/produto/visualizar/produto-visualizar.component';
import { ProdutoListarComponent } from './components/produto/listar/produto-listar.component';
import { ClienteManterComponent } from './components/cliente/manter/cliente-manter.component';
import { ClienteService } from './services/cliente.service';
import { ClienteVisualizarComponent } from './components/cliente/visualizar/cliente-visualizar.component';
import { ClienteListarComponent } from './components/cliente/listar/cliente-listar.component';

const ROUTES = [
  {
    path: 'cliente',
    children: [
      {
        path: '',
        component: ClienteListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: ClienteService
        },
        component: ClienteVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: ClienteService
        },
        component: ClienteManterComponent
      },
      {
        path: 'incluir',
        component: ClienteManterComponent
      } ]
  },
  {
    path: 'produto',
    children: [
      {
        path: '',
        component: ProdutoListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: ProdutoService
        },
        component: ProdutoVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: ProdutoService
        },
        component: ProdutoManterComponent
      },
      {
        path: 'incluir',
        component: ProdutoManterComponent
      } ]
  },
  {
    path: 'movimentacaoestoque',
    children: [
      {
        path: '',
        component: MovimentacaoEstoqueListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: MovimentacaoEstoqueService
        },
        component: MovimentacaoEstoqueVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: MovimentacaoEstoqueService
        },
        component: MovimentacaoEstoqueManterComponent
      },
      {
        path: 'incluir',
        component: MovimentacaoEstoqueManterComponent
      } ]
  },
  {
    path: 'pedido',
    children: [
      {
        path: '',
        component: PedidoListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: PedidoService
        },
        component: PedidoVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: PedidoService
        },
        component: PedidoManterComponent
      },
      {
        path: 'incluir',
        component: PedidoManterComponent
      } ]
  },
  {
    path: 'categoria',
    children: [
      {
        path: '',
        component: CategoriaListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: CategoriaService
        },
        component: CategoriaVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: CategoriaService
        },
        component: CategoriaManterComponent
      },
      {
        path: 'incluir',
        component: CategoriaManterComponent
      } ]
  },
  {
    path: 'cor',
    children: [
      {
        path: '',
        component: CorListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: CorService
        },
        component: CorVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: CorService
        },
        component: CorManterComponent
      },
      {
        path: 'incluir',
        component: CorManterComponent
      } ]
  },
  {
    path: 'marca',
    children: [
      {
        path: '',
        component: MarcaListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: MarcaService
        },
        component: MarcaVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: MarcaService
        },
        component: MarcaManterComponent
      },
      {
        path: 'incluir',
        component: MarcaManterComponent
      } ]
  },
  {
    path: 'tamanho',
    children: [
      {
        path: '',
        component: TamanhoListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: TamanhoService
        },
        component: TamanhoVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: TamanhoService
        },
        component: TamanhoManterComponent
      },
      {
        path: 'incluir',
        component: TamanhoManterComponent
      } ]
  },
  {
    path: 'colecao',
    children: [
      {
        path: '',
        component: ColecaoListarComponent
      },
      {
        path: 'visualizar/:id',
        resolve: {
          entity: ColecaoService
        },
        component: ColecaoVisualizarComponent
      },
      {
        path: 'alterar/:id',
        resolve: {
          entity: ColecaoService
        },
        component: ColecaoManterComponent
      },
      {
        path: 'incluir',
        component: ColecaoManterComponent
      } ]
  }
];

export const CadastrosRoutes = ROUTES;
