/**
 * Created by Owner on 2/10/2017.
 */

import {Component} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ShowService} from '../show-service/show.service';

@Component({
    templateUrl: 'show-detail.component.html'
})
export class ShowDetailComponent {

    show: any = {};

    constructor(private route: ActivatedRoute, private showService: ShowService) {
        this.route.params.subscribe(
            params => {
                showService.getShowById(params['id'])
                    .subscribe(
                        show => this.show = show,
                        error => console.log(error)
                    );
            });
    }
}