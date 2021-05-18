import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomainService } from '@shared/services/base/domain.service';

export class CategoriaDominioModel {
    id;
    descricao;
}

@Injectable({
    providedIn: 'root'
})
export class CategoriaDominioService extends DomainService<CategoriaDominioModel> {
    constructor(http: HttpClient) {
        super(http, 'api/dominio/categoria');
    }
}
