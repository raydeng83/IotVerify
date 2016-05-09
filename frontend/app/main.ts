import { bootstrap } from '@angular/platform-browser-dynamic';
import {AppComponent} from './app.component';
import {HTTP_PROVIDERS} from '@angular/http';
import 'rxjs/RX';
import {UserService} from './user.service';

bootstrap(AppComponent, [HTTP_PROVIDERS, UserService]);
