import 'hammerjs';

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './core/material/material.module';
import { LayoutComponent } from './shared/layout/layout.component';
import { WelcomeViewComponent } from './features/welcome-view/welcome-view.component';
import { HeaderComponent } from './shared/navigation/header/header.component';
import { SidenavListComponent } from './shared/navigation/sidenav-list/sidenav-list.component';
import { FooterComponent } from './shared/navigation/footer/footer.component';
import { LoginViewComponent } from './features/login-view/login-view.component';
import { RegisterViewComponent } from './features/register-view/register-view.component';
import { ProjectsViewComponent } from './features/projects-view/projects-view.component';

@NgModule({
  declarations: [
    AppComponent,
    LayoutComponent,
    WelcomeViewComponent,
    HeaderComponent,
    SidenavListComponent,
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
