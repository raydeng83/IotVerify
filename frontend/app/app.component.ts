import {Component} from '@angular/core';
import {UserList} from './components/user-list.component';
import {RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router-deprecated';
import {NavBar} from './components/nav-bar.component';
import {TagList} from './components/tag-list.component'
import { HTTP_PROVIDERS } from '@angular/http';
import {UserService} from './services/user.service';
import {DeviceService} from './services/device.service';

@Component({
    selector: 'my-app',
    directives: [UserList, NavBar, ROUTER_DIRECTIVES, TagList],
    providers: [ROUTER_PROVIDERS, HTTP_PROVIDERS, UserService, DeviceService],
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
