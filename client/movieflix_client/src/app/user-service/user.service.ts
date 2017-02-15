import {Injectable} from '@angular/core';
import {Http, Headers, RequestOptions} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/throw';

@Injectable()
export class UserService {
    constructor(private http: Http) {
    }

    getUsers(): Observable<any[]> {
        return this.http.get('http://mocker.egen.io/users')
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    getUserById(id: string): Observable<any[]> {
        return this.http.get(`http://mocker.egen.io/users/${id}`)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    createUser(user: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post('http://mocker.egen.io/users', user, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }

    updateUser(id: string, user: any): Observable<any[]> {
        let headers = new Headers({'Content-Type': 'application/json'});
        let options = new RequestOptions({headers: headers});
        return this.http.post(`http://mocker.egen.io/users/${id}`, user, options)
            .map(response => response.json())
            .catch(error => Observable.throw(error.statusText));
    }
}

