import {Injectable} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {PhoneNumber} from '../models/phoneNumber';

@Injectable()
export class PhoneNumberService {

  constructor (private http:Http) {}

  addPhoneNumber(phoneNumber: PhoneNumber) {
    let headers = new Headers({'Content-Type': 'application/json'});

    return this.http.post('http://localhost:8080/rest/phoneNumber/add', JSON.stringify(phoneNumber), {headers: headers}).map((res:Response) => res.json());
  }
}
