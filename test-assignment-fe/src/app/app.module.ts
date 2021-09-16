import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegistrationListComponent } from './registration-list/registration-list.component';
import { RegistrationFormComponent } from './registration-form/registration-form.component';
import {SectorService} from "./service/sector.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    RegistrationListComponent,
    RegistrationFormComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [SectorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
