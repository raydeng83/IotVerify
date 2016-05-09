import {Component} from '@angular/core';
import {UserList} from './user-list.component';

@Component({
    selector: 'my-app',
    directives: [UserList],
    template: `
      <user-list></user-list>
    `
})
export class AppComponent { }
