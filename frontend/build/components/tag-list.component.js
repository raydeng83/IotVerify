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
var device_service_1 = require('../services/device.service');
var Tag_1 = require('../models/Tag');
var TagList = (function () {
    function TagList(userService, deviceService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.tags = [];
        this.devices = [];
        this.getUsers();
    }
    TagList.prototype.getUsers = function () {
        var _this = this;
        this.userService.getUsers().subscribe(
        // the first argument is a function which runs on success
        function (users) {
            _this.users = users;
            for (var i = 0; i < _this.users.length; i++) {
                _this.getDevices(_this.users[i].userId, i);
            }
        }, 
        // the second argument is a function which runs on error
        function (err) { return console.error(err); }, 
        // the third argument is a function which runs on completion
        function () { return console.log('done loading'); });
    };
    TagList.prototype.getDevices = function (userId, i) {
        var _this = this;
        this.deviceService.findDevicesByUserId(userId).subscribe(
        // the first argument is a function which runs on success
        function (devices) {
            for (var j = 0; j < devices.length; j++) {
                _this.devices.push(devices[j]);
                var tag = new Tag_1.Tag();
                tag.userName = _this.users[i].userName;
                tag.tagId = devices[j].tagId;
                tag.deviceName = devices[j].deviceName;
                tag.serialNo = devices[j].serialNo;
                tag.deviceUdid = devices[j].deviceCompUdid;
                tag.androidId = devices[j].androidId;
                _this.tags.push(tag);
            }
            ;
        }, 
        // the second argument is a function which runs on error
        function (err) { return console.error(err); });
    };
    TagList.prototype.getUserByUserId = function (userId) {
        this.userService.getUserByUserId(userId).subscribe(function (user) {
            console.log(user.userName);
            return user;
        }, function (err) { return console.error(err); }, function () { return console.log('done loading'); });
    };
    TagList = __decorate([
        core_1.Component({
            selector: 'tag-list',
            templateUrl: 'app/components/tag-list.component.html'
        }), 
        __metadata('design:paramtypes', [user_service_1.UserService, device_service_1.DeviceService])
    ], TagList);
    return TagList;
}());
exports.TagList = TagList;
//# sourceMappingURL=tag-list.component.js.map