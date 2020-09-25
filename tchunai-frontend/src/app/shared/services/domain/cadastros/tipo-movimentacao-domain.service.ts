import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class TipoMovimentacaoDominioService {

    constructor(private http: HttpClient) {}

    static baseUrl(): string {
        return 'api/dominio/tipomovimentacao';
    }

    public list(): Observable<string[]> {
        return this.http.get<string[]>(TipoMovimentacaoDominioService.baseUrl());
    }
}
