import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { MarcaModel } from '../models/marca.model';
import { MarcaResumoModel } from '../models/marca-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class MarcaService extends CrudService<MarcaResumoModel> implements Resolve<MarcaModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/marca';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<MarcaModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
