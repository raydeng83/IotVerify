import {Injectable} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {User} from '../models/user';
import {Log} from '../models/log';


@Injectable()
export class LogService {

  constructor (private http:Http) {}

  getLogs() {
    return this.http.get('http://localhost:8080/rest/log/allLogs').map((res:Response) => res.json());
  }

  addLog (log: Log) {
    let headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post('http://localhost:8080/rest/log/add/', JSON.stringify(log), {headers: headers}).map((res:Response) => res);
  }

  delete(log: Log) {
    return this.http.delete('http://localhost:8080/rest/log/delete/'+log.logEventId).map((res:Response) => res);
  }
}
