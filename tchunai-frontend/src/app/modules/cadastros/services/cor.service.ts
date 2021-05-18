import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot } from '@angular/router';

import { CorModel } from '../models/cor.model';
import { CorResumoModel } from '../models/cor-resumo.model';

import { MessagesService } from '@shared/services/message.service';
import { CrudService } from '@shared/services/base/crud.service';
import { HashService } from '@shared/services/hash.service';

import { Observable } from 'rxjs';

@Injectable()
export class CorService extends CrudService<CorResumoModel> implements Resolve<CorModel> {

  constructor(http: HttpClient, message: MessagesService, private hash: HashService) {
    super(http, message);
  }

  baseUrl(): string {
    return 'api/cadastros/cor';
  }

  resolve(route: ActivatedRouteSnapshot): Observable<CorModel> {
    return this.get(this.hash.decode(route.params.id));
  }
}
