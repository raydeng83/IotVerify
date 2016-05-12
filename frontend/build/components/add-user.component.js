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
var user_1 = require('../models/user');
var user_service_1 = require('../services/user.service');
var phoneNumber_1 = require('../models/phoneNumber');
var phoneNumber_service_1 = require('../services/phoneNumber.service');
var AddUser = (function () {
    function AddUser(userService, PhoneNumberService) {
        this.userService = userService;
        this.PhoneNumberService = PhoneNumberService;
        this.newUser = new user_1.User();
        this.newPhoneNumber1 = new phoneNumber_1.PhoneNumber();
        this.newPhoneNumber2 = new phoneNumber_1.PhoneNumber();
        this.userAdded = false;
    }
    AddUser.prototype.onSubmit = function () {
        var _this = this;
        this.newUser.creationDate = new Date();
        this.newUser.tokenExpireTime = 60;
        this.newUser.type = 'normal';
        this.newPhoneNumber1.userId = this.newUser.userId;
        this.newPhoneNumber1.creationDate = new Date();
        this.newPhoneNumber1.userName = this.newUser.userName;
        this.newPhoneNumber2.userId = this.newUser.userId;
        this.newPhoneNumber2.creationDate = new Date();
        this.newPhoneNumber2.userName = this.newUser.userName;
        this.userService.addUser(this.newUser).subscribe(function (user) {
            _this.PhoneNumberService.addPhoneNumber(_this.newPhoneNumber1).subscribe(function (user) { }, function (err) { return console.error(err); }, function () { return console.log('done loading'); });
            _this.PhoneNumberService.addPhoneNumber(_this.newPhoneNumber2).subscribe(function (user) { }, function (err) { return console.error(err); }, function () { return console.log('done loading'); });
            _this.userAdded = true;
        }, function (err) { return console.error(err); }, function () { return console.log('done loading'); });
    };
    AddUser = __decorate([
        core_1.Component({
            selector: 'add-user',
            templateUrl: 'app/components/add-user.component.html'
        }), 
        __metadata('design:paramtypes', [user_service_1.UserService, phoneNumber_service_1.PhoneNumberService])
    ], AddUser);
    return AddUser;
}());
exports.AddUser = AddUser;
//# sourceMappingURL=add-user.component.js.map