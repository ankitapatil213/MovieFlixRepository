import {Component} from '@angular/core';

import { Router} from '@angular/router';
import {document} from "@angular/platform-browser/src/facade/browser";
@Component({
    selector: 'movieflix-app',
    template:`
<router-outlet></router-outlet>`
})
export class AppComponent {


    constructor(private router: Router) { }

}
