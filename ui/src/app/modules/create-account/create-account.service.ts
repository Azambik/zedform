import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserAccount } from '../../models/UserAccount.model';

const baseUrl = 'http://localhost:8080/api/userAccount';

@Injectable({
  providedIn: 'root'
})
export class CreateAccountService {

  constructor(private http: HttpClient) {
  }

  list(): Observable<any> {
    return this.http.get(baseUrl);
  }

  get(id: string): Observable<any> {
    return this.http.get(`${baseUrl}/${id}`);
  }

  create(data: UserAccount): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: string, data: UserAccount): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  publishUnpublish(id: string, data: UserAccount): Observable<any> {
    return this.http.put(`${baseUrl}/${id}/publish`, data);
  }

  delete(id: string): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  findByEmail(email: string): Observable<any> {
    return this.http.get(`${baseUrl}?title=${email}`);
  }
}
