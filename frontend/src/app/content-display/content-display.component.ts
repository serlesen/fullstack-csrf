import { Component, ViewChild } from '@angular/core';
import { MyHttpClient } from '../http-client';
import { CommonModule } from '@angular/common';
import { NgForm, FormsModule} from '@angular/forms';

import {MatCardModule} from '@angular/material/card';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatButtonModule} from '@angular/material/button';

import {ContentInputComponent} from '../content-input/content-input.component';
import {Content} from '../content';

@Component({
  selector: 'app-content-display',
  templateUrl: './content-display.component.html',
  styleUrls: ['./content-display.component.css'],
  standalone: true,
  imports: [MatCardModule, CommonModule, ContentInputComponent]
})
export class ContentDisplayComponent {

  title: string = "";
  messages: string[] = [];

  constructor(private http: MyHttpClient) {}

  ngOnInit(): void {
    this.http.get(
      "/content",
    ).subscribe((data: Content) => this.title = data.message);

    this.http.get(
        "/messages",
      ).subscribe((data: Content[]) => this.messages = data.map(content => content.message));
  }

  onMessageCreated(message: string): void {
    this.messages.push(message);
  }
}
