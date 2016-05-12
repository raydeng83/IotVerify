import {Component} from '@angular/core';
import {User} from '../models/user';
import {UserService} from '../services/user.service';
import {PhoneNumber} from '../models/phoneNumber';

@Component({
  selector: 'add-user',
  templateUrl: 'app/components/add-user.component.html'
})
export class AddUser {
  newUser: User = new User();
  newPhoneNumber1: PhoneNumber = new PhoneNumber();
  newPhoneNumber2: PhoneNumber = new PhoneNumber();

}
