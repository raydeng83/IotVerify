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
var log_1 = require('../models/log');
var log_service_1 = require('../services/log.service');
var LogComponent = (function () {
    function LogComponent(userService, deviceService, logService) {
        this.userService = userService;
        this.deviceService = deviceService;
        this.logService = logService;
        this.logs = [];
        this.devices = [];
    }
    LogComponent.prototype.getLogs = function () {
        var _this = this;
        this.logService.getLogs().subscribe(
        // the first argument is a function which runs on success
        function (logs) {
            _this.logs = logs;
            var _loop_1 = function(i) {
                var log = new log_1.Log();
                _this.userService.getUserByUserId(logs[i].userId).subscribe(function (user) {
                    log.logEventId = logs[i].logEventId;
                    log.eventName = logs[i].eventName;
                    log.eventDescription = logs[i].eventDescription;
                    log.userName = user.userName;
                    log.deviceUUID = logs[i].deviceUUID;
                    log.tagId = logs[i].tagId;
                    log.creationDate = logs[i].creationDate;
                    _this.logs.push(log);
                });
            };
            for (var i = 0; i < _this.logs.length; i++) {
                _loop_1(i);
            }
        }, 
        // the second argument is a function which runs on error
        function (err) { return console.error(err); }, 
        // the third argument is a function which runs on completion
        function () { return console.log('done loading'); });
    };
    LogComponent = __decorate([
        core_1.Component({
            selector: 'log',
            templateUrl: '/app/components/log.component.html'
        }), 
        __metadata('design:paramtypes', [user_service_1.UserService, device_service_1.DeviceService, log_service_1.LogService])
    ], LogComponent);
    return LogComponent;
}());
exports.LogComponent = LogComponent;
//# sourceMappingURL=log.component.js.map