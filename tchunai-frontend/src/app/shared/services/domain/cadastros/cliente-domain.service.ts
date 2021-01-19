import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DomainService } from '@shared/services/base/domain.service';

export class ClienteDominioModel {
    id;
    nome;
}

@Injectable({
    providedIn: 'root'
})
export class ClienteDominioService extends DomainService<ClienteDominioModel> {
    constructor(http: HttpClient) {
        super(http, 'api/dominio/cliente');
    }
}
