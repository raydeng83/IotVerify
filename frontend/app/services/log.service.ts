import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {User} from '../models/user';


@Injectable()
export class LogService {

  constructor (private http:Http) {}

  getLogs() {
    return this.http.get('http://localhost:8080/rest/log/allLogs').map((res:Response) => res.json());
  }
}
