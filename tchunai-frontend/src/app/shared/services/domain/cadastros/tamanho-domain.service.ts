import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomainService } from '@shared/services/base/domain.service';

export class TamanhoDominioModel {
    id;
    descricao;
}

@Injectable({
    providedIn: 'root'
})
export class TamanhoDominioService extends DomainService<TamanhoDominioModel> {
    constructor(http: HttpClient) {
        super(http, 'api/dominio/tamanho');
    }
}
