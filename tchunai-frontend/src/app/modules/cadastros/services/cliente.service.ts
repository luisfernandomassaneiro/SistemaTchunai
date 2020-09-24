import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { ClienteModel } from '../models/cliente.model';
import { ClienteResumoModel } from '../models/cliente-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class ClienteService extends CrudService<ClienteResumoModel> implements Resolve<ClienteModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/cliente';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<ClienteModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
