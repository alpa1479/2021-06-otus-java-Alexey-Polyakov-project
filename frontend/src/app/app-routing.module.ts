import {CommonModule} from '@angular/common';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {ProjectsViewComponent} from './features/projects-view/projects-view.component';
import {WelcomeViewComponent} from './features/welcome-view/welcome-view.component';
import {AuthGuard} from "./shared/guard/auth.guard";

const routes: Routes = [
  {path: 'welcome', component: WelcomeViewComponent},
  {path: '', redirectTo: '/welcome', pathMatch: 'full'},
  {path: 'projects', component: ProjectsViewComponent, canActivate: [AuthGuard]},
  {path: 'projects/create', component: ProjectsViewComponent, canActivate: [AuthGuard]}
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
export class AppRoutingModule {
}
