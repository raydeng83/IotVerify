import {Component} from 'angular2/core';
import {UserList} from './user-list.component';

@Component({
    selector: 'my-app',
    directives: [UserList],
    template: `
      <user-list></user-list>
    `
})
export class AppComponent { }
