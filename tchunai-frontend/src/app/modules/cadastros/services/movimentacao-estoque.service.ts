import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { MovimentacaoEstoqueModel } from '../models/movimentacao-estoque.model';
import { MovimentacaoEstoqueResumoModel } from '../models/movimentacao-estoque-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class MovimentacaoEstoqueService extends CrudService<MovimentacaoEstoqueResumoModel> implements Resolve<MovimentacaoEstoqueModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/movimentacaoestoque';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<MovimentacaoEstoqueModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
