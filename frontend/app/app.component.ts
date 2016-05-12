import {Component} from '@angular/core';
import {UserList} from './components/user-list.component';
import {RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS} from '@angular/router-deprecated';
import {NavBar} from './components/nav-bar.component';
import {TagList} from './components/tag-list.component'
import { HTTP_PROVIDERS } from '@angular/http';
import {UserService} from './services/user.service';
import {DeviceService} from './services/device.service';
import {LogService} from './services/log.service';
import {LogList} from './components/log-list.component';
import {AddUser} from './components/add-user.component';
import {PhoneNumberService} from './services/phoneNumber.service';

@Component({
    selector: 'my-app',
    directives: [UserList, NavBar, ROUTER_DIRECTIVES, TagList],
    providers: [ROUTER_PROVIDERS, HTTP_PROVIDERS, UserService, DeviceService, LogService, PhoneNumberService],
    template: `
    <img src="resources/images/IotVerify-logo.png" class="ui image medium centered" />
    <hr>
      <nav-bar></nav-bar>
      <router-outlet></router-outlet>
    `
})

@RouteConfig([
    { path: '/user-list', name: 'UserList', component: UserList, useAsDefault: true },
    { path: '/tag-list', name: 'TagList', component: TagList },
    { path: '/log-list', name: 'LogList', component: LogList },
    { path: '/add-user', name: 'AddUser', component: AddUser },
])
export class AppComponent { }
