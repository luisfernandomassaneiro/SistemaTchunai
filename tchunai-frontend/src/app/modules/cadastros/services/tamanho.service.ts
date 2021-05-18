import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { TamanhoModel } from '../models/tamanho.model';
import { TamanhoResumoModel } from '../models/tamanho-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class TamanhoService extends CrudService<TamanhoResumoModel> implements Resolve<TamanhoModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/tamanho';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<TamanhoModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
