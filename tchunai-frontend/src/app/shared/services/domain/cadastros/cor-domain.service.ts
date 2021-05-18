import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomainService } from '@shared/services/base/domain.service';

export class CorDominioModel {
    id;
    descricao;
}

@Injectable({
    providedIn: 'root'
})
export class CorDominioService extends DomainService<CorDominioModel> {
    constructor(http: HttpClient) {
        super(http, 'api/dominio/cor');
    }
}
