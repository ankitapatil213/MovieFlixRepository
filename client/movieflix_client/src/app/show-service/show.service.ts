/**
 * Created by Owner on 2/9/2017.
 */

import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class ShowService {
    constructor(private http: Http) {
    }

    getShows(): Observable<any[]> {
        return this.http.get('http://localhost:8080/movieflix_springapi/api/flixshows')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    getShowById(id: string): Observable<any[]> {
        return this.http.get(`http://localhost:8080/movieflix_springapi/api/flixshows/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    createShow(show: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('http://mocker.egen.io/users', show, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    updateShow(id: string, show: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.put(`http://mocker.egen.io/users/${id}`, show, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }


    deleteShow(id: string): Observable<any[]> {
        return this.http.delete(`http://localhost:8080/movieflix_springapi/api/flixshows/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
}

