import {bootstrap}    from 'angular2/platform/browser';
import {AppComponent} from './app.component';
import {HTTP_PROVIDERS} from 'angular2/http';
import 'rxjs/RX';
import {UserService} from './user.service';

bootstrap(AppComponent, [HTTP_PROVIDERS, UserService]);
