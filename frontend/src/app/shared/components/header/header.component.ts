import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../services/auth/auth.service";


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  loggedIn: boolean;

  constructor(private authService: AuthService) {
  }

  ngOnInit(): void {
    this.loggedIn = this.authService.loggedIn();
  }

  public logout() {
    this.authService.logout();
  }

}
