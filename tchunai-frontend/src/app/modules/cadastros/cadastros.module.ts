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
    ProdutoManterComponent
  ],
  imports: [
    SharedModule,
    RouterModule.forChild(CadastrosRoutes)
  ],
  providers: [
    ClienteService,
    ProdutoService
  ],
  entryComponents: [
  ],
  exports: [
  ]
})
export class CadastrosModule {}
