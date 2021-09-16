import {Component, OnInit} from '@angular/core';
import {RegistrationService} from "../service/registration.service";
import {Sector} from "../model/sector";
import {SectorService} from "../service/sector.service";
import {ActivatedRoute} from "@angular/router";
import {Registration} from "../model/registration";

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  sectors: Sector[] = [];
  registration: Registration;
  registered: boolean;
  containsSameSectors: boolean;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private sectorService: SectorService,
              private registrationService: RegistrationService,
              private route: ActivatedRoute
  ) {
    this.registration = new Registration();
  }

  ngOnInit(): void {
    this.sectorService.findAll().subscribe(data => {
      this.sectors = data;
    });
    let paramId = this.route.snapshot.paramMap.get('id');
    if (paramId !== null) {
      this.registrationService.getRegistrationById(Number(paramId)).subscribe(registration => {
          if (registration !== null) {
            this.registration = registration;
            this.registered = true;
          }
        }, error => {
          this.errorMessage = 'Something went wrong.';
          setTimeout(() => {
            this.errorMessage = '';
          }, 3000);
        }
      );
    }
  }

  saveRegistration() {
    if (this.isFormValid()) {
      this.registrationService.saveRegistration(this.registration).subscribe(newRegistration => {
          this.registration = newRegistration;
          this.registered = true;
          this.successMessage = 'Registration saved';
          setTimeout(() => {
            this.successMessage = '';
          }, 3000);
        }, error => {
          this.errorMessage = 'Something went wrong.';
          setTimeout(() => {
            this.errorMessage = '';
          }, 3000);
        }
      );
    }
  }

  updateRegistration() {
    if (this.isFormValid()) {
      this.registrationService.updateRegistration(this.registration).subscribe(updatedRegistration => {
          if (updatedRegistration !== null) {
            this.registration = updatedRegistration;
            this.successMessage = 'Registration updated';
            setTimeout(() => {
              this.successMessage = '';
            }, 3000);
          }
        }, error => {
          this.errorMessage = 'Something went wrong.';
          setTimeout(() => {
            this.errorMessage = '';
          }, 3000);
        }
      )
    }
  }

  isFormValid(): boolean {
    return this.registration.name.length > 0 && this.registration.terms && this.registration.sectors.length > 0 && !this.containsSameSectors;
  }

  setSectors(sectors: Sector[]): void {
    this.registration.sectors = sectors;
    this.containsSameGroupSectors();
  }

  containsSameGroupSectors(): void {
    this.containsSameSectors = false;
    let hashSet = this.getParentsHashSet();
    for (let currentKey1 of Object.keys(hashSet)) {
      for (let currentKey2 of Object.keys(hashSet)) {
        let array1 = hashSet[Number(currentKey1)];
        let array2 = hashSet[Number(currentKey2)];
        if (currentKey1 !== currentKey2 && array1.filter(s => s.parentSectorId === null)[0].id === array2.filter(s => s.parentSectorId === null)[0].id) {
          let intersection = array1.filter(v => array2.includes(v));
          let smallerParentsArray = (array1.length < array2.length) ? array1 : (array2.length < array1.length) ? array2 : null;
          if (JSON.stringify(intersection.sort()) === JSON.stringify(smallerParentsArray?.sort())) {
            this.containsSameSectors = true;
            break;
          }
        }
      }
    }
  }

  compareFn(c1: Sector, c2: Sector): boolean {
    return c1 && c2 ? c1.id === c2.id : c1 === c2;
  }

  private getParentsHashSet(): Record<number, Sector[]> {
    let result: Record<number, Sector[]> = {};
    for (let currentSector of this.registration.sectors) {
      result[currentSector.id] = this.getParents([], currentSector);
    }
    return result;
  }

  private getParents(result: Sector[], currentSector: Sector): Sector[] {
    if (currentSector?.parentSectorId !== null) {
      return this.getParents(result.concat(currentSector), this.sectors.filter(s => s.id === currentSector.parentSectorId)[0]);
    }
    return result.concat(currentSector);
  }

}
