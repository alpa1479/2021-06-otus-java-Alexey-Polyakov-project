import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginViewComponent } from './features/login-view/login-view.component';

import { WelcomeViewComponent } from './features/welcome-view/welcome-view.component';

const routes: Routes = [
  { path: 'welcome', component: WelcomeViewComponent },
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
  { path: 'login', component: LoginViewComponent },
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
