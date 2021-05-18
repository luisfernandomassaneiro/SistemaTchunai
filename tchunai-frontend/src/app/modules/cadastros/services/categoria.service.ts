import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { CategoriaModel } from '../models/categoria.model';
import { CategoriaResumoModel } from '../models/categoria-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class CategoriaService extends CrudService<CategoriaResumoModel> implements Resolve<CategoriaModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/categoria';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<CategoriaModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
