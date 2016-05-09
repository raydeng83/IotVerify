import {Component} from '@angular/core';
import {UserList} from './user-list.component';
import {RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router-deprecated';
import {NavBar} from './nav-bar.component';
import {TagList} from './tag-list.component'
import { HTTP_PROVIDERS } from '@angular/http';
import {UserService} from './user.service';



@Component({
    selector: 'my-app',
    directives: [UserList, NavBar, ROUTER_DIRECTIVES, TagList],
    providers: [ROUTER_PROVIDERS, HTTP_PROVIDERS, UserService],
    template: `
      <nav-bar></nav-bar>
      <router-outlet></router-outlet>
    `
})

@RouteConfig([
  {path: '/user-list', name: 'UserList', component: UserList, useAsDefault:true},
  {path: '/tag-list', name: 'TagList', component: TagList}
])
export class AppComponent { }
