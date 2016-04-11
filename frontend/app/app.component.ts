import {Component} from 'angular2/core';
import {UserService} from './user.service';

@Component({
  selector:'my-app',
  template: `
  <h1>My First Angular 2 App</h1>
  <ul>
  <li *ngFor = "#user of users">
  {{user.userName}}
  </li>
  </ul>
  `
})
export class AppComponent {
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
