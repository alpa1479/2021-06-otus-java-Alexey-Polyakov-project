import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './core/material/material.module';
import { WelcomeViewComponent } from './features/welcome-view/welcome-view.component';
import { HeaderComponent } from './shared/components/header/header.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { LoginViewComponent } from './features/login-view/login-view.component';
import { RegisterViewComponent } from './features/register-view/register-view.component';
import { ProjectsViewComponent } from './features/projects-view/projects-view.component';

@NgModule({
  declarations: [
    AppComponent,
    WelcomeViewComponent,
    HeaderComponent,
    FooterComponent,
    LoginViewComponent,
    RegisterViewComponent,
    ProjectsViewComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MaterialModule,
    FlexLayoutModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
