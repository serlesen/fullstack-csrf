import { Component } from '@angular/core';

import { MyHttpClient } from './http-client';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  authenticated = false;

  constructor(private http: MyHttpClient) {}

  ngOnInit(): void {
    this.http.getCsrf();
  }

  onSignedIn(): void {
    this.authenticated = true;
  }
}
