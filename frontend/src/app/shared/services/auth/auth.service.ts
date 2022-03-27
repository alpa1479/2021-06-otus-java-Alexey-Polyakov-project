import {Injectable} from "@angular/core";
import {AuthConfig, OAuthService} from "angular-oauth2-oidc";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authConfig: AuthConfig = {
    issuer: 'http://localhost:8484/realms/issue_tracker',
    redirectUri: window.location.origin + "/welcome",
    clientId: 'issue_tracker_client',
    scope: 'openid profile email offline_access issue_tracker',
    responseType: 'code',
    showDebugInformation: true
  }

  constructor(private oauthService: OAuthService) {
    this.oauthService.configure(this.authConfig);
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
    this.oauthService.setupAutomaticSilentRefresh();
  }

  public loggedIn(): boolean {
    return this.oauthService.hasValidAccessToken();
  }

  public login(): void {
    this.oauthService.initCodeFlow();
  }

  public logoff(): void {
    this.oauthService.logOut();
  }
}
