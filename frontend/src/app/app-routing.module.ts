import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProjectsViewComponent } from './features/projects-view/projects-view.component';
import { LoginViewComponent } from './features/login-view/login-view.component';
import { RegisterViewComponent } from './features/register-view/register-view.component';
import { WelcomeViewComponent } from './features/welcome-view/welcome-view.component';

const routes: Routes = [
  { path: 'welcome', component: WelcomeViewComponent },
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
  { path: 'login', component: LoginViewComponent },
  { path: 'register', component: RegisterViewComponent },
  { path: 'projects', component: ProjectsViewComponent }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
