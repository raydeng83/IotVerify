import {Component} from '@angular/core';
import {UserService} from './user.service';
import {NavBar} from './nav-bar.component';

@Component({
  selector:'user-list',
  directives: [NavBar],
  templateUrl: 'app/user-list.component.html'
})
export class UserList {
  public users;

  constructor (private _userService: UserService) {}

  ngOnInit() {
    this.getUsers();
  }

  getUsers() {
    this._userService.getUsers().subscribe(
      // the first argument is a function which runs on success
      data => { this.users = data},
      // the second argument is a function which runs on error
      err => console.error(err),
      // the third argument is a function which runs on completion
      () => console.log('done loading')
    );
  }
}
