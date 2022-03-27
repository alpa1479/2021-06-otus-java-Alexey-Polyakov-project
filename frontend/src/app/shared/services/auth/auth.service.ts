import {Injectable} from "@angular/core";
import {AuthConfig, OAuthService} from "angular-oauth2-oidc";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authConfig: AuthConfig = {
    issuer: 'http://localhost:8484/realms/issue_tracker',
    clientId: 'issue_tracker_client',
    scope: 'openid profile email offline_access issue_tracker',
    responseType: 'code',
    redirectUri: window.location.origin + "/welcome",
    showDebugInformation: true
  }

  constructor(private oauthService: OAuthService) {
    this.oauthService.configure(this.authConfig);
    this.oauthService.setupAutomaticSilentRefresh();
    this.oauthService.loadDiscoveryDocumentAndTryLogin();
  }

  public loggedIn(): boolean {
    return window.location.href.includes("code") || (this.oauthService.hasValidAccessToken() && this.oauthService.hasValidIdToken());
  }

  public login(): void {
    this.oauthService.initCodeFlow();
  }

  public logout(): void {
    this.oauthService.logOut();
  }

  public canActivate(): Promise<boolean> {
    return this.oauthService.loadDiscoveryDocumentAndTryLogin().then(() => {
      if (this.loggedIn()) {
        return true;
      } else {
        this.oauthService.initCodeFlow()
        return false;
      }
    });
  }
}
