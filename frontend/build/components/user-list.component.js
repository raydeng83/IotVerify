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
var user_service_1 = require('../services/user.service');
var UserList = (function () {
    function UserList(userService) {
        this.userService = userService;
        this.getUsers();
    }
    UserList.prototype.getUsers = function () {
        var _this = this;
        this.userService.getUsers().subscribe(
        // the first argument is a function which runs on success
        function (data) { _this.users = data; }, 
        // the second argument is a function which runs on error
        function (err) { return console.error(err); }, 
        // the third argument is a function which runs on completion
        function () { return console.log('done loading'); });
    };
    UserList.prototype.onDelete = function (userId) {
        var _this = this;
        this.userService.deleteUser(userId).subscribe(
        // the first argument is a function which runs on success
        function (data) { _this.getUsers(); }, 
        // the second argument is a function which runs on error
        function (err) { return console.error(err); }, 
        // the third argument is a function which runs on completion
        function () { return console.log('done loading'); });
    };
    UserList = __decorate([
        core_1.Component({
            selector: 'user-list',
            templateUrl: 'app/components/user-list.component.html'
        }), 
        __metadata('design:paramtypes', [user_service_1.UserService])
    ], UserList);
    return UserList;
}());
exports.UserList = UserList;
//# sourceMappingURL=user-list.component.js.map