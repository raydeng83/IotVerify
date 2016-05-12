import {Component} from '@angular/core';
import {User} from '../models/user';
import {UserService} from '../services/user.service';
import {PhoneNumber} from '../models/phoneNumber';
import {PhoneNumberService} from '../services/phoneNumber.service';

@Component({
    selector: 'add-user',
    templateUrl: 'app/components/add-user.component.html'
})
export class AddUser {
    newUser: User = new User();
    newPhoneNumber1: PhoneNumber = new PhoneNumber();
    newPhoneNumber2: PhoneNumber = new PhoneNumber();

    userAdded: boolean = false;


    constructor(private userService: UserService, private PhoneNumberService: PhoneNumberService) { }

    onSubmit() {
        this.newUser.creationDate = new Date();
        this.newUser.tokenExpireTime = 60;
        this.newUser.type = 'normal';

        this.newPhoneNumber1.userId = this.newUser.userId;
        this.newPhoneNumber1.creationDate = new Date();
        this.newPhoneNumber1.userName = this.newUser.userName;

        this.newPhoneNumber2.userId = this.newUser.userId;
        this.newPhoneNumber2.creationDate = new Date();
        this.newPhoneNumber2.userName = this.newUser.userName;

        this.userService.addUser(this.newUser).subscribe(
            user => {
                this.PhoneNumberService.addPhoneNumber(this.newPhoneNumber1).subscribe(
                    user => { },
                    err => console.error(err),
                    () => console.log('done loading')
                );

                this.PhoneNumberService.addPhoneNumber(this.newPhoneNumber2).subscribe(
                    user => { },
                    err => console.error(err),
                    () => console.log('done loading')
                );

                this.userAdded = true;
            },
            err => console.error(err),
            () => console.log('done loading')
        )


    }
}
