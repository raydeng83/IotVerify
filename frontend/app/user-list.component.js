System.register(['angular2/core', './user.service', './nav-bar.component'], function(exports_1, context_1) {
    "use strict";
    var __moduleName = context_1 && context_1.id;
    var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
        var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
        if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
        else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
        return c > 3 && r && Object.defineProperty(target, key, r), r;
    };
    var __metadata = (this && this.__metadata) || function (k, v) {
        if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
    };
    var core_1, user_service_1, nav_bar_component_1;
    var UserList;
    return {
        setters:[
            function (core_1_1) {
                core_1 = core_1_1;
            },
            function (user_service_1_1) {
                user_service_1 = user_service_1_1;
            },
            function (nav_bar_component_1_1) {
                nav_bar_component_1 = nav_bar_component_1_1;
            }],
        execute: function() {
            UserList = (function () {
                function UserList(_userService) {
                    this._userService = _userService;
                }
                UserList.prototype.ngOnInit = function () {
                    this.getUsers();
                };
                UserList.prototype.getUsers = function () {
                    var _this = this;
                    this._userService.getUsers().subscribe(
                    // the first argument is a function which runs on success
                    function (data) { _this.users = data; }, 
                    // the second argument is a function which runs on error
                    function (err) { return console.error(err); }, 
                    // the third argument is a function which runs on completion
                    function () { return console.log('done loading'); });
                };
                UserList = __decorate([
                    core_1.Component({
                        selector: 'user-list',
                        directives: [nav_bar_component_1.NavBar],
                        templateUrl: 'app/user-list.component.html'
                    }), 
                    __metadata('design:paramtypes', [user_service_1.UserService])
                ], UserList);
                return UserList;
            }());
            exports_1("UserList", UserList);
        }
    }
});
//# sourceMappingURL=user-list.component.js.map