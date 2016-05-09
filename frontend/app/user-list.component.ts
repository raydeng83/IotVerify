import {Component} from '@angular/core';
import {UserService} from './user.service';

@Component({
  selector:'user-list',
  templateUrl: 'app/user-list.component.html'
})
export class UserList {
  public users;

  constructor (private userService: UserService) {
    this.getUsers();
  }

  ngOnInit() {
  }

  getUsers() {
    this.userService.getUsers().subscribe(
      // the first argument is a function which runs on success
      data => { this.users = data},
      // the second argument is a function which runs on error
      err => console.error(err),
      // the third argument is a function which runs on completion
      () => console.log('done loading')
    );
  }
}
