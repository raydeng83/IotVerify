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
var phoneNumber_1 = require('../models/phoneNumber');
var AddUser = (function () {
    function AddUser() {
        this.newUser = new user_1.User();
        this.newPhoneNumber1 = new phoneNumber_1.PhoneNumber();
        this.newPhoneNumber2 = new phoneNumber_1.PhoneNumber();
    }
    AddUser = __decorate([
        core_1.Component({
            selector: 'add-user',
            templateUrl: 'app/components/add-user.component.html'
        }), 
        __metadata('design:paramtypes', [])
    ], AddUser);
    return AddUser;
}());
exports.AddUser = AddUser;
//# sourceMappingURL=add-user.component.js.map