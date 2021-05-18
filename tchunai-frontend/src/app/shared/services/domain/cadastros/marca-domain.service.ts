import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomainService } from '@shared/services/base/domain.service';

export class MarcaDominioModel {
    id;
    descricao;
}

@Injectable({
    providedIn: 'root'
})
export class MarcaDominioService extends DomainService<MarcaDominioModel> {
    constructor(http: HttpClient) {
        super(http, 'api/dominio/marca');
    }
}
