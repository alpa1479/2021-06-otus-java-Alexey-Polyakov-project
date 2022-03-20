import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {environment} from 'src/environments/environment';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RepositoryService<T> {

  constructor(private http: HttpClient) {
  }

  public get(route: string): Observable<T> {
    return this.http.get<T>(this.createCompleteRoute(route, environment.url));
  }

  public create(route: string, body: any): Observable<T> {
    return this.http.post<T>(this.createCompleteRoute(route, environment.url), body, this.generateHeaders());
  }

  public update(route: string, body: any): Observable<T> {
    return this.http.put<T>(this.createCompleteRoute(route, environment.url), body, this.generateHeaders());
  }

  public delete(route: string): Observable<T> {
    return this.http.delete<T>(this.createCompleteRoute(route, environment.url));
  }

  private createCompleteRoute = (route: string, env: string) => {
    return `${env}/${route}`;
  }

  private generateHeaders = () => {
    return {
      headers: new HttpHeaders({'Content-Type': 'application/json'})
    }
  }
}
