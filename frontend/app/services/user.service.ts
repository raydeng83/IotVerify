import {Injectable} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {User} from '../models/user';


@Injectable()
export class UserService {
  constructor (private http:Http) {}

  getUsers() {
    return this.http.get('http://localhost:8080/rest/user/users').map((res:Response) => res.json());
  }

  getUserByUserId(userId:number) {
    return this.http.post('http://localhost:8080/rest/user/userId', userId+'').map((res:Response) => res.json());
  }

  deleteUser(userId: number) {
    return this.http.delete('http://localhost:8080/rest/user/delete/'+userId).map((res:Response) => res);
  }

  addUser(user: User) {
    let headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post('http://localhost:8080/rest/user/add/', JSON.stringify(user), {headers: headers}).map((res:Response) => res);
  }
}
