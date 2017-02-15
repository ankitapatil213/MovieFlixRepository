/**
 * Created by Owner on 2/10/2017.
 */

import  {Component} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

import { Router } from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({

    template: `<strong class="main-hading"><h1>MOVIEFLIX</h1></strong>
<div class="signin-form">

    <div class="container">

        <form class="form-signin" (ngSubmit)="onSubmit(userForm.value)"
                #userForm="ngForm">
            <h2 class="form-signin-heading">Sign Up</h2>


            <div class="form-group">
                <label>Email</label>
                <input  type="email" name="emailId" required class="form-control"
                       id="emailId" placeholder="example@domain.com" ngModel/>

            </div>

            <div class="form-group">
            <label>Password</label>
                <input  type="password" class="form-control"
                       placeholder="Password" name="password" id="password" ngModel
                       required  minlength="8"/>

            </div>
<input  type="hidden" class="form-control"
                        name="userRole" id="userRole" ngModel
                       value="user"  />

            <div class="form-group">
                <button type="submit" class="btn button-style" name="btn-signup">
                    <span class=""></span>Register</button>
                    <a (click)="navigateToLogin()" class="" style="float:right;">Cancel</a>
                 </div>



        </form>

    </div>
</div>
`

})
export class SignUpComponent {
    constructor(private router: Router,private http: Http) {}
    onSubmit(form: any)
    {
        form.userRole='user';
        console.log(form);

        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        let user = JSON.stringify(form);
        this.http.post('http://localhost:8080/movieflix_springapi/api/users',user,options)
            .subscribe(
                response => {
                    /*localStorage.setItem('id_token', response.json().id_token);*/
                    this.router.navigate(['mainpage']);
                },
                error => {
                    alert(error.text());
                    console.log(error.text());
                }
            );
    }

    navigateToLogin()
    {

        this.router.navigate(['login']);

    }
}