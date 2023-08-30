import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MyHttpClient {

  csrfToken: string = "";

  constructor(private http: HttpClient) {}

  get(url: string): any {
    return this.http.get("http://localhost:8080" + url, {withCredentials: true});
  }

  post(url: string, data: any): any {
    return this.http.post(
      "http://localhost:8080" + url,
      data,
      {headers: new HttpHeaders({"X-CSRF-TOKEN": this.csrfToken}), withCredentials: true}
     );
  }

  getCsrf() {
    return this.http.get("http://localhost:8080/csrf/token", {withCredentials: true}
    ).subscribe((data: any) => this.csrfToken = data.token);
  }
}
