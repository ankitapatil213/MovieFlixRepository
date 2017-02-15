/**
 * Created by Owner on 2/10/2017.
 */

import {Component} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {Router} from '@angular/router';
import {Http, Headers, RequestOptions} from '@angular/http';
import {UserService} from '../user-service/user.service';

@Component({
    templateUrl: 'login.html'
})
export class LoginPageComponent {

    constructor(private router: Router,private http: Http,private userService: UserService) {}

    onLogin(form: any) {

        let param1=encodeURIComponent(form.emailId);
        this.http.get('http://localhost:8080/movieflix_springapi/api/users/?param1='+param1)
            .subscribe(
                response => {

                    let obj_user=response.json();
                    /*localStorage.setItem('id_token', response.json().id_token);*/
                    if(obj_user.password===form.password){
                        this.router.navigate(['shows']);
                    }
                    else{
                        alert('Password incorrect');
                        return false;
                    }
                },
                error => {
                    alert(error.text());
                    console.log(error.text());
                }
            );
    }
    signUP()
    {

        this.router.navigate(['signup']);

    }

    /*constructor(private route: ActivatedRoute, private showService: ShowService) {
        this.route.params.subscribe(
            params => {
                showService.getShowById(params['id'])
                    .subscribe(
                        show => this.show = show,
                        error => console.log(error)
                    );
            });
    }*/
}