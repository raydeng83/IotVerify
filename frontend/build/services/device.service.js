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
var http_1 = require('@angular/http');
var DeviceService = (function () {
    function DeviceService(http) {
        this.http = http;
    }
    DeviceService.prototype.findDevicesByUserId = function (userId) {
        return this.http.post('http://localhost:8080/rest/device/userId', userId + '').map(function (res) { return res.json(); });
    };
    DeviceService.prototype.findAllDevices = function () {
        return this.http.get('http://localhost:8080/rest/device/allDevices').map(function (res) { return res.json(); });
    };
    DeviceService.prototype.deleteDevice = function (deviceId) {
        return this.http.delete('http://localhost:8080/rest/device/delete/' + deviceId).map(function (res) { return res; });
    };
    DeviceService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], DeviceService);
    return DeviceService;
}());
exports.DeviceService = DeviceService;
//# sourceMappingURL=device.service.js.map