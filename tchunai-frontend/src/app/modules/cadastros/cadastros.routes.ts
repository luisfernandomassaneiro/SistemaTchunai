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
  }
];

export const CadastrosRoutes = ROUTES;
