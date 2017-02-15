/**
 * Created by Owner on 2/14/2017.
 */

import {Component} from '@angular/core';
import { Router } from "@angular/router";

@Component({

    template: `<div class="container" id="mainDiv1" >
<a class="navbar-brand" href=""></a>
<a (click)="navigateURL()" class="btn button-style" style="float:right;">Login</a>
</div>
<div class="container" id="mainDiv2" style="margin-top:150px;text-align:center;font-family:Verdana, Geneva, sans-serif;font-size:35px;">
<strong class="main-hading">MOVIEFLIX</strong>
    </div>`
})
export class AppStartComponent {

    constructor(private router: Router) { }
    navigateURL()
    {

        this.router.navigate(['login']);

    }
}
