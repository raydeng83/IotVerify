import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class UserService {
  constructor (private http:Http) {}

  getUsers() {
    return this.http.get('http://localhost:8080/rest/user/users').map((res:Response) => res.json());
  }
}
