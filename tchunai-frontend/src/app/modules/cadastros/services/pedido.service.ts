import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { PedidoModel } from '../models/pedido.model';
import { PedidoResumoModel } from '../models/pedido-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class PedidoService extends CrudService<PedidoResumoModel> implements Resolve<PedidoModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/pedido';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<PedidoModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
