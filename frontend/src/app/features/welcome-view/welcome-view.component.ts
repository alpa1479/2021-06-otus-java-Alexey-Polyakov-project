import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../shared/services/auth/auth.service";

@Component({
  selector: 'app-welcome-view',
  templateUrl: './welcome-view.component.html',
  styleUrls: ['./welcome-view.component.css']
})
export class WelcomeViewComponent implements OnInit {

  loggedIn: boolean;

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    this.loggedIn = this.authService.loggedIn();
  }

  public login() {
    this.authService.login();
  }
}
