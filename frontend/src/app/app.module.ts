import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { ContentDisplayComponent } from './content-display/content-display.component';
import { HeaderComponent } from './header/header.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ContentInputComponent } from './content-input/content-input.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LoginFormComponent,
    BrowserAnimationsModule,
    HttpClientModule,
    ContentDisplayComponent,
    ContentInputComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
