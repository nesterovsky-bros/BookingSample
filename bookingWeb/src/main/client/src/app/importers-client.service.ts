import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from "rxjs";
import { City } from './model/city';
import { environment } from 'src/environments/environment';
import { params } from './model/utils';

@Injectable({
  providedIn: 'root'
})
export class ImportersClientService 
{
  constructor(protected http: HttpClient)
  {
  }

  getCity(id: number): Observable<City|null>
  {
    return this.http.get<City|null>(
      `${environment.api}importers/city`, 
      { params: { id } });
  }

  searchCity(search?: string, offset?: number, fetch?: number): Observable<City[]>
  {
    return this.http.get<City[]>(
      `${environment.api}importers/searchCity`, 
      { params: params({ search, offset, fetch })});
  }
}
