import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Registration} from "../model/registration";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private registrationUrl: string;

  constructor(private http: HttpClient) {
    this.registrationUrl = 'http://localhost:8080/registrations/';
  }

  public findAll(): Observable<Registration[]> {
    return this.http.get<Registration[]>(this.registrationUrl);
  }

  public getRegistrationById(id: number): Observable<Registration> {
    return this.http.get<Registration>(this.registrationUrl + id);
  }

  public saveRegistration(newRegistration: Registration) {
    return this.http.post<Registration>(this.registrationUrl + 'new', newRegistration);
  }

  public updateRegistration(updatedRegistration: Registration) {
    return this.http.put<Registration>(this.registrationUrl + 'update', updatedRegistration);
  }

}
