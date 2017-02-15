/**
 * Created by Owner on 2/11/2017.
 */


import {Component} from '@angular/core';
import { Router } from "@angular/router";

@Component({

    template: `<h2>Thank you for sign up</h2>
               Click Here to Login
                   <a (click)="navigateURL()" class=""
                       style="float:right;">Login</a>`
})
export class MainPageComponent {

    constructor(private router: Router) { }
  navigateURL()
{

    this.router.navigate(['login']);

}
}