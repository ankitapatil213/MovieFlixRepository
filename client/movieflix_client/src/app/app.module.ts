import {NgModule} from '@angular/core';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes} from '@angular/router';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent}  from './app.component';
import {FormsModule} from '@angular/forms';
import {UserListComponent} from './user-list/user-list.component';

import {LoginPageComponent} from './login-detail/login.component';
import {SignUpComponent} from './login-detail/signup.component';

import {UserDetailComponent} from './user-detail/user-detail.component';
import {NotFoundComponent} from './not-found/not-found.component';

import {ShowListComponent} from './show-list/show-list.component';

import {MainPageComponent} from './main-page/mainpage.component';
import {AppStartComponent} from './main-page/app-start.component';
import {ShowDetailComponent} from './show-detail/show-detail.component';
import {UserService} from './user-service/user.service';
import {ShowService} from './show-service/show.service';
const appRoutes: Routes = [


    {path: 'shows', component: ShowListComponent },
    {path: 'shows/:id', component: ShowDetailComponent},
    {path: 'login', component: LoginPageComponent},
    {path: 'signup', component: SignUpComponent},
    {path: 'mainpage', component: MainPageComponent},
    {path: 'appstart', component: AppStartComponent},
    {path: '', redirectTo: 'appstart', pathMatch: 'full'}
    /*
    {path: '**', component: NotFoundComponent}*/
];

@NgModule({
    imports: [BrowserModule, FormsModule ,HttpModule, RouterModule.forRoot(appRoutes,{useHash:true})],
    declarations: [AppComponent, UserListComponent,MainPageComponent,
        UserDetailComponent,LoginPageComponent,ShowListComponent,
        ShowDetailComponent ,NotFoundComponent,SignUpComponent,AppStartComponent],
    providers: [UserService,ShowService],
    bootstrap: [AppComponent]
})
export class AppModule {

}

console.log('Running');
