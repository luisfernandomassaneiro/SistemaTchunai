import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class OrigemMovimentacaoDominioService {

    constructor(private http: HttpClient) {}

    static baseUrl(): string {
        return 'api/dominio/origemmovimentacao';
    }

    public list(): Observable<string[]> {
        return this.http.get<string[]>(OrigemMovimentacaoDominioService.baseUrl());
    }
}
