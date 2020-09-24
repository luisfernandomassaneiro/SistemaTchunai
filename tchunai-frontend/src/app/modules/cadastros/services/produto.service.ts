import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { ProdutoModel } from '../models/produto.model';
import { ProdutoResumoModel } from '../models/produto-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class ProdutoService extends CrudService<ProdutoResumoModel> implements Resolve<ProdutoModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/produto';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<ProdutoModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
