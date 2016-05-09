import {Component} from '@angular/core';
import {ROUTER_DIRECTIVES} from '@angular/router-deprecated';


@Component({
  selector: 'nav-bar',
  directives:[ROUTER_DIRECTIVES],
  templateUrl: 'app/nav-bar.component.html',
  styleUrls:['app/nav-bar.component.css']
})
export class NavBar {

}
