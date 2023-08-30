import { Component, ViewChild, Output, EventEmitter } from '@angular/core';
import { MyHttpClient } from '../http-client';
import { CommonModule } from '@angular/common';
import { NgForm, FormsModule} from '@angular/forms';

import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';

import {Content} from '../content';

@Component({
  selector: 'app-content-input',
  templateUrl: './content-input.component.html',
  styleUrls: ['./content-input.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, FormsModule, MatButtonModule],
})
export class ContentInputComponent {

  @ViewChild('messageForm') messageForm!: NgForm;

  @Output() onSubmitEvent = new EventEmitter<string>();

  constructor(private http: MyHttpClient) {}

  onSubmit(): void {
    this.http.post(
      "/messages",
      this.messageForm.value,
    ).subscribe((data: Content) => this.onSubmitEvent.emit(data.message));
  }

}
