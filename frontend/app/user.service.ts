import {Injectable} from 'angular2/core';
import {Http, Response} from 'angular2/http';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class UserService {
  constructor (private http:Http) {}

  getUsers() {
    return this.http.get('http://localhost:8080/rest/user/users').map((res:Response) => res.json());
  }
}
