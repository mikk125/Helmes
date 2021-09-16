import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {RegistrationService} from "../service/registration.service";
import {Registration} from "../model/registration";

@Component({
  selector: 'app-registration-list',
  templateUrl: './registration-list.component.html',
  styleUrls: ['./registration-list.component.css']
})
export class RegistrationListComponent implements OnInit {

  registrations: Registration[] = []

  constructor(private router: Router, private registrationService: RegistrationService) { }

  ngOnInit(): void {
    this.registrationService.findAll().subscribe(registrations => {
      this.registrations = registrations;
    });
  }

  goToRegistration(regId: number) {
    this.router.navigateByUrl("/registrations/" + regId);
  }

}
