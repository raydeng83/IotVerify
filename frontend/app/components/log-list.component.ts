//<reference path="../../typings/jquery/jquery.d.ts" />
//<reference path="../../node_modules/retyped-jqueryui-tsd-ambient/jqueryui.d.ts" />

import {Component} from '@angular/core';
import {UserService} from '../services/user.service';
import {DeviceService} from '../services/device.service';
import {User} from '../models/user';
import {Device} from '../models/device';
import {Log} from '../models/log';
import {LogService} from '../services/log.service';

@Component({
  selector: 'log',
  templateUrl: '/app/components/log-list.component.html'
})
export class LogList{
  public users: User[];
  public devices: Device[];
  public logs: Log[];

  constructor(private userService: UserService, private deviceService: DeviceService, private logService:LogService) {
      this.logs=[];
      this.devices=[];
      this.getLogs();
  }

  getLogs() {
    this.logService.getLogs().subscribe(
        // the first argument is a function which runs on success
        logs => {
            this.logs = logs;
            for (let i=0; i < this.logs.length; i++) {
              let log = new Log();
              this.userService.getUserByUserId(logs[i].userId).subscribe(
                user => {
                  log.logEventId=logs[i].logEventId;
                  log.eventName=logs[i].eventName;
                  log.eventDescription=logs[i].eventDescription;
                  log.userName=user.userName;
                  log.deviceUUID=logs[i].deviceUUID;
                  log.tagId=logs[i].tagId;
                  log.creationDate=logs[i].creationDate;
                  this.logs.push(log);
                }
              );

            }
        },
        // the second argument is a function which runs on error
        err => console.error(err),
        // the third argument is a function which runs on completion
        () => console.log('done loading')
    );
  }

  onDelete (log: Log) {
    this.logService.delete(log).subscribe(
      // the first argument is a function which runs on success
      data => {this.getLogs();},
      // the second argument is a function which runs on error
      err => console.error(err),
      // the third argument is a function which runs on completion
      () => console.log('done loading')
    );
  }


}
