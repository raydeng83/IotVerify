import {Component} from '@angular/core';
import {UserService} from '../services/user.service';
import {DeviceService} from '../services/device.service';
import {User} from '../models/user';
import {Device} from '../models/device';
import {Tag} from '../models/Tag';

@Component({
    selector: 'tag-list',
    templateUrl: 'app/components/tag-list.component.html'
})
export class TagList {
    public users: User[];
    public devices: Device[];
    public tags: Tag[];

    constructor(private userService: UserService, private deviceService: DeviceService) {
        this.tags=[];
        this.devices=[];
        this.getUsers();
    }

    getUsers() {
        this.userService.getUsers().subscribe(
            // the first argument is a function which runs on success
            users => {
                this.users = users;
                for (let i=0; i < this.users.length; i++) {
                  this.getDevices(this.users[i].userId, i);
                }
            },
            // the second argument is a function which runs on error
            err => console.error(err),
            // the third argument is a function which runs on completion
            () => console.log('done loading')
        );
    }

    getDevices(userId:number, i: number) {
        this.deviceService.findDevicesByUserId(userId).subscribe(
            // the first argument is a function which runs on success
            devices => {
              for (let j=0;j<devices.length; j++) {
                this.devices.push(devices[j]);
                let tag = new Tag();
                tag.userName=this.users[i].userName;
                tag.tagId=devices[j].tagId;
                tag.deviceName=devices[j].deviceName;
                tag.serialNo=devices[j].serialNo;
                tag.deviceUdid=devices[j].deviceCompUdid;
                tag.androidId=devices[j].androidId;
                this.tags.push(tag);
              };
            },
            // the second argument is a function which runs on error
            err => console.error(err)
        );
    }

    getUserByUserId(userId: number) {
      this.userService.getUserByUserId(userId).subscribe(
        user => {
          console.log(user.userName);
          return user;
        },
        err => console.error(err),
        () => console.log('done loading')
      )
    }



}
