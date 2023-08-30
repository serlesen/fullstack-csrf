import { Component, ViewChild, Output, EventEmitter } from '@angular/core';
import { NgForm, FormsModule} from '@angular/forms';
import { MyHttpClient } from '../http-client';

import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, FormsModule, MatButtonModule],
})
export class LoginFormComponent {

  @ViewChild('loginForm') loginForm!: NgForm;

  @Output() onLoginEvent = new EventEmitter();

  constructor(private http: MyHttpClient) {}

  onSubmit(): void {
    this.http.post(
      "/signIn",
      this.loginForm.value,
    ).subscribe((data: any) => this.onLoginEvent.emit());
  }

}
