import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HttpClientModule} from '@angular/common/http';
import {OAuthModule} from 'angular-oauth2-oidc';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {MaterialModule} from './core/material/material.module';
import {WelcomeViewComponent} from './features/welcome-view/welcome-view.component';
import {HeaderComponent} from './shared/components/header/header.component';
import {FooterComponent} from './shared/components/footer/footer.component';
import {ProjectsViewComponent} from './features/projects-view/projects-view.component';
import {RepositoryService} from './core/repository/repository.service';
import {AuthGuard} from "./shared/guard/auth.guard";
import {AuthService} from "./shared/services/auth/auth.service";

@NgModule({
  declarations: [
    AppComponent,
    WelcomeViewComponent,
    HeaderComponent,
    FooterComponent,
    ProjectsViewComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    HttpClientModule,
    AppRoutingModule,
    OAuthModule.forRoot({
      resourceServer: {
        allowedUrls: ["http://localhost:8080/api"],
        sendAccessToken: true
      }
    })
  ],
  providers: [RepositoryService, AuthGuard, AuthService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
