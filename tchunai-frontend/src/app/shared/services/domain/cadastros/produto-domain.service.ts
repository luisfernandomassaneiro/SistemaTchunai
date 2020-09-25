import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomainService } from '@shared/services/base/domain.service';

export class ProdutoDominioModel {
    id;
    descricao;
}

@Injectable({
    providedIn: 'root'
})
export class ProdutoDominioService extends DomainService<ProdutoDominioModel> {
    constructor(http: HttpClient) {
        super(http, 'api/dominio/produto');
    }
}
