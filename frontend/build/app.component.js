"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var user_list_component_1 = require('./components/user-list.component');
var router_deprecated_1 = require('@angular/router-deprecated');
var nav_bar_component_1 = require('./components/nav-bar.component');
var tag_list_component_1 = require('./components/tag-list.component');
var http_1 = require('@angular/http');
var user_service_1 = require('./services/user.service');
var device_service_1 = require('./services/device.service');
var AppComponent = (function () {
    function AppComponent() {
    }
    AppComponent = __decorate([
        core_1.Component({
            selector: 'my-app',
            directives: [user_list_component_1.UserList, nav_bar_component_1.NavBar, router_deprecated_1.ROUTER_DIRECTIVES, tag_list_component_1.TagList],
            providers: [router_deprecated_1.ROUTER_PROVIDERS, http_1.HTTP_PROVIDERS, user_service_1.UserService, device_service_1.DeviceService],
            template: "\n      <nav-bar></nav-bar>\n      <router-outlet></router-outlet>\n    "
        }),
        router_deprecated_1.RouteConfig([
            { path: '/user-list', name: 'UserList', component: user_list_component_1.UserList, useAsDefault: true },
            { path: '/tag-list', name: 'TagList', component: tag_list_component_1.TagList }
        ]), 
        __metadata('design:paramtypes', [])
    ], AppComponent);
    return AppComponent;
}());
exports.AppComponent = AppComponent;
//# sourceMappingURL=app.component.js.map