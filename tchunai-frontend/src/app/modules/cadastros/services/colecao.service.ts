import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { ColecaoModel } from '../models/colecao.model';
import { ColecaoResumoModel } from '../models/colecao-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class ColecaoService extends CrudService<ColecaoResumoModel> implements Resolve<ColecaoModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/colecao';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<ColecaoModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
