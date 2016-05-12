import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class DeviceService {
  constructor (private http:Http) {}

  findDevicesByUserId(userId: number) {
    return this.http.post('http://localhost:8080/rest/device/userId', userId+'').map((res:Response) => res.json());
  }

  findAllDevices(){
    return this.http.get('http://localhost:8080/rest/device/allDevices').map((res:Response) => res.json());
  }

  deleteDevice(deviceId: number) {
    return this.http.delete('http://localhost:8080/rest/device/delete/'+deviceId).map((res:Response) => res);
  }
}
