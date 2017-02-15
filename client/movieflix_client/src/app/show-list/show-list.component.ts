/**
 * Created by Owner on 2/9/2017.
 */

import {Component} from '@angular/core';
import {ShowService} from '../show-service/show.service';
import {LoginPageComponent} from '../login-detail/login.component';
import {Http} from '@angular/http';
@Component({
    templateUrl: 'show-list.component.html',
    providers: [LoginPageComponent]
})
export class ShowListComponent {

    showList: any = [];

    constructor(private showService: ShowService,private http: Http) {

        showService.getShows()
            .subscribe(
                shows => this.showList = shows,
                error => console.log(error)
            );
    }

    deleteTitle(titleId:String)
    {
        this.showService.deleteShow(titleId.toString())
            .subscribe(
                success => {
                    return true;
                }
                ,error =>
                {
                    console.log(error)}
            );

    }
}