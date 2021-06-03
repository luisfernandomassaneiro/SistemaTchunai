import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomainService } from '@shared/services/base/domain.service';

export class ColecaoDominioModel {
    id;
    descricao;
}

@Injectable({
    providedIn: 'root'
})
export class ColecaoDominioService extends DomainService<ColecaoDominioModel> {
    constructor(http: HttpClient) {
        super(http, 'api/dominio/colecao');
    }
}
