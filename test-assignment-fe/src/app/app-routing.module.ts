import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegistrationFormComponent} from "./registration-form/registration-form.component";
import {RegistrationListComponent} from "./registration-list/registration-list.component";

const routes: Routes = [
  {
    path: '', component: RegistrationFormComponent
  },
  {
    path: 'registrations/:id', component: RegistrationFormComponent
  },
  {
    path: 'registrations', component: RegistrationListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
